package com.hprtech.ywddk.importer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hprtech.ywddk.util.DecodeToHindi;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CategoryImporter {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Specify the path to your JSON file
            String filePath = "C:\\Users\\hp\\Desktop\\YWDDK\\data\\categories.json";
            File file = new File(filePath);

            // Read JSON array from file and convert it to a List of objects
            List<JsonNode> myObjects = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, JsonNode.class));

            // Do something with the list of objects
            System.out.printf(String.valueOf(myObjects.size()));
            for (JsonNode obj : myObjects) {
                try {
                    System.out.println( DecodeToHindi.decodeUnicode(obj.get("slug").asText())); //+ ","
//                            + DecodeToHindi.decodeUnicode(obj.get("description").asText()));
                } catch (Exception e) {
                    System.err.println("Error downloading image: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
