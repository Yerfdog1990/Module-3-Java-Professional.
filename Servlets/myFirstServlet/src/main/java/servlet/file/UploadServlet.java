package servlet.file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

// FIXME Servlet form failed to work.
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 10 * 1024 * 1024; // 10 MB
    private int maxMemSize = 4 * 1024;         // 4 KB

    @Override
    public void init() {
        // Get the file upload directory from the web.xml context-param
        filePath = getServletContext().getInitParameter("file-upload");

        // Ensure the filePath is set and the directory exists
        if (filePath == null) {
            throw new RuntimeException("File upload directory not defined in web.xml");
        }
        File uploadDir = new File(filePath);
        if (!uploadDir.exists() && !uploadDir.mkdirs()) {
            throw new RuntimeException("Failed to create upload directory: " + filePath);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        // Check if the request is a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();

        if (!isMultipart) {
            // If the request is not multipart, show an error response
            out.println("<html><body><p>No file uploaded</p></body></html>");
            return;
        }

        // Configure DiskFileItemFactory
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxMemSize);

        // Use a temporary directory for larger data
        File tempDir = new File(System.getProperty("java.io.tmpdir")); // Cross-platform temp directory
        factory.setRepository(tempDir);

        // Configure the ServletFileUpload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(maxFileSize);

        try {
            // Parse the request to extract file items
            List<FileItem> fileItems = upload.parseRequest(request);

            // Start the response output
            out.println("<html><body>");

            // Process each file item
            for (FileItem fi : fileItems) {
                if (!fi.isFormField()) {
                    // Get file name and size
                    String fileName = fi.getName();
                    long fileSize = fi.getSize();

                    // Ensure the fileName is valid and not empty
                    if (fileName == null || fileName.isEmpty()) {
                        out.println("<p>Invalid file name</p>");
                        continue;
                    }

                    // Normalize the file name for safety
                    fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);

                    // Save the file to the specified directory
                    File file = new File(filePath + File.separator + fileName);
                    fi.write(file);

                    // Output uploaded file details
                    out.println("<p>Uploaded Filename: " + fileName + "<br>");
                    out.println("Size: " + fileSize + " bytes</p>");
                }
            }

            // End the response output
            out.println("</body></html>");
        } catch (Exception ex) {
            // Handle exceptions and return a 500 status
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("<html><body><p>Upload failed: " + ex.getMessage() + "</p></body></html>");
            ex.printStackTrace(); // Log for server-side debugging
        } finally {
            // Clean up resources if needed
            out.flush();
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        throw new ServletException("GET method is not supported for this endpoint. Use POST instead.");
    }
}