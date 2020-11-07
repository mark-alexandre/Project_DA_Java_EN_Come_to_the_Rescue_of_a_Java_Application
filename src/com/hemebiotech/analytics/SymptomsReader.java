package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 */
public class SymptomsReader implements ISymptomsReader {

	private String filepath;
	
//	/**
//	 * Constructor method
//	 *
//	 * @param filepath a full or partial path to file with symptom strings in it, one per line
//	 */
//	public SymptomsReader(String filepath) {
//		this.filepath = filepath;
//	}
	
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

	public void countFrequencies(ArrayList<String> list)
	{

		TreeMap<String, Integer> tmap = new TreeMap<String, Integer>();
		for (String t : list) {
			Integer c = tmap.get(t);
			tmap.put(t, (c == null) ? 1 : c + 1);
		}

		for (Map.Entry m : tmap.entrySet())
			System.out.println("Frequency of " + m.getKey() + " is " + m.getValue());
	}

}
