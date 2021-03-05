package com.nathan.learn.collection.performance;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TreeMapDemo {
    private final TreeMap<String, String> tree = new TreeMap<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    public long size() {
        this.readLock.lock();
        try {
            return tree.size();
        } finally {
            this.readLock.unlock();
        }
    }

    public void put(String key, String value) {
        this.writeLock.lock();
        try {
            tree.put(key, value);
        } finally {
            this.writeLock.unlock();
        }
    }

    String findDeepest(final String path) {
        readLock.lock();
        try {
            Map.Entry<String, String> entry = this.tree.floorEntry(path);
            while (entry != null && !isParentEntry(path, entry.getKey())) {
                entry = this.tree.lowerEntry(entry.getKey());
            }
            if (entry == null) {
                return null;
            }
            return entry.getValue();
        } finally {
            readLock.unlock();
        }
    }


    /**
     * Check if the given path is the child of parent path.
     *
     * @param path   Path to be check.
     * @param parent Parent path.
     * @return True if parent path is parent entry for given path.
     */
    public static boolean isParentEntry(final String path, final String parent) {
        if (!path.startsWith(parent)) {
            return false;
        }
        if (path.equals(parent)) {
            return true;
        }
        return path.charAt(parent.length()) == '/'
                || "/".equals(parent);
    }
}

