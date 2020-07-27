package com.example.httpclient.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
    
    private static final String CHAR_SET_UTF8 = "UTF-8";
    /**
     * post请求
     * @param url    请求地址
     * @param b    body体数据
     * @return    返回接口字符串
     * @throws Exception
     */
    public static String httpPost(String url, String body) throws Exception {
        String result = null;
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        post.setEntity(new StringEntity(body, CHAR_SET_UTF8));
        HttpResponse httpResponse = httpClient.execute(post);
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            result = EntityUtils.toString(entity, CHAR_SET_UTF8);
        }
        httpClient.getConnectionManager().shutdown();
        return result;
    }
}