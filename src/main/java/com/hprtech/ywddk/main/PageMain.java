package com.hprtech.ywddk.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class PageMain {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String myCategory = "C:\\Users\\hp\\Desktop\\YWDDK\\ywddk_data\\pages.json";
        File myfile = new File(myCategory);
        List<JsonNode> myPostList = objectMapper.readValue(myfile, objectMapper.getTypeFactory().constructCollectionType(List.class, JsonNode.class));


        String csvFilePath = "C:\\Users\\hp\\Desktop\\YWDDK\\pages.csv";
        try {
            // Read JSON file into JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File(myCategory));

            // Create CSVWriter for the output CSV file with proper settings
            try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath), CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END)) {
                // Write header to CSV file
                writeHeader(csvWriter, jsonNode);

                // Write data to CSV file
                writeData(csvWriter, jsonNode);
            }

            System.out.println("Conversion successful. CSV file created at: " + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeHeader(CSVWriter csvWriter, JsonNode jsonNode) {
        // Assuming the first object in the array contains all possible fields
        Iterator<String> fieldNamesIterator = jsonNode.elements().next().fieldNames();
        String[] header = new String[jsonNode.elements().next().size()];
        int index = 0;
        while (fieldNamesIterator.hasNext()) {
            header[index++] = fieldNamesIterator.next();
        }
        csvWriter.writeNext(header);
    }

    private static void writeData(CSVWriter csvWriter, JsonNode jsonNode) {
        jsonNode.elements().forEachRemaining(objectNode -> {
            Iterator<JsonNode> elements = objectNode.elements();
            String[] rowData = new String[objectNode.size()];
            int index = 0;
            while (elements.hasNext()) {
                // Escape and quote text containing double quotes
                rowData[index++] = elements.next().toString().replace("\"", "\"\"");
            }
            csvWriter.writeNext(rowData);
        });
    }
}