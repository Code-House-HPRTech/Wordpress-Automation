package com.hprtech.ywddk.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediaMapper {
    public static void main(String[] args) throws IOException {
        System.out.println(mapMedia());
    }

    public static Map<Integer, Integer> mapMedia() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Integer, Integer> postMap = new HashMap<>();
        String otherpost = "C:\\Users\\hp\\Desktop\\YWDDK\\inprogress\\antterwasnayestory\\media.json";
        File file = new File(otherpost);
        List<JsonNode> theirpostList = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, JsonNode.class));

        String mypost = "C:\\Users\\hp\\Desktop\\YWDDK\\inprogress\\rangeenraatein\\media.json";
        File myfile = new File(mypost);
        List<JsonNode> mypostList = objectMapper.readValue(myfile, objectMapper.getTypeFactory().constructCollectionType(List.class, JsonNode.class));

        // Iterate through each element in the first array
        for (JsonNode element1 : theirpostList) {
            // Extract name and id from the first array
            int id1 = element1.get("id").asInt();

            // Iterate through each element in the second array
            for (JsonNode element2 : mypostList) {
                // Extract name and id from the second array
                String name2 = element2.get("guid").get("rendered").asText();
                String[] xx = name2.split("\\.");
                String[] s = xx[xx.length-2].split("_");

                int theirId = Integer.parseInt(s[s.length-1]);

                int myId = element2.get("id").asInt();

                // Check if names match
                if (theirId == id1) {
                    // Map the ids if names match
                    postMap.put(id1, myId);
                    // If you want to break after the first match, you can add a break statement here
                    // break;
                }
            }
        }
        return postMap;
    }
}
