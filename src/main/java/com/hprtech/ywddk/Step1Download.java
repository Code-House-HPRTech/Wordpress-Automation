package com.hprtech.ywddk;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import restclient.NonVegStoryRestClient;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Path("/grab-data")
public class Step1Download {
    @RestClient
    NonVegStoryRestClient nonVegStoryRestClient;

    @GET
    @Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllData() {
        // Specify the file path
        String media = "C:\\xampp\\htdocs\\allmoviedownlad\\---------Data--------\\a3\\media.json";
        String posts = "C:\\xampp\\htdocs\\allmoviedownlad\\---------Data--------\\a3\\posts.json";
        String pages = "C:\\Users\\hp\\Desktop\\YWDDK\\inprogress\\a3\\pages.json";
        String category = "C:\\xampp\\htdocs\\allmoviedownlad\\---------Data--------\\a3\\category.json";
        String tags = "C:\\xampp\\htdocs\\allmoviedownlad\\---------Data--------\\a3\\tags.json";

        try {
            getAllMedia(media);
        } catch (Exception e) {

        }
        try {
            getAllPosts(posts);

        } catch (Exception e) {

        }
        try {
            getAllPages(pages);

        } catch (Exception e) {

        }
        try {
            getAllCategory(category);

        } catch (Exception e) {

        }
        try {
            getAllTags(tags);

        } catch (Exception e) {

        }

        return "Done";
    }

    private void getAllMedia(String path) {
        // Use try-with-resources to automatically close the resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            int i = 1;
            while (true) {
                System.out.println(">>>>>>>>>>>>> " + i);
                // Append the string to the file
                String response = nonVegStoryRestClient.getMedia(100, i);
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

    private void getAllPosts(String path) {
        // Use try-with-resources to automatically close the resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            int i = 1;
            while (true) {
                System.out.println(">>>>>>>>>>>>> " + i);
                // Append the string to the file
                String response = nonVegStoryRestClient.getPosts(50, i);
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
        System.out.println("Posts Done");
    }

    private void getAllPages(String path) {
        // Use try-with-resources to automatically close the resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            int i = 1;
            while (true) {
                System.out.println(">>>>>>>>>>>>> " + i);
                // Append the string to the file
                String response = nonVegStoryRestClient.getPages(50, i);
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
        System.out.println("Pages Done");
    }

    private void getAllTags(String path) {
        // Use try-with-resources to automatically close the resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            int i = 1;
            while (true) {
                System.out.println(">>>>>>>>>>>>> " + i);
                // Append the string to the file
                String response = nonVegStoryRestClient.getTags(50, i);
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
        System.out.println("Tags Done");
    }

    private void getAllCategory(String path) {
        // Use try-with-resources to automatically close the resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            int i = 1;
            while (true) {
                System.out.println(">>>>>>>>>>>>> " + i);
                // Append the string to the file
                String response = nonVegStoryRestClient.getCategories(50, i);
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
        System.out.println("Category Done");
    }
}
