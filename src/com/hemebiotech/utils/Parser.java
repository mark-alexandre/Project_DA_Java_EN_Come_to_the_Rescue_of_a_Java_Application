package com.hemebiotech.utils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Parser {
    /**
     * Count the occurrences of a given ArrayList
     *
     * @param arrayList ArrayList
     * @return TreeMap<String, Integer>
     */
    public static Map<String, Integer> countFrequencies(List<String> arrayList) {
        Map<String, Integer> treeMap = new TreeMap<>();
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
    public static void displayCountFrequencies(TreeMap<String, Integer> treeMap) {
        treeMap.forEach((key, value) -> System.out.println("Frequency of " + key + " is " + value));
    }
}
