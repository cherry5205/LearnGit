package com.course.server;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }

    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies))
        {
            return "必须携带cookies信息来";
        }
        for (Cookie cookie : cookies)
        {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true"))
            {
                return "恭喜你，登陆成功";
            }
        }
        return "必须携带cookies信息来";
    }
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,
                                      @RequestParam Integer end)
    {
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋子",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }
    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    public Map<String,Integer> myGetList(@PathVariable Integer start,
                                         @PathVariable Integer end)
    {
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋子",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }

}