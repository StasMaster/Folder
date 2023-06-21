package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import java.io.FileWriter;

public class SecondTask {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users/";

    public static void main(String[] args) {
        getCommentsForLastPostOfUser(10);
    }

    public static void getCommentsForLastPostOfUser(int userId) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String postsUrl = BASE_URL + userId + "/posts";

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
}
