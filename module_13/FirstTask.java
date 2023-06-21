package org.example;

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

public class FirstTask {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    public static void main(String[] args) {
        createNewUser();
        updateExistingUser();
        deleteUser();
        getUsers();
        getUser(10);
        getUserByUsername("Maxime_Nienow");
    }

    public static void createNewUser() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(BASE_URL);

        try {
            // Создаем новый объект пользователя
            JSONObject user = new JSONObject();
            user.put("name", "Talia Mia Tia");
            user.put("username", "taliamiatia");
            user.put("email", "taliamiatia@example.com");

            // Устанавливаем JSON-содержимое запроса
            StringEntity params = new StringEntity(user.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);

            // Отправляем POST-запрос на создание нового пользователя
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
        HttpPut request = new HttpPut(BASE_URL + "/10");  // Замените "1" на нужный ID пользователя

        try {
            // Создаем объект пользователя с обновленными данными
            JSONObject updatedUser = new JSONObject();
            updatedUser.put("name", "Talia Mia Tia");
            updatedUser.put("username", "taliamiatia");
            updatedUser.put("email", "taliamiatia@example.com");

            // Устанавливаем JSON-содержимое запроса
            StringEntity params = new StringEntity(updatedUser.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);

            // Отправляем PUT-запрос на обновление пользователя
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
        HttpDelete request = new HttpDelete(BASE_URL + "/11");  // Замените "1" на нужный ID пользователя

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
            // Отправляем GET-запрос на получение информации о пользователях
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
            // Отправляем GET-запрос на получение информации о пользователе
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
            // Отправляем GET-запрос на получение информации о пользователе
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