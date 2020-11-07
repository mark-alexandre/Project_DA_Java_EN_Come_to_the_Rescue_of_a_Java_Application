package com.hemebiotech.analytics;

import com.hemebiotech.utils.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;

public class AnalyticsCounter {

    private static final String resourcesPath = Constants.PROJECT_PATH.getName() + "resources" + File.separator;
    private static final String filePath = resourcesPath + "symptoms.txt";
    private static final String resultPath = resourcesPath + "result.out";

    public static void main(String args[]) throws Exception {

        // Get an ArrayList of all symptoms
        SymptomsReader symptomsObject = new SymptomsReader();
        ArrayList<String> symptoms = symptomsObject.getSymptoms(filePath);

        // Convert the ArrayList into a TreeMap
        SymptomsWriter writerObject = new SymptomsWriter();
        TreeMap<String, Integer> occurrencesObject = writerObject.countFrequencies(symptoms);

        // Write the output into a new file called result.out
        writerObject.writeResult(resultPath, occurrencesObject);

    }
}
