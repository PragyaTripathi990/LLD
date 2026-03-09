package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Long> metrics = new HashMap<>();

    private static volatile boolean initialized = false;

    private MetricsRegistry() {
        if (initialized) {
            throw new IllegalStateException("Use getInstance() — reflection not allowed");
        }
        initialized = true;
    }

    private static class SingletonHolder {
        private static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Serial
    private Object readResolve() {
        return getInstance();
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(metrics));
    }

    public synchronized long getCount(String name) {
        return metrics.getOrDefault(name, 0L);
    }

    public synchronized void setCount(String name, long val) {
        metrics.put(name, val);
    }

    public synchronized void increment(String name) {
        metrics.put(name, getCount(name) + 1);
    }
}
