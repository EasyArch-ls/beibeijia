package mybatis;

import mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Mymybatis {
    private static String conf;
    private static Reader reader;
    private static SqlSessionFactoryBuilder sfb;
    private static SqlSessionFactory sf;
    private static SqlSession session;
    private static UserMapper userMapper;

    public Mymybatis() throws IOException {
        conf = "mybatis-config.xml";
        reader =
                Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        sfb =
                new SqlSessionFactoryBuilder();
        sf = sfb.build(reader);
        //创建Session
        session = sf.openSession();

        //调用findAll方法
        userMapper = session.getMapper(UserMapper.class);
    }

    public  Map selset(String phone){
        Map map=new HashMap();
        map=userMapper.select(phone);
        return map;
    }

    public void regis(String phone,Map<String,String> map){
        userMapper.regis(phone,map.get("uname"),map.get("upass"),map.get("sex"),map.get("region"),map.get("photo"));
        session.commit();
    }

    public void pdata(String phone,Map<String,String> map){
        userMapper.pdata(phone,map.get("height"),map.get("weight"),map.get("swidth"),map.get("twaist"),map.get("bust"),map.get("slength"));
        session.commit();
    }



}
