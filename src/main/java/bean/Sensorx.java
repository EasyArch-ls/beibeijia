package bean;

public class Sensorx {
    /*左肩：lshoulder
    右肩：rshoulder
    第一脊柱：fspine
    第二脊柱：sspine
    腹外斜肌（左）：lwaist
    腹外斜肌（右）：rwaist
    提示：tips
    */
    private String[] lshoulder;
    private String[] rshoulder;
    private String[] fspine;
    private String[] sspine;
    private String[] lwaist;
    private String[] rwaist;
    private String[] tips;

    public String[] getLshoulder() {
        return lshoulder;
    }

    public void setLshoulder(String[] lshoulder) {
        this.lshoulder = lshoulder;
    }

    public String[] getRshoulder() {
        return rshoulder;
    }

    public void setRshoulder(String[] rshoulder) {
        this.rshoulder = rshoulder;
    }

    public String[] getFspine() {
        return fspine;
    }

    public void setFspine(String[] fspine) {
        this.fspine = fspine;
    }

    public String[] getSspine() {
        return sspine;
    }

    public void setSspine(String[] sspine) {
        this.sspine = sspine;
    }

    public String[] getLwaist() {
        return lwaist;
    }

    public void setLwaist(String[] lwaist) {
        this.lwaist = lwaist;
    }

    public String[] getRwaist() {
        return rwaist;
    }

    public void setRwaist(String[] rwaist) {
        this.rwaist = rwaist;
    }

    public String[] getTips() {
        return tips;
    }

    public void setTips(String[] tips) {
        this.tips = tips;
    }
}
