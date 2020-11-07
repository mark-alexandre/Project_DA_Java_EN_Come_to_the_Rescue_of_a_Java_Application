package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsWriter {
    public TreeMap<String, Integer> countFrequencies(ArrayList<String> list)
    {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        for (String t : list) {
            Integer c = treeMap.get(t);
            treeMap.put(t, (c == null) ? 1 : c + 1);
        }
        return treeMap;
    }

    public void displayCountFrequencies(TreeMap<String, Integer> treeMap)
    {
        for (Map.Entry m : treeMap.entrySet())
            System.out.println("Frequency of " + m.getKey() + " is " + m.getValue());
    }
}
