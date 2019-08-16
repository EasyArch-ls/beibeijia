package baidu;

import java.io.Serializable;

/**
 * @Author: Zsyu
 * @Date: 19-7-20 下午6:37
 */
class User implements Serializable {
    private static final long serialVersionUID = 1L;


    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

}
