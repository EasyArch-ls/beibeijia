package bean;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class User {
    private String uname;
    private String upass;
    private String phone;
    private String sex;
    private String region;
    private String photo;
    private String height;//身高
    private String weight;//体重
    private String swidth;//肩宽
    private String twaist;//腰围
    private String bust;//胸围
    private String slength;//脊柱长度

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {

        this.photo = EBase64(photo);
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSwidth() {
        return swidth;
    }

    public void setSwidth(String swidth) {
        this.swidth = swidth;
    }

    public String getTwaist() {
        return twaist;
    }

    public void setTwaist(String twaist) {
        this.twaist = twaist;
    }

    public String getBust() {
        return bust;
    }

    public void setBust(String bust) {
        this.bust = bust;
    }

    public String getSlength() {
        return slength;
    }

    public void setSlength(String slength) {
        this.slength = slength;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = EBase64(upass);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /*public User(String uname, String upass, String phone, String code) {
        this.uname = uname;
        this.upass = upass;
        this.phone = phone;
        this.code = code;
    }*/

    public static String EBase64(String s){
        Base64.Encoder encoder = Base64.getEncoder();
        String re="";
        try {
            byte[] bytes=s.getBytes("utf-8");
            re =encoder.encodeToString(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return re;
    }

    public static String DBase64(String s){
        Base64.Decoder decoder = Base64.getDecoder();
        String re="";
        try {
            re =new String(decoder.decode(s),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return re;
    }

}
