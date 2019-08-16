package controller;

import bean.User;
import com.alibaba.fastjson.JSON;
import hbase.Create;
import json.Tojson;
import mybatis.Mymybatis;
import redis.Redis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Pdata {
    private Map map;
    public String Return(String s) throws IOException {
        map=new HashMap<String,String>();
        map = JSON.parseObject(s, map.getClass());
        Redis redis = Redis.jediss;
        String s1="";
        if(map.get("phone")==null){
            s1=User.EBase64((String) map.get("phone"));
        }else {
            s1=redis.get(map.get("uname").toString()+"#");
        }
        new Mymybatis().pdata(User.EBase64(map.get("phone").toString()),map);
        //new Create().insert("user", s1,"pdata",map);
        redis.setinformation(User.EBase64(map.get("phone").toString()),map);
        return Tojson.getSingleton().to("保存成功");
    }


}
