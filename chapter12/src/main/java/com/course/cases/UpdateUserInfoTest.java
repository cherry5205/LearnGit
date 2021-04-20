package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest {
    @Test(dependsOnGroups = "loginTrue", description = "更新/删除用户数据接口")
    public void updateUserInfo() throws IOException, InterruptedException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase", 1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
        int result = getResult(updateUserInfoCase);
        Thread.sleep(30000);
        User user = sqlSession.selectOne(updateUserInfoCase.getExpected(), updateUserInfoCase);
        System.out.println(user);
        Assert.assertNotNull(result);
        Assert.assertNotNull(user);

    }

    private int getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.updateUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("id", updateUserInfoCase.getUserId());
        param.put("name", updateUserInfoCase.getName());
        param.put("sex", updateUserInfoCase.getSex());
        param.put("age", updateUserInfoCase.getAge());
        param.put("permisson", updateUserInfoCase.getPermission());
        param.put("deleted", updateUserInfoCase.getDeleted());
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        post.setHeader("content-type", "application/json");
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        return Integer.parseInt(result);
    }

    @Test(dependsOnGroups = "loginTrue", description = "更新/删除用户数据接口")
    public void deleteUser() throws IOException, InterruptedException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase", 2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
        int result = getResult(updateUserInfoCase);
        Thread.sleep(30000);
        User user = sqlSession.selectOne(updateUserInfoCase.getExpected(), updateUserInfoCase);
        System.out.println(user);
        Assert.assertNotNull(result);
        Assert.assertNotNull(user);
    }
}