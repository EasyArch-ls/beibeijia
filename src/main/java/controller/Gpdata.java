package controller;

import bean.User;
import com.alibaba.fastjson.JSON;
import redis.Redis;

import java.util.HashMap;
import java.util.Map;

public class Gpdata {
    private Map map;
    public String Return(String s) {
        map=new HashMap<String,String>();
        map = JSON.parseObject(s, map.getClass());
        Redis redis = Redis.jediss;
        String s1="";
        if(map.get("phone")==null){
            s1= User.EBase64((String) map.get("phone"));
        }else {
            s1=redis.get(map.get("uname").toString()+"#");
        }
        map=redis.getinformation(s1);
        return JSON.toJSONString(map);

    }
}
