package org.example;

import org.example.service.FileConcatenationService;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Туманова Екатерина Александровна, группа РИБО-02-22, вариант 1, практика1_10");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int fileCount = 0;
            while (fileCount < 2) {
                System.out.print("Введите количество файлов для склеивания (минимум 2): ");
                try {
                    fileCount = Integer.parseInt(reader.readLine());
                    if (fileCount < 2) {
                        System.out.println("Для склеивания файлов требуется 2 и более файлов.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Пожалуйста, введите целое число.");
                }
            }

            String[] fileNames = new String[fileCount];
            for (int i = 0; i < fileCount; i++) {
                boolean validPath = false;
                while (!validPath) {
                    System.out.print("Введите путь к файлу " + (i + 1) + ": ");
                    String filePath = reader.readLine();
                    if (new File(filePath).exists()) {
                        fileNames[i] = filePath;
                        validPath = true;
                    } else {
                        System.out.println("Файл не найден. Пожалуйста, введите корректный путь к файлу.");
                    }
                }
            }

            String outputFile = fileNames[0].replace(".txt", "_result.txt");

            FileConcatenationService.concatenateFiles(fileNames, outputFile);

            System.out.println("Файлы успешно склеены. Результат сохранен в файле: " + outputFile);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
