package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * This interface was implemented in order to manage everything related to data parsing. Because Java 9 and above allows
 * to use static method, several helpers methods has been directly put here
 */
public interface IParser {
    /**
     * Reader method
     *
     * @param inputPath Either a file path or URL for the input
     * @return ArrayList<String>
     */
    ArrayList<String> reader(String inputPath);

    /**
     * Writer method
     *
     * @param outputPath String
     * @param data TreeMap<String, Integer>
     * @throws IOException Stack traces
     */
    void writer(String outputPath, TreeMap<String, Integer> data) throws IOException;

    /**
     * Count the occurrences of a given ArrayList
     *
     * @param arrayList ArrayList
     * @return TreeMap<String, Integer>
     */
    static TreeMap<String, Integer> countFrequencies(ArrayList<String> arrayList) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
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
    static void displayCountFrequencies(TreeMap<String, Integer> treeMap) {
        treeMap.forEach((key, value) -> System.out.println("Frequency of " + key + " is " + value));
    }
}
