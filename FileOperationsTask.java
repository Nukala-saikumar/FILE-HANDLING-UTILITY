package com.CodeTech.FIleHanding.program;

import java.io.*;
import java.nio.file.*;

public class FileOperationsTask {
    // File path
    static String filePath = "C:\\Users\\ARSHIYA\\Desktop\\Project files\\TestTextFile.txt";
    static String name=("Mani");
    public static void main(String[] args)  throws IOException{
        	//Using some pre-defined methods from file handling concept
    	    writeToFile("Entire fles are written by "+name);
            writeToFile("This is the first line.\nThis is the second line.");
            System.out.println("File after writing:");
            readFile();
            appendToFile("\nThis line is appended line.");
            System.out.println("\nFile after appending:");
            readFile();
            modifyFile("second", "modified");
            System.out.println("\nFile after modification:");
            readFile();
      }
    // Method to write to a file (overwrites existing content)
    public static void writeToFile(String content) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(content);
        writer.close();
    }
    // Method to read and print file content
    public static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
    // Method to append text to the existing file
    public static void appendToFile(String content) throws IOException {
        FileWriter writer = new FileWriter(filePath, true); // 'true' enables appending
        writer.write(content);
        writer.close();
    }
    // Method to modify text in the file
    public static void modifyFile(String oldWord, String newWord) throws IOException {
        Path path = Paths.get(filePath);
        String content = Files.readString(path);
        content = content.replace(oldWord, newWord);
        Files.writeString(path, content);
    }
}
