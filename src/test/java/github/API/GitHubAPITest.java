package github.API;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class GitHubAPITest {

    @Test
    public void testGetUserProfile() throws IOException {
        // Replace "username" with the GitHub username you want to retrieve information for
        String username = "serhii-bohdanov";

        // Create an OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // Build the request
        Request request = new Request.Builder()
                .url("https://api.github.com/users/" + username)
                .build();

        // Execute the request and handle the response
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            System.out.println(response.body().string()); // Print the response body
        }
    }
}
