package com.hemebiotech.analytics;

import com.hemebiotech.utils.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static String resourcesPath = Constants.PROJECT_PATH.getName() + "resources" + File.separator;
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
			System.out.println("symptom from file: " + line);
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
	}
}
