package bean;

public class Camerax {

    /*上：up
    下：down
    左：letf
    右：right
    亮度：light
    对比度：contrast
    焦距：flength
    分辨率：rpower
    饱和度：saturat
    开始：time（传入开始时间）*/
    private String up;
    private String down;
    private String letf;
    private String right;
    private String light;
    private String contrast;
    private String flength;
    private String rpower;
    private String saturat;
    private String time;

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public String getLetf() {
        return letf;
    }

    public void setLetf(String letf) {
        this.letf = letf;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getContrast() {
        return contrast;
    }

    public void setContrast(String contrast) {
        this.contrast = contrast;
    }

    public String getFlength() {
        return flength;
    }

    public void setFlength(String flength) {
        this.flength = flength;
    }

    public String getRpower() {
        return rpower;
    }

    public void setRpower(String rpower) {
        this.rpower = rpower;
    }

    public String getSaturat() {
        return saturat;
    }

    public void setSaturat(String saturat) {
        this.saturat = saturat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
