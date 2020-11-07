package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;


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
    public ArrayList<String> reader(String filePath) {
        ArrayList<String> result = new ArrayList<String>();

        if (filePath != null) {
            try {
                BufferedReader file = new BufferedReader(new FileReader(filePath));
                String line;

                while ((line = file.readLine()) != null) {
                    result.add(line);
                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Create or update a file from a given TreeMap
     *
     * @param filePath String
     * @param treeMap TreeMap<String, Integer>
     * @throws IOException Signals that an I/O exception of some sort has occurred
     */
    public void writer(String filePath, TreeMap<String, Integer> treeMap) throws IOException {
        FileWriter writer = new FileWriter(filePath);

        treeMap.forEach((key, value) -> {
            try {
                writer.write(key + "=" + value.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.close();
    }
}
