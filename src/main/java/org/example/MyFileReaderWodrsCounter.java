package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyFileReaderWodrsCounter {
    public static void main(String[] args) {
        Map<String, Integer> wordFrequencies = countWordFrequencies("src/therdtask/words.txt");
        printWordFrequencies(wordFrequencies);
    }

    private static Map<String, Integer> countWordFrequencies(String fileName) {
        Map<String, Integer> wordFrequencies = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");

                for (String word : words) {
                    wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sortWordFrequencies(wordFrequencies);
    }

    private static Map<String, Integer> sortWordFrequencies(Map<String, Integer> wordFrequencies) {
        // Создаем список пар (слово, частота) для сортировки
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFrequencies.entrySet());

        // Сортируем список по убыванию частоты слов
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Создаем отсортированную карту частот слов
        Map<String, Integer> sortedWordFrequencies = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedWordFrequencies.put(entry.getKey(), entry.getValue());
        }

        return sortedWordFrequencies;
    }

    private static void printWordFrequencies(Map<String, Integer> wordFrequencies) {
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}