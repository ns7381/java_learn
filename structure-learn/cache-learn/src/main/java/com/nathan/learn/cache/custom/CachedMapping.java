package com.nathan.learn.cache.custom;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedMapping<T> {
    /**
     * Lock to access the memory cache.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    /**
     * Cached entries.
     */
    private Map<String, T> records = new HashMap<>();
    /**
     * Class of the record stored in this State Store.
     */
    private final Class<T> recordClass;
    protected MappingStoreDriver driver;

    public CachedMapping(Class<T> clazz, MappingStoreDriver driver) {
        this.recordClass = clazz;
        this.driver = driver;
    }

    public static <T extends CachedMapping<?>> T newInstance(
            final Class<T> clazz, final MappingStoreDriver driver) {

        try {
            Constructor<T> constructor = clazz.getConstructor(MappingStoreDriver.class);
            T recordStore = constructor.newInstance(driver);
            return recordStore;
        } catch (Exception e) {
//            LOG.error("Cannot create new instance for " + clazz, e);
            return null;
        }
    }

    public boolean loadCache() {
        writeLock.lock();
        try {
            this.records.clear();
            records.putAll(driver.getAll(this.recordClass));
        } finally {
            writeLock.unlock();
        }
        return true;
    }

    public Map<String, T> getCache() {
        Map<String, T> ret = new HashMap<>();
        this.readLock.lock();
        try {
            ret.putAll(records);
        } finally {
            this.readLock.unlock();
        }
        return ret;
    }

    public void storeCache() {
        this.readLock.lock();
        try {
            this.driver.putAll(records);
        } finally {
            this.readLock.unlock();
        }
    }

    public String getIdentifier() {
        return this.driver.getIdentifier();
    }
}
