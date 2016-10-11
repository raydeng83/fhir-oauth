package com.ldeng.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import twitter4j.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by z00382545 on 10/10/16.
 */
public class TokenTest {
    public static void main(String[] args) throws  IOException, JSONException {
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/auth/realms/demo/protocol/openid-connect/token");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("client_id", "admin-cli"));
        params.add(new BasicNameValuePair("client_secret", "2a05c119-6254-481a-9b0d-a3f6993c85cc"));

        params.add(new BasicNameValuePair("username", "ldeng"));
        params.add(new BasicNameValuePair("password", "password"));
        params.add(new BasicNameValuePair("grant_type", "password"));

        httpPost.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute(httpPost);

        String responseAsString = EntityUtils.toString(response.getEntity());

        System.out.println(responseAsString);

        System.out.println(response.getEntity().getContent());

//        JsonNode n = responseParser(response);

//        String bearerToken = "bearer "+n.get("access_token").textValue();
//        System.out.println(bearerToken);

//        HttpGet httpGet = new HttpGet("http://localhost:8080/auth/admin/realms/demo");
//
//        httpGet.setHeader("Authorization", bearerToken);
//
//        response = client.execute(httpGet);
//
//        JsonNode o =responseParser(response);

//        client.close();
    }

    public static JsonNode responseParser(HttpResponse response) throws IOException, JSONException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            result.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(result.toString());

        return actualObj;
    }
}
