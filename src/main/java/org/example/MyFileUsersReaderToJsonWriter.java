package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
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
                        User user = new User();
                        for (int i = 0; i < headers.length; i++) {
                            String header = headers[i];
                            String value = values[i];
                            switch (header) {
                                case "name":
                                    user.setName(value);
                                    break;
                                case "age":
                                    user.setAge(Integer.parseInt(value));
                                    break;
                            }
                        }
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
            writer.write("[");
            writer.newLine();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                String json = gson.toJson(user);
                writer.write("    " + json);
                if (i < users.size() - 1) {
                    writer.write(",");
                }
                writer.newLine();
            }
            writer.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class User {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}