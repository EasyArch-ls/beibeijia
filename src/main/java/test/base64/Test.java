package test.base64;

import redis.clients.jedis.Jedis;
import scala.tools.nsc.backend.icode.Members;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.get("1"));
    }
    }
