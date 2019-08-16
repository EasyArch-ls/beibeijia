package baidu;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import org.json.JSONObject;

import java.util.HashMap;

public class Sample {
    public static final String APP_ID = "16848422";
    public static final String API_KEY = "5WouhGaFtPpNsbIp1w9cXCtG";
    public static final String SECRET_KEY = "ECyQVMxIs1KwHb9jlfeH1HtamaWHCBBW";

    public static void main(String[] args) {
        // 初始化一个AipBodyAnalysis
        AipBodyAnalysis client = new AipBodyAnalysis(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
       // client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        String path = "/home/ls/下载/76068585.jpg";
        JSONObject res = client.bodyAnalysis(path, new HashMap<String, String>());
       // String s=res.get("person_info");
        //JSONObject res1=JSONObject;
        System.out.println(res.get("person_info").getClass());
        System.out.println(res.toString());
    }
}
