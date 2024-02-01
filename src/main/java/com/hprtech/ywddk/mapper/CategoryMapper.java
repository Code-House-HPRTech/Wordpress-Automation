package com.hprtech.ywddk.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryMapper {
    public static void main(String[] args) throws IOException {
        System.out.println(mapCategory());
    }
    public static Map<Integer, String> mapCategory() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Integer,String> categoryMap = new HashMap<>();
        String myCategory = "C:\\xampp\\htdocs\\allmoviedownlad\\---------Data--------\\a3\\category.json";
        File myfile = new File(myCategory);
        List<JsonNode> myCategoryList = objectMapper.readValue(myfile, objectMapper.getTypeFactory().constructCollectionType(List.class, JsonNode.class));

        // Iterate through each element in the first array
        for (JsonNode element1 : myCategoryList) {
            // Extract name and id from the first array
            String name1 = element1.get("name").asText();
            int id1 = element1.get("id").asInt();
            categoryMap.put(id1,name1);
        }
        return categoryMap;
    }
}
