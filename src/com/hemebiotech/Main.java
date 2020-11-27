package com.hemebiotech;

import com.hemebiotech.analytics.Analytics;
import com.hemebiotech.analytics.IParser;
import com.hemebiotech.utils.Constants;
import com.hemebiotech.utils.SymptomsUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Main class used exclusively for the execution of our application
 */
public class Main {

    private static final String resourcesPath = Constants.PROJECT_PATH.getName() + "resources" + File.separator;
    private static final String filePath = resourcesPath + "symptoms.txt";
    private static final String resultPath = resourcesPath + "result.out";

    /**
     * Main method which will executes our application
     * @param args Optional arguments (String[])
     */
    public static void main(String[] args) {

        if(args.length == 0) {
            // Get an ArrayList of all symptoms
            IParser parser = new Analytics();
            List<String> symptoms = parser.reader(filePath);

            // Convert the ArrayList into a TreeMap, in order to have unique keys (symptoms) with values representing
            // the occurrences of the symptoms
            Map<String, Integer> occurrences = SymptomsUtils.countFrequencies(symptoms);

            // Log the result before writing it
            SymptomsUtils.logCountFrequencies(occurrences);

            // Write the output into a new file called result.out
            parser.writer(resultPath, occurrences);
        } else {
            System.out.println("At this stage, no parameter is required to compile this application!");
        }

    }
}
