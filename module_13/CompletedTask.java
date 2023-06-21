package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpDelete;
import java.io.FileWriter;

public class CompletedTask {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users/";
    public static void main(String[] args) {
        createNewUser();
        updateExistingUser();
        deleteUser();
        getUsers();
        getUser(10);
        getUserByUsername("Maxime_Nienow");
        getCommentsForLastPostOfUser(5);
        getOpenTasksForUser(4);
    }
    public static void getOpenTasksForUser(int userId) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String todosUrl = BASE_URL + userId + "/todos";

        try {
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

    public static void getCommentsForLastPostOfUser(int userId) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String postsUrl = "https://jsonplaceholder.typicode.com/users/" + userId + "/posts";

        try {
            HttpResponse response = httpClient.execute(new HttpGet(postsUrl));
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonString = EntityUtils.toString(entity);

                JSONArray postsArray = new JSONArray(jsonString);

                JSONObject lastPost = postsArray.getJSONObject(postsArray.length() - 1);
                int postId = lastPost.getInt("id");

                String commentsUrl = "https://jsonplaceholder.typicode.com/posts/" + postId + "/comments";

                HttpResponse commentsResponse = httpClient.execute(new HttpGet(commentsUrl));
                HttpEntity commentsEntity = commentsResponse.getEntity();

                if (commentsEntity != null) {
                    String commentsJsonString = EntityUtils.toString(commentsEntity);

                    String fileName = "user-" + userId + "-post-" + postId + "-comments.json";
                    FileWriter fileWriter = new FileWriter(fileName);
                    fileWriter.write(commentsJsonString);
                    fileWriter.close();

                    System.out.println("Комментарии сохранены в файл: " + fileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createNewUser() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(BASE_URL);

        try {
            JSONObject user = new JSONObject();
            user.put("name", "Talia Mia Tia");
            user.put("username", "taliamiatia");
            user.put("email", "taliamiatia@example.com");

            StringEntity params = new StringEntity(user.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);

            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonString = EntityUtils.toString(entity);
                System.out.println(jsonString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateExistingUser() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPut request = new HttpPut(BASE_URL + "/10");

        try {
            JSONObject updatedUser = new JSONObject();
            updatedUser.put("name", "Talia Mia Tia");
            updatedUser.put("username", "taliamiatia");
            updatedUser.put("email", "taliamiatia@example.com");

            StringEntity params = new StringEntity(updatedUser.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);

            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonString = EntityUtils.toString(entity);
                System.out.println(jsonString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpDelete request = new HttpDelete(BASE_URL + "/11");

        try {
            // Отправляем DELETE-запрос на удаление пользователя
            HttpResponse response = httpClient.execute(request);

            // Проверяем статус ответа
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                System.out.println("Пользователь успешно удален.");
            } else {
                System.out.println("Произошла ошибка при удалении пользователя.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getUsers() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(BASE_URL);

        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonString = EntityUtils.toString(entity);
                System.out.println(jsonString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getUser(int userId) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(BASE_URL + "/" + userId);

        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonString = EntityUtils.toString(entity);
                System.out.println(jsonString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getUserByUsername(String username) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(BASE_URL + "?username=" + username);

        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonString = EntityUtils.toString(entity);
                System.out.println(jsonString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
