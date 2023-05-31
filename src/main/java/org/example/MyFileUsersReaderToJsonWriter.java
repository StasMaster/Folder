package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileUsersReaderToJsonWriter {
    public static void main(String[] args) {
        List<User> users = readUsersFromFile("src/secondtask/file.txt");
        writeUsersToJsonFile(users, "src/secondtask/user.json");
    }

    private static List<User> readUsersFromFile(String fileName) {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] headers = null;
            while ((line = reader.readLine()) != null) {
                if (headers == null) {
                    headers = line.split(" ");
                } else {
                    String[] values = line.split(" ");
                    if (values.length == headers.length) {
                        String name = values[0];
                        int age = Integer.parseInt(values[1]);
                        User user = new User(name, age);
                        users.add(user);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static void writeUsersToJsonFile(List<User> users, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String json = gson.toJson(users);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}