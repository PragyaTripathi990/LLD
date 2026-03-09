package com.example.metrics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MetricsLoader {

    public MetricsRegistry loadFromFile(String path) throws IOException {
        Properties config = new Properties();
        try (FileInputStream stream = new FileInputStream(path)) {
            config.load(stream);
        }

        MetricsRegistry instance = MetricsRegistry.getInstance();

        for (String name : config.stringPropertyNames()) {
            String rawVal = config.getProperty(name, "0").trim();
            long count;
            try {
                count = Long.parseLong(rawVal);
            } catch (NumberFormatException e) {
                count = 0L;
            }
            instance.setCount(name, count);
        }
        return instance;
    }
}
