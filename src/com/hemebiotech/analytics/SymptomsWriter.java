package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class SymptomsWriter {
    public TreeMap<String, Integer> countFrequencies(ArrayList<String> list) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        for (String t : list) {
            Integer c = treeMap.get(t);
            treeMap.put(t, (c == null) ? 1 : c + 1);
        }
        return treeMap;
    }

    public void displayCountFrequencies(TreeMap<String, Integer> treeMap) {
        treeMap.forEach((key, value) -> System.out.println("Frequency of " + key + " is " + value));
    }

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
