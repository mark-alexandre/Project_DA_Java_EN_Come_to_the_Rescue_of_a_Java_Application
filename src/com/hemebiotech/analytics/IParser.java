package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * This interface was implemented in order to manage everything related to data parsing.
 */
public interface IParser {
    /**
     * Reader method
     *
     * @param inputPath Either a file path or URL for the input
     * @return List<String>
     */
    List<String> reader(String inputPath);

    /**
     * Writer method
     *
     * @param outputPath String
     * @param data Map<String, Integer>
     */
    void writer(String outputPath, Map<String, Integer> data);
}
