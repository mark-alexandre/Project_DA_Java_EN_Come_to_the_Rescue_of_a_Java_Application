package com.hemebiotech;

import com.hemebiotech.analytics.Analytics;
import com.hemebiotech.utils.Constants;
import com.hemebiotech.utils.Parser;

import java.io.File;
import java.io.IOException;
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
     * @param args String[] arguments
     * @throws IOException Signals that an I/O exception of some sort has occurred
     */
    public static void main(String[] args) throws IOException {

        if(args.length == 0) {
            // Get an ArrayList of all symptoms
            Analytics parser = new Analytics();
            List<String> symptoms = parser.reader(filePath);

            // Convert the ArrayList into a TreeMap, in order to have unique keys (symptoms) with values representing
            // the occurrences of the symptoms
            Map<String, Integer> occurrences = Parser.countFrequencies(symptoms);

            // Write the output into a new file called result.out
            parser.writer(resultPath, occurrences);
        } else {
            System.out.println("At this stage, no parameter is required to compile this application!");
        }

    }
}
