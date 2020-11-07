package com.hemebiotech.analytics;


import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public interface IParser {
    ArrayList<String> reader(String inputPath);
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
