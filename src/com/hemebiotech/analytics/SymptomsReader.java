package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 */
public class SymptomsReader implements ISymptomsReader {
	
	@Override
	public ArrayList<String> getSymptoms(String filepath) {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader file = new BufferedReader (new FileReader(filepath));
				String line;
				
				while ((line = file.readLine() ) != null) {
					result.add(line);
				}
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

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
