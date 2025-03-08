import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

@WebFilter("/filtering")
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Get the IP address of client machine.
        String ipAddress = servletRequest.getRemoteAddr();

        // Log the IP address and current timestamp.
        System.out.println( "IP Address: " + ipAddress + " | Timestamp: " + new Date().toString());

        // Pass request back down the filter chain
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Get init parameter
        String testParam = filterConfig.getInitParameter( "test-Param");

        // Print the init parameter
        System.out.println( "Init parameter: " + testParam);
    }

    @Override
    public void destroy() {
        /* Called before the Filter instance is removed from service by the web container*/
    }
}
