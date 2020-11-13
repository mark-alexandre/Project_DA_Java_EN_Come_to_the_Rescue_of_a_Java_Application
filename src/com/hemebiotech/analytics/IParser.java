package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This interface was implemented in order to manage everything related to data parsing. Because Java 9 and above allows
 * to use static method, several helpers methods has been directly put here
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
