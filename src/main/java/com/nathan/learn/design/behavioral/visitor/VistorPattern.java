package com.nathan.learn.design.behavioral.visitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 访问者模式（Visitor）是一种操作一组对象的操作，它的目的是不改变对象的定义，但允许新增不同的访问者，来定义新的操作。
 * @author nathan
 */
public class VistorPattern {
    public static void main(String[] args) throws IOException {
        FileStructure fs = new FileStructure(new File("."));
        fs.handle(new JavaFileVisitor());
        Files.walkFileTree(Paths.get("."), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return null;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                return null;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return null;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return null;
            }
        });

    }
}

interface Visitor {
    // 访问文件夹:
    void visitDir(File dir);

    // 访问文件:
    void visitFile(File file);
}

class FileStructure {
    // 根目录:
    private File path;

    public FileStructure(File path) {
        this.path = path;
    }

    public void handle(Visitor visitor) {
        scan(this.path, visitor);
    }

    private void scan(File file, Visitor visitor) {
        if (file.isDirectory()) {
            // 让访问者处理文件夹:
            visitor.visitDir(file);
            for (File sub : file.listFiles()) {
                // 递归处理子文件夹:
                scan(sub, visitor);
            }
        } else if (file.isFile()) {
            // 让访问者处理文件:
            visitor.visitFile(file);
        }
    }
}

class JavaFileVisitor implements Visitor {
    @Override
    public void visitDir(File dir) {
        System.out.println("Visit dir: " + dir);
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().endsWith(".java")) {
            System.out.println("Found java file: " + file);
        }
    }
}

class ClassFileCleanerVisitor implements Visitor {
    @Override
    public void visitDir(File dir) {
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().endsWith(".class")) {
            System.out.println("Will clean class file: " + file);
        }
    }
}