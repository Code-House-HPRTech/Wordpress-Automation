package com.hprtech.ywddk.dummy;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlResponseExample {

    public static void main(String[] args) {

        String path = "C:\\Users\\hp\\Desktop\\YWDDK\\inprogress\\a3\\pages.json";
        String url = "https://www.antarvasna3.com/wp-json/wp/v2/tags"; // Replace this with your URL


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            int i = 1;
            while (true) {
                System.out.println(">>>>>>>>>>>>> " + i);
                // Append the string to the file
                String response = getResponseFromUrl("https://www.antarvasna3.com/wp-json/wp/v2/pages?per_page=100&page=" + i);
                if (!response.equalsIgnoreCase("[]")) {
                    writer.write(response);
                    writer.write("\n\n\n\n");
                    i++;
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            // Handle exceptions
            e.printStackTrace();
        }
        System.out.println("Media Done");
    }

    private static String getResponseFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Set the User-Agent header (optional)
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        // Get the response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read the response content
        StringBuilder responseStringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                responseStringBuilder.append(line);
            }
        } catch (IOException e) {
            // If you want to get the error stream for a 403 response, you can use:
            // InputStream errorStream = connection.getErrorStream();
            throw e;
        } finally {
            connection.disconnect();
        }

        return responseStringBuilder.toString();
    }
}
