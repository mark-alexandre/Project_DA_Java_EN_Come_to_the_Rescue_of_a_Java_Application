package com.hemebiotech;

import com.hemebiotech.analytics.SymptomsReader;
import com.hemebiotech.analytics.SymptomsWriter;
import com.hemebiotech.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Main class used exclusively for the execution of our application
 */
public class Main {

    private static final String resourcesPath = Constants.PROJECT_PATH.getName() + "resources" + File.separator;
    private static final String filePath = resourcesPath + "symptoms.txt";
    private static final String resultPath = resourcesPath + "result.out";

    /**
     * Main method which will executes our application
     * @param args String[] arguments
     * @throws IOException Signals that an I/O exception of some sort has occurred
     */
    public static void main(String[] args) throws IOException {

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
