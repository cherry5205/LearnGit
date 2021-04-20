package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import com.google.gson.JsonArray;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GetUserListTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取用户列表接口")
    public void getUserList() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserListCase",1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);
        //获取结果
        JSONArray resultJson = getJsonArray(getUserListCase);
        //验证结果
        List<User> userList = sqlSession.selectList(getUserListCase.getExpected(),getUserListCase);
        JSONArray userListJson = new JSONArray(userList);
        System.out.println(userList);
        System.out.println(userListJson);
        Assert.assertEquals(userListJson.length(),resultJson.length());
       for (int i = 0;i < resultJson.length();i++ )
       {
           JSONObject actual = (JSONObject)resultJson.get(i);
           JSONObject expect = (JSONObject)userListJson.get(i);
           Assert.assertEquals(expect.toString(),actual.toString());
       }
    }

    private JSONArray getJsonArray(GetUserListCase getUserListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("name",getUserListCase.getName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        post.setHeader("content-type","application/json");
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONArray array = new JSONArray(result);
        return array;
    }
}
