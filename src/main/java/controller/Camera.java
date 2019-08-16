package controller;

import bean.Camerax;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class Camera {
    private Camerax camerax;
    public String Return(String s) {
        camerax=new Camerax();
        camerax = JSON.parseObject(s, camerax.getClass());
        return "";
    }
}
