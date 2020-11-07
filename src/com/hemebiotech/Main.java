package com.hemebiotech;

import com.hemebiotech.analytics.Analytics;
import com.hemebiotech.analytics.IParser;
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
        Analytics parser = new Analytics();
        ArrayList<String> symptoms = parser.reader(filePath);

        // Convert the ArrayList into a TreeMap, in order to have unique keys (symptoms) with values representing the
        // occurrences of the symptoms
        TreeMap<String, Integer> occurrences = IParser.countFrequencies(symptoms);

        // Write the output into a new file called result.out
        parser.writer(resultPath, occurrences);

    }
}
