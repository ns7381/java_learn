package com.nathan.learn.cache.custom;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ReflectionUtils;

import java.util.HashMap;
import java.util.Map;

public class MappingHolder {
    private static final String HIVE_KEY_MAPPING_STORE_DRIVER = "hive.jd.mapping.store.driver";
    private static final Map<Class<? extends CachedMapping>, CachedMapping> mappingStores = new HashMap<>();

    private volatile static MappingHolder instance;

    protected static MappingStoreDriver driver;

    private MappingHolder() {
    }

    public static MappingHolder getInstance() {
        if (instance == null) {
            synchronized (MappingHolder.class) {
                if (instance == null) {
                    instance = new MappingHolder();
                }
            }
        }
        return instance;
    }

    public void init(Configuration config) {
        Class<? extends MappingStoreDriver> serializerName = config.getClass(
                HIVE_KEY_MAPPING_STORE_DRIVER,
                MappingStoreHttpImpl.class,
                MappingStoreDriver.class);
        driver = ReflectionUtils.newInstance(serializerName, config);
        driver.init(config, "datastore");
        DatastoreMapping datastoreMapping = CachedMapping.newInstance(DatastoreMapping.class, driver);
        assert datastoreMapping != null;
        datastoreMapping.loadCache();
        datastoreMapping.storeCache();
        mappingStores.put(DatastoreMapping.class, datastoreMapping);
    }

    public CachedMapping get(Class<? extends CachedMapping> mappingClazz) {
        return mappingStores.get(mappingClazz);
    }

    public <T> Map<String, T> getRecords(Class<? extends CachedMapping<T>> mappingClazz) {
        return mappingStores.get(mappingClazz).getCache();
    }

    public static String getDatastore(String key) {
        return (String) mappingStores.get(DatastoreMapping.class).getCache().get(key);
    }
}
