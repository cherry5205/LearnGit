package com.course.controller;

import com.alibaba.fastjson.JSONArray;
import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

//@log4j
@RestController
@Api(value = "v1",description = "用户管理系统")
@RequestMapping(value = "v1")
public class UserManager {
    @Autowired
    private SqlSessionTemplate template;
    @ApiOperation(value = "登陆接口",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response, @RequestBody User user)
    {
//        System.out.println(user);
         int i = template.selectOne("loginUser",user);
         Cookie cookie= new Cookie("login","true");
         response.addCookie(cookie);
//         log.info("查询到的用户是："+ i);
         if (i==1)
         {
             System.out.println("登陆的用户是："+ user.getName());
             return true;
         }
         return false;
    }

    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Boolean addUser(HttpServletRequest request,@RequestBody User user)
    {
//        System.out.println("==================");
//        System.out.println(user);
        Boolean x = verify(request);
        if (x == true) {
            int result = template.insert("addUser", user);
            if (result > 0)
                return true;
        }
        return false;
    }
    private Boolean verify(HttpServletRequest request) {
        Cookie[] cookies  = request.getCookies();
        if (Objects.isNull(cookies))
        {
//            log.info("cookies为空");
            return false;
        }
        for (Cookie cookie:cookies)
        {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true") )
            {
                return true;
            }
        }
        return false;
    }
    @ApiOperation(value = "获取用户信息接口",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST )
    public List<User> getUserInfo(HttpServletRequest request,@RequestBody User user)
    {
        System.out.println(user);
        boolean x = verify(request);
        if (x==true)
        {
            List<User> list= template.selectList("getUserInfo",user);
            return list;
        }
        return null;
    }
    @ApiOperation(value = "更新用户数据接口",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request,@RequestBody User user)
    {
        System.out.println(user);
        boolean x = verify(request);
        int i = 0;
        if (x == true)
        {
            i = template.update("updateUser",user);
        }
        return i;
    }
}
