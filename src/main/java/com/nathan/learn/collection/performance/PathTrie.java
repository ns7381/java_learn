package com.nathan.learn.collection.performance;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * a class that implements prefix matching for
 * components of a filesystem path. the trie
 * looks like a tree with edges mapping to
 * the component of a path.
 * example /ab/bc/cf would map to a trie
 *           /
 *        ab/
 *        (ab)
 *      bc/
 *       /
 *      (bc)
 *   cf/
 *   (cf)
 */
public class PathTrie {

    private static final Logger LOG = LoggerFactory.getLogger(PathTrie.class);

    /**
     * Root node of PathTrie
     */
    private final TrieNode rootNode;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    static class TrieNode {

        final String value;
        final Map<String, TrieNode> children;
        String property;
        TrieNode parent;

        /**
         * Create a trie node with parent as parameter.
         *
         * @param parent the parent of this node
         * @param value  the value stored in this node
         */
        private TrieNode(TrieNode parent, String value) {
            this.value = value;
            this.parent = parent;
            this.property = null;
            this.children = new HashMap<>(4);
        }

        /**
         * Get the parent of this node.
         *
         * @return the parent node
         */
        TrieNode getParent() {
            return this.parent;
        }

        /**
         * set the parent of this node.
         *
         * @param parent the parent to set to
         */
        void setParent(TrieNode parent) {
            this.parent = parent;
        }

        /**
         * A property that is set for a node - making it special.
         */
        void setProperty(String prop) {
            this.property = prop;
        }

        String getProperty() {
            return this.property;
        }

        /**
         * The property of this node.
         *
         * @return the property for this node
         */
        boolean hasProperty() {
            return this.property != null;
        }

        /**
         * The value stored in this node.
         *
         * @return the value stored in this node
         */
        public String getValue() {
            return this.value;
        }

        /**
         * Add a child to the existing node.
         *
         * @param childName the string name of the child
         * @param node      the node that is the child
         */
        void addChild(String childName, TrieNode node) {
            this.children.putIfAbsent(childName, node);
        }

        /**
         * Delete child from this node.
         *
         * @param childName the name of the child to be deleted
         */
        void deleteChild(String childName) {
            this.children.computeIfPresent(childName, (key, childNode) -> {
                // Node no longer has an external property associated
                childNode.setProperty(null);

                // Delete it if it has no children (is a leaf node)
                if (childNode.isLeafNode()) {
                    childNode.setParent(null);
                    return null;
                }

                return childNode;
            });
        }

        /**
         * Return the child of a node mapping to the input child name.
         *
         * @param childName the name of the child
         * @return the child of a node
         */
        TrieNode getChild(String childName) {
            return this.children.get(childName);
        }

        /**
         * Get the list of children of this trienode.
         *
         * @return A collection containing the node's children
         */
        Collection<String> getChildren() {
            return children.keySet();
        }

        /**
         * Determine if this node is a leaf (has no children).
         *
         * @return true if this node is a lead node; otherwise false
         */
        boolean isLeafNode() {
            return children.isEmpty();
        }

        @Override
        public String toString() {
            return "TrieNode [name=" + value + ", property=" + property + ", children=" + children.keySet() + "]";
        }

    }

    /**
     * Construct a new PathTrie with a root node.
     */
    public PathTrie() {
        this.rootNode = new TrieNode(null, "/");
    }

    /**
     * Add a path to the path trie. All paths are relative to the root node.
     *
     * @param path the path to add to the trie
     */
    public void addPath(final String path, final String property) {
        Objects.requireNonNull(path, "Path cannot be null");

        final String[] pathComponents = StringUtils.split(path, '/');
        if (pathComponents.length == 0) {
            throw new IllegalArgumentException("Invalid path: " + path);
        }

        writeLock.lock();
        try {
            TrieNode parent = rootNode;
            for (final String part : pathComponents) {
                TrieNode child = parent.getChild(part);
                if (child == null) {
                    child = new TrieNode(parent, part);
                    parent.addChild(part, child);
                }
                parent = child;
            }
            parent.setProperty(property);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Delete a path from the trie. All paths are relative to the root node.
     *
     * @param path the path to be deleted
     */
    public void deletePath(final String path) {
        Objects.requireNonNull(path, "Path cannot be null");

        final String[] pathComponents = StringUtils.split(path, '/');
        if (pathComponents.length == 0) {
            throw new IllegalArgumentException("Invalid path: " + path);
        }

        writeLock.lock();
        try {
            TrieNode parent = rootNode;
            for (final String part : pathComponents) {
                if (parent.getChild(part) == null) {
                    // the path does not exist
                    return;
                }
                parent = parent.getChild(part);
                LOG.debug("{}", parent);
            }

            final TrieNode realParent = parent.getParent();
            realParent.deleteChild(parent.getValue());
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Return true if the given path exists in the trie, otherwise return false;
     * All paths are relative to the root node.
     *
     * @param path the input path
     * @return the largest prefix for the
     */
    public boolean existsNode(final String path) {
        Objects.requireNonNull(path, "Path cannot be null");

        final String[] pathComponents = StringUtils.split(path, '/');
        if (pathComponents.length == 0) {
            throw new IllegalArgumentException("Invalid path: " + path);
        }

        readLock.lock();
        try {
            TrieNode parent = rootNode;
            for (final String part : pathComponents) {
                if (parent.getChild(part) == null) {
                    // the path does not exist
                    return false;
                }
                parent = parent.getChild(part);
                LOG.debug("{}", parent);
            }
        } finally {
            readLock.unlock();
        }
        return true;
    }

    /**
     * Return the largest prefix for the input path. All paths are relative to the
     * root node.
     *
     * @param path the input path
     * @return the largest prefix for the input path
     */
    public String findMaxPrefix(final String path) {
        Objects.requireNonNull(path, "Path cannot be null");

        final String[] pathComponents = StringUtils.split(path, '/');

        readLock.lock();
        try {
            TrieNode parent = rootNode;
            TrieNode deepestPropertyNode = null;
            for (final String element : pathComponents) {
                parent = parent.getChild(element);
                if (parent == null) {
                    LOG.debug("{}", element);
                    break;
                }
                if (parent.hasProperty()) {
                    deepestPropertyNode = parent;
                }
            }

            if (deepestPropertyNode == null) {
                return "/";
            }

            return deepestPropertyNode.getProperty();
        } finally {
            readLock.unlock();
        }
    }

    /**
     * Clear all nodes in the trie.
     */
    public void clear() {
        writeLock.lock();
        try {
            rootNode.getChildren().clear();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        PathTrie pathTrie = new PathTrie();
        pathTrie.addPath("/test/dd_edw/app/t1", "ds1");
        pathTrie.addPath("/test/dd_edw/app/t2", "ds2");
        pathTrie.addPath("/test/dd_edw/odm/t3", "ds3");
        pathTrie.addPath("/test/dd_edw/odm", "ds4");
        pathTrie.addPath("/test/dd_edw/app", "ds5");
        pathTrie.addPath("/test/market1", "ds6");
        pathTrie.addPath("/test", "ds7");
        pathTrie.addPath("/ceshi", "ds8");
//        pathTrie.deletePath("/test/dd_edw/odm");
        System.out.println(pathTrie.findMaxPrefix("/test/dd_edw/odm/t4"));
    }

}

