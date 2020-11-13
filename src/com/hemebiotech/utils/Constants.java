package com.hemebiotech.utils;

import java.io.File;

public enum Constants {

    PROJECT_PATH(System.getProperty("user.dir") + File.separator);

    private final String name;

    Constants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
