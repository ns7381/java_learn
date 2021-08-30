package com.nathan.learn.io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://mkyong.com/tutorials/java-io-tutorials/
 */
public class FileUtils {
    @Test
    public static void getFiles(String path) {
        File file =new File(path);
        if(file.exists()){
            if(file.isDirectory()){
                File[] listFiles =file.listFiles();
                if(listFiles.length == 0){
                    System.out.println("该文件夹下没有文件");
                }
                for (File f : listFiles) {
                    if(f.isDirectory()){
                        System.out.println("文件夹："+f.getName());
                        getFiles(f.getAbsolutePath());
                    }else if(f.isFile()){
                        System.out.println("文件："+f.getName());
                    }else {
                        System.err.println("未知错误");
                    }

                }
            }
        }
    }

    @Test
    public void testCreateFile() {
        File myObj = new File("text.txt"); // Specify the filename
        try {
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteFile() {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Test
    public void testReadFile() {
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFile() {
        File myObj = new File("filename.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }

    @Test
    public void testDeleteFile() {
        File myObj = new File("filename.txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }


    /**
     * ----------------------------------------------------------------------------------------------------------------------------------
     * java1.8 Files
     */
    @Test
    public void testFilesCreateAndWrite() throws IOException {
        //Files.write to create and write to a file.
        String content = "...";
        Path path = Paths.get("/home/mkyong/test.txt");
        // string -> bytes
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        List<String> list = Arrays.asList("a", "b", "c");
        Files.write(path, list);
    }

    /**
     * Files.lines, return a Stream (Java 8)
     * Files.readString, returns a String (Java 11), max file size 2G.
     * Files.readAllBytes, returns a byte[] (Java 7), max file size 2G.
     * Files.readAllLines, returns a List<String> (Java 8)
     * BufferedReader, a classic old friend (Java 1.1 -> forever)
     * Scanner (Java 1.5)
     *
     * @throws IOException
     */
    @Test
    public void testFilesRead() throws IOException {
        String fileName = "/home/mkyong/app.log";

        List<String> lines = Files.readAllLines(Paths.get(fileName),
                StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
    }

    @Test
    public void testFilesAppend() throws IOException {
        Files.write(Paths.get("test.txt"),
                "content".getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    @Test
    public void testFilesCopy() throws IOException {
        Path fromFile = Paths.get("from");
        Path toFile = Paths.get("to");

        Files.copy(fromFile, toFile);
    }

}
