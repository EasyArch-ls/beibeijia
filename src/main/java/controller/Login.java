package controller;

import bean.User;
import com.alibaba.fastjson.JSON;
import json.Tojson;
import phone.Sphone;
import redis.Redis;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Login {
    private Map map=null;
    public String Return(String s){
        map=new HashMap<String,String>();
        map=JSON.parseObject(s,map.getClass());
        Redis redis=Redis.jediss;
       /* if(map.get("uname")==null){
            if(map.get("phone")!=null&&redis.provp(map.get("phone").toString()+"1")){
                Map map1=new HashMap();
                map1.put("code",redis.getp((String) map.get("phone")));
                JSON.toJSONString(map1);
                return JSON.toJSONString(map1);
            }else {
                return Tojson.getSingleton().to("手机号没有注册过");
            }

        }*/
        if(map.get("uname")!=null&&redis.provu(map.get("uname").toString()+"#")){
            return Tojson.getSingleton().to(redis.getu((String)map.get("uname"),User.EBase64((String)map.get("upass"))));
        }
        return Tojson.getSingleton().to("用户名不存在");
    }

}
