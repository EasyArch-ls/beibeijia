package controller;

import com.alibaba.fastjson.JSON;
import json.Tojson;
import phone.Sphone;
import redis.Redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Send {
    private Map map;

    public String Return(String s) {
        map = new HashMap<String,String>();
        map = JSON.parseObject(s, map.getClass());
        Redis redis = Redis.jediss;
        Random random = new Random();
        Integer i = random.nextInt(900000) + 100000;
        if (map.get("phone") != null && redis.provp(map.get("phone").toString() + "1")) {
            redis.setp((String) map.get("phone"), i.toString());
            Sphone.getSingleton().send((String) map.get("phone"), i.toString());
            Map map1 = new HashMap();
            map1.put("code", redis.getp((String) map.get("phone")));
            JSON.toJSONString(map1);
            return JSON.toJSONString(map1);
        } else {
            return Tojson.getSingleton().to("手机号没有注册过");
        }
    }
}