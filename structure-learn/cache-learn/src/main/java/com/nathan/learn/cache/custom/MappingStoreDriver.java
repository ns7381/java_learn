package com.nathan.learn.cache.custom;

import org.apache.hadoop.conf.Configuration;

import java.util.Map;

public abstract class MappingStoreDriver {
    /**
     * hive conf
     */
    protected Configuration conf;
    /**
     * Identifier for the driver.
     */
    private String identifier;
    /**
     * If it is initialized.
     */
    private boolean initialized = false;

    public boolean init(final Configuration config, String identifier) {
        this.conf = config;
        this.identifier = identifier;
        return initDriver();
    }

    public abstract boolean initDriver();

    public abstract <T> Map<String, T> getAll(Class<T> clazz);

    public abstract <T> boolean putAll(Map<String, T> records);

    /**
     * Set the driver as initialized.
     *
     * @param ini If the driver is initialized.
     */
    public void setInitialized(boolean ini) {
        this.initialized = ini;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public Configuration getConf() {
        return conf;
    }

    public String getIdentifier() {
        return identifier;
    }

    public abstract String getType();
}
