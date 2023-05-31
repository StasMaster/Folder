package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFilePhonesReader {
    public static void main(String[] args) {
        String fileName = "src/firsttask/file.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> phoneNumbers = extractValidPhoneNumbers(line);
                for (String phoneNumber : phoneNumbers) {
                    System.out.println(phoneNumber);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static List<String> extractValidPhoneNumbers(String input) {
        Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(input);
        List<String> validPhoneNumbers = new ArrayList<>();

        while (matcher.find()) {
            validPhoneNumbers.add(matcher.group());
        }
        return validPhoneNumbers;
    }
}