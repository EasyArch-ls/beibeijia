package controller;

import bean.User;
import com.alibaba.fastjson.JSON;
import hbase.Create;
import hbase.ICeate;
import json.Tojson;
import mybatis.Mymybatis;
import redis.Redis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Regis {
    private Map map;
    public String Return(String s) throws IOException {
        map=new HashMap<String,String>();
        map= JSON.parseObject(s,map.getClass());
        Redis redis=Redis.jediss;
        if(map.get("uname")!=null&&redis.provu(map.get("uname").toString()+"#")){
            return Tojson.getSingleton().to("用户名已存在");
        }
        if(map.get("phone")!=null&&redis.provp(map.get("phone").toString()+"1")){
            return Tojson.getSingleton().to("手机号已注册");
        }
        redis.setu(map.get("uname").toString(), User.EBase64(map.get("upass").toString()));
        redis.putu(map.get("uname").toString()+"#",User.EBase64(map.get("phone").toString()));
        redis.putp(map.get("phone").toString()+"1",map.get("uname").toString());
        new Mymybatis().regis(User.EBase64((String) map.get("phone")),map);
        //new Create().insert("user",User.EBase64((String) map.get("phone")),"information",map);
        redis.setinformation(User.EBase64(map.get("phone").toString()),map);
        return Tojson.getSingleton().to("注册成功");

    }
}
