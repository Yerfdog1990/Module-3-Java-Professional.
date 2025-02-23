import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HttpClientExampleTest {
  HttpClient client = HttpClient.newHttpClient();

  @Test
  @DisplayName("Synchronous request test")
  void synchronousRequestTest() throws IOException, InterruptedException {
    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
            .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    assertEquals(200, response.statusCode());
    assertTrue(response.body().contains("userId"));
    System.out.println("Synchronous request:\nAfter completion " + response.body());
  }

  @Test
  @DisplayName("Asynchronous request test")
  void asynchronousRequestTest() throws IOException, InterruptedException, ExecutionException {
    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
            .build();

    CompletableFuture<HttpResponse<String>> futureResponse =
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

    HttpResponse<String> response = futureResponse.get();

    assertEquals(200, response.statusCode());
    assertTrue(response.body().contains("userId"));
    System.out.println("Asynchronous request:\nAfter completion " + response.body());
    System.out.println("Asynchronous request:\nAfter async call");
  }

  @Test
  @DisplayName("Test post request")
  void postRequestTest() throws IOException, InterruptedException {
    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
            .header("Content-Type", "application/json")
            .POST(
                HttpRequest.BodyPublishers.ofString(
                    "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}"))
            .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    assertEquals(201, response.statusCode());
    assertTrue(response.body().contains("id"));
    System.out.println("Post request: \nAfter completion " + response.body());
  }

  @Test
  @DisplayName("BodyHandlers.ofLines test")
  void testBodyHandlersOfLines() throws IOException, InterruptedException {
    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
            .header("Content-Type", "application/json")
            .build();
    var response = client.send(request, HttpResponse.BodyHandlers.ofLines());
    response.body().forEach(System.out::println);
  }
}
