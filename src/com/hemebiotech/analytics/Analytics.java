package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Symptoms analytics dedicated class
 */
public class Analytics implements IParser {
    /**
     * Get symptoms from a file and return an ArrayList of String.
     *
     * @param filePath String
     * @return ArrayList<String>
     */
    public List<String> reader(String filePath) {
        List<String> result = new ArrayList<>();

        // Try with Resources used, which allows us to declare resources to be used in a try block with the assurance
        // that the resources will be closed after the execution of that block.
        if (filePath != null) {
            try (BufferedReader file = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = file.readLine()) != null) {
                    result.add(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Create or update a file from a given TreeMap
     *
     * @param filePath String
     * @param data TreeMap<String, Integer>
     */
    public void writer(String filePath, Map<String, Integer> data) {

        // Try with Resources
        try (FileWriter writer = new FileWriter(filePath)) {
            data.forEach((key, value) -> {
                try {
                    writer.write(key + "=" + value.toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
