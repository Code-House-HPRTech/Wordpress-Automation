package com.hprtech.ywddk.util;
import com.hprtech.ywddk.contants.Constant;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class ReplaceStringInFiles {
    public static void main(String[] args) {
        // Specify the list of file paths
        List<String> filePaths = Constant.filePaths;

        // String to be replaced
        String stringToReplace = "]\n" +
                "\n" +
                "\n" +
                "\n" +
                "[";

        for (String filePath : filePaths) {
            try {
                // Read the file contents into a single string
                Path path = Paths.get(filePath);
                String content = Files.readString(path);

                // Replace the specified string with ","
                String modifiedContent = replaceString(content, stringToReplace, ",");

                // Write the modified contents back to the file
                Files.write(path, modifiedContent.getBytes());

                System.out.println("File updated successfully: " + filePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String replaceString(String content, String stringToReplace, String replacement) {
        return content.replace(stringToReplace, replacement);
    }
}
