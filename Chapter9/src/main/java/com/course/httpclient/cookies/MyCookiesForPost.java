package com.course.httpclient.cookies;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import com.sun.xml.internal.ws.policy.AssertionSet;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    String url;
    CookieStore store;
    ResourceBundle bundle;
    @BeforeTest
    public void beforeTest()
    {
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        this.url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String uri;
        String testUri;
        String result;
        uri = bundle.getString("getCookies.uri");
        testUri = this.url + uri;
        HttpGet get = new HttpGet(testUri);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        this.store = client.getCookieStore();
        result = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println(result);
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList)
        {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name = "+ name + "; value = "+ value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostWithCookies() throws IOException {
        String uri;
        String testUri;
        String result;
        uri = bundle.getString("post.with.cookies");
        testUri = url + uri;
        HttpPost post = new HttpPost(testUri);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(store);
        //添加json参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //设置请求头信息，设置Header
        post.setHeader("Content-Type","application/json");
        //把参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"gbk");
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        result = EntityUtils.toString(response.getEntity(),"gbk");
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        System.out.println(result);
        JSONObject resultJson = new JSONObject(result);
        String success = (String) resultJson.get("huhansan");
        Assert.assertEquals("success",success);
        String status = (String) resultJson.get("status");
        Assert.assertEquals("1",status);
    }
}
