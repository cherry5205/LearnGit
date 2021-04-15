package com.course.httpclient.param;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyParamForGet {
    private String url;
    private ResourceBundle bundle;
    @BeforeTest
    public void beforeTest()
    {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        bundle.getString("test.url");
    }
    @Test
    @Parameters({"name","age"})
    public void testParamWithGet(String name,String age) throws IOException, URISyntaxException, URISyntaxException {
        String uri;
        String testUri;
        String result;
        uri = bundle.getString("get.with.param");
        testUri = this.url + uri;

        DefaultHttpClient client = new DefaultHttpClient();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("name",name));
        params.add(new BasicNameValuePair("age",age));
        URI uri2= new URIBuilder(testUri).setParameters(params).build();
        HttpGet get = new HttpGet(uri2);
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        System.out.println("name = "+ name + ";age = " + age);

    }

}
