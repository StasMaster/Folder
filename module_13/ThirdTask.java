package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
public class ThirdTask {
    public static void main(String[] args) {
        getOpenTasksForUser(11);
    }

    public static void getOpenTasksForUser(int userId) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String todosUrl = "https://jsonplaceholder.typicode.com/users/" + userId + "/todos";

        try {
            // Отправляем GET-запрос на получение задач пользователя
            HttpResponse response = httpClient.execute(new HttpGet(todosUrl));
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonString = EntityUtils.toString(entity);

                // Парсим JSON-ответ и получаем массив задач
                JSONArray todosArray = new JSONArray(jsonString);

                // Фильтруем задачи по полю "completed"
                JSONArray openTasksArray = new JSONArray();
                for (int i = 0; i < todosArray.length(); i++) {
                    JSONObject task = todosArray.getJSONObject(i);
                    boolean completed = task.getBoolean("completed");

                    if (!completed) {
                        openTasksArray.put(task);
                    }
                }

                System.out.println("Открытые задачи пользователя " + userId + ":");
                for (int i = 0; i < openTasksArray.length(); i++) {
                    JSONObject task = openTasksArray.getJSONObject(i);
                    String title = task.getString("title");
                    System.out.println("- " + title);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}