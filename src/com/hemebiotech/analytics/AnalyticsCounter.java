package com.hemebiotech.analytics;

import com.hemebiotech.utils.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	private static String resourcesPath = Constants.PROJECT_PATH.getName() + "resources" + File.separator;
	private static String filePath = resourcesPath + "symptoms.txt";
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {

		// Fetch the file
		FileReader readerArg = new FileReader(resourcesPath + "symptoms.txt");
		BufferedReader file = new BufferedReader (readerArg);

		// Read the file
		String line;
		int i = 0;
		while ( (line = file.readLine() ) != null) {
			i++;
			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.equals("dilated pupils")) {
				pupilCount++;
			}
		}
		
		// Generate output in a new file
		FileWriter writer = new FileWriter (resourcesPath + "result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dilated pupils: " + pupilCount + "\n");
		writer.close();

		SymptomsReader symptomsObject = new SymptomsReader();
		ArrayList<String> symptoms = symptomsObject.getSymptoms(filePath);
		//symptoms.forEach(System.out::println);
		symptomsObject.countFrequencies(symptoms);
	}
}
