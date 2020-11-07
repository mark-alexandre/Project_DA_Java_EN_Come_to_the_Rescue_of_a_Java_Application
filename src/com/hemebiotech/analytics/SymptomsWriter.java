package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * SymptomsWriter class combines a set of methods to create a file from a TreeMap and to count occurrences of elements
 * of the given object.
 */
public class SymptomsWriter {
    /**
     * Count the occurrences of a given ArrayList
     *
     * @param arrayList ArrayList
     * @return TreeMap<String, Integer>
     */
    public TreeMap<String, Integer> countFrequencies(ArrayList<String> arrayList) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        for (String t : arrayList) {
            Integer c = treeMap.get(t);
            treeMap.put(t, (c == null) ? 1 : c + 1);
        }
        return treeMap;
    }

    /**
     * Helper's method, used for debugging purposes
     *
     * @param treeMap TreeMap<String, Integer>
     */
    public void displayCountFrequencies(TreeMap<String, Integer> treeMap) {
        treeMap.forEach((key, value) -> System.out.println("Frequency of " + key + " is " + value));
    }

    /**
     * Create or update a file from a given TreeMap
     *
     * @param filePath String
     * @param treeMap TreeMap<String, Integer>
     * @throws IOException e
     */
    public void writeResult(String filePath, TreeMap<String, Integer> treeMap) throws IOException {
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
