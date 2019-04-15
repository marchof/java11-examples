package java11.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

/**
 * New HTTP Client API.
 */
public class HttpClientExample {

	public static void main(String[] args) throws IOException, InterruptedException {
		var client = HttpClient.newBuilder() //
				.followRedirects(Redirect.NEVER) //
				.connectTimeout(Duration.ofSeconds(10)) //
				.build();

		var request = HttpRequest.newBuilder() //
				.uri(URI.create("https://www.sbb.ch/")) //
				.build();

		// %[// TODO: Rewrite to asynchronous line-by-line handling
		// %[HttpResponse<String> response = 
		// %[ client.send(request, BodyHandlers.ofString());
		// %[System.out.println(response.body());
		client.sendAsync(request, BodyHandlers.ofLines()) //
				.thenApply(HttpResponse::body) //
				.thenAccept(lines -> lines.forEach(System.out::println)) //
				.join();
		// ]%
	}

}
