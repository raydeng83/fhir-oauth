//package com.ldeng.config;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import twitter4j.JSONException;
//import twitter4j.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//
///**
// * Created by z00382545 on 10/6/16.
// */
//public class KeycloakConfig {
//
//    public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost("http://localhost:8080/auth/realms/master/protocol/openid-connect/token");
//        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
//
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("client_id", "admin-cli"));
//        params.add(new BasicNameValuePair("username", "admin"));
//        params.add(new BasicNameValuePair("password", "password"));
//        params.add(new BasicNameValuePair("grant_type", "password"));
//
//        httpPost.setEntity(new UrlEncodedFormEntity(params));
//
//        CloseableHttpResponse response = client.execute(httpPost);
//
//        JsonNode n = responseParser(response);
//        Iterator<String> li = n.fieldNames();
//
//        while(li.hasNext()) {
//            System.out.println(li.next());
//        }
//
//        HttpGet httpGet = new HttpGet("http://localhost:8080/auth/admin/realms/master");
//        String bearerToken = "bearer "+n.get("access_token").textValue();
//        System.out.println(bearerToken);
//        httpGet.setHeader("Authorization", bearerToken);
//        httpGet.setHeader("Content-Type", "application/json");
//
////        params = new ArrayList<NameValuePair>();
////        params.add(new BasicNameValuePair("client_id", "admin-cli"));
////        params.add(new BasicNameValuePair("username", "admin"));
////        params.add(new BasicNameValuePair("password", "password"));
////        params.add(new BasicNameValuePair("grant_type", "password"));
////
////        httpPost.setEntity(new UrlEncodedFormEntity(params));
//
//        response = client.execute(httpGet);
//
//        JsonNode o =responseParser(response);
//
//        Iterator<String> li2 = o.fieldNames();
//
//        while(li2.hasNext()) {
//            System.out.println(li2.next());
//        }
//
//        System.out.println(o.get("publicKey").textValue());
//
//        client.close();
//
//    }
//
//    public static JsonNode responseParser(CloseableHttpResponse response) throws ClientProtocolException, IOException, JSONException {
//        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//        StringBuffer result = new StringBuffer();
//        String line = "";
//        while ((line = rd.readLine()) != null) {
//            result.append(line);
//        }
//
//        System.out.println(result);
//
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode actualObj = mapper.readTree(result.toString());
//
//        return actualObj;
//    }
//
//
//}
