package json;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class Tojson {
    private volatile static Tojson tojson;
    private Tojson (){}
    public static Tojson getSingleton() {
        if (tojson == null) {
            synchronized (Tojson.class) {
                if (tojson == null) {
                    tojson = new Tojson();
                }
            }
        }
        return tojson;
    }
    public String to(String content){
        Map map=new HashMap();
        map.put("rs",content);
        return JSON.toJSONString(map);

    }
    public String too(String np,String connection,String ... strings){
        Map map =new HashMap();
        map.put(np,connection);
        String s1 = "";
        String s2="";
        int i=1;
        for(String s:strings){
            if(i==1){
                s1=s;
                i++;
            }else {
                s2=s;
                map.put(s1,s2);
                i=1;
            }
        }
        return JSON.toJSONString(map);
    }


}
