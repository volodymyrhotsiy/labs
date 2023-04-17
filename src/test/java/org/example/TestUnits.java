package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestUnits {
    static String readFileContent(File file) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                contentBuilder.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
