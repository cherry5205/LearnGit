package com.course.httpclient.cookies;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpClientConnectionOperator;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void beforeTest()
    {
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String testUri;
        testUri = this.url+ bundle.getString("getCookies.uri");
        HttpGet get = new HttpGet(testUri);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println(result);
//      访问cookies
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie: cookieList
             )
        {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name = "+ name + "; value = "+value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String testUri;
        String result;
        testUri = url + bundle.getString("get.with.cookies");
        HttpGet get = new HttpGet(testUri);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(store);
        HttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = "+ statusCode);
        result = EntityUtils.toString(response.getEntity(),"gbk");
        System.out.println(result);
        if(statusCode == 200)
        {
            List<Cookie> cookieList = store.getCookies();
            for (Cookie cookie : cookieList)
            {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("name = "+name + "; value = "+ value);
            }
        }

    }
}
