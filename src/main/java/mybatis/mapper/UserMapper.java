package mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserMapper {
    Map select(@Param("phone") String phone);
    void regis(@Param("phone")String phone,@Param("uname")String uname,@Param("upass")String upass,@Param("sex")String sex,@Param("region")String region,@Param("photo")String photo);
    void pdata(@Param("phone")String phone,@Param("height")String height,@Param("weight")String weight,@Param("swidth")String swidth,@Param("twaist")String twaist,@Param("bust")String bust,@Param("slength")String slength);
}
