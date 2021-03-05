package com.nathan.learn.cache.custom;

public class DatastoreMapping extends CachedMapping<String> {
    public DatastoreMapping(MappingStoreDriver driver) {
        super(String.class, driver);
    }

    public void setDriver(MappingStoreDriver mappingStoreDriver) {
        this.driver = mappingStoreDriver;
    }
}
