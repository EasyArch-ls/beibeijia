package controller;

import bean.Sensorx;
import com.alibaba.fastjson.JSON;

public class Sensor {
    private Sensorx sensorx;
    public String Return(String s) {
        sensorx=new Sensorx();
        sensorx = JSON.parseObject(s, sensorx.getClass());
        return "";
    }
}
