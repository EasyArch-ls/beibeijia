package redis;

import java.util.Map;

public interface IRedis {

    boolean setp(String phone, String code);

    String getp(String phone);

    boolean setu(String uname, String pass);

    String getu(String uname, String pass);

    void setinformation(String Bphone, Map map);

    Map getinformation(String Bphone);

    boolean provp(String phone);

    void putp(String phone, String uname);

    boolean provu(String uname);

    void putu(String uname, String Bphone);

    String get(String name);
}
