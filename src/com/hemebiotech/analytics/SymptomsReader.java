package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * SymptomsReader class combines a set of methods which will fetch data of a file.
 */
public class SymptomsReader {

    /**
     * Get symptoms in an ArrayList.
     *
     * @param filePath String
     * @return ArrayList<String>
     */
    public ArrayList<String> getSymptoms(String filePath) {
        ArrayList<String> result = new ArrayList<String>();

        if (filePath != null) {
            try {
                BufferedReader file = new BufferedReader(new FileReader(filePath));
                String line;

                while ((line = file.readLine()) != null) {
                    result.add(line);
                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
