package com.hemebiotech.utils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsUtils {
    /**
     * Count the occurrences of a given List
     *
     * @param data Data to be parsed (ArrayList)
     * @return A Map object with String indexes as keys and occurrence as value (Map<String, Integer>)
     */
    public static Map<String, Integer> countFrequencies(List<String> data) {
        Map<String, Integer> treeMap = new TreeMap<>();
        for (String t : data) {
            Integer c = treeMap.get(t);
            treeMap.put(t, (c == null) ? 1 : c + 1);
        }
        return treeMap;
    }

    /**
     * Helper's method, used for debugging purposes. It allows to display the frequency of a key.
     *
     * @param data Data to be parsed (Map<String, Integer>)
     */
    public static void displayCountFrequencies(Map<String, Integer> data) {
        data.forEach((key, value) -> System.out.println("Frequency of " + key + " is " + value));
    }
}
