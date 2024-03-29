package org.example.service;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileConcatenationService {

    public static void concatenateFiles(String[] fileNames, String outputFile) throws IOException {
        FileReader[] fileReaders = new FileReader[fileNames.length];

        FileWriter writer = new FileWriter(outputFile);

        for (int i = 0; i < fileNames.length; i++) {
            FileReader fileReader = new FileReader(fileNames[i]);
            fileReaders[i] = fileReader;

            int data;
            while ((data = fileReader.read()) != -1) {
                writer.write(data);
            }
        }

        for (FileReader fileReader : fileReaders) {
            fileReader.close();
        }

        writer.close();
    }
}
