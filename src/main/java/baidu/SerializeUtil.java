package baidu;

/**
 * @Author: Zsyu
 * @Date: 19-7-20 下午6:39
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class SerializeUtil {
    // 保存对象，序列化
    public static void saveObject(Object object) throws Exception {
        ObjectOutputStream out = null;
        try {
            RandomAccessFile aFile = new RandomAccessFile("/home/ls/桌面/1.txt", "rw");
            //   fout = new FileOutputStream("/home//Videos/1.txt",true);
            FileChannel fileChannel = aFile.getChannel();
            System.out.println(aFile.length());
            byte[] bytes = null;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(object);
                oos.flush();
                bytes = bos.toByteArray();
                oos.close();
                bos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(bytes.length);
            ByteBuffer xxx = ByteBuffer.allocate(10);
            ByteBuffer xxxx = ByteBuffer.allocate(bytes.length - 10);
            xxx.put(bytes, 0, 10);
            xxxx.put(bytes, 10, bytes.length - 10);
            System.out.println(xxx);
            xxx.flip();
            xxxx.flip();
            ByteBuffer[] bufferArray = {xxx, xxxx};
            fileChannel.write(bufferArray);
            fileChannel.close();
            aFile.close();
        } finally {
        }
    }

    // 读取对象，反序列化
    public static Object readObject(Object object) throws Exception {
        //FileInputStream fin = null;
        Object obj=null;
        try {
            RandomAccessFile aFile = new RandomAccessFile("/home/ls/桌面/1.txt", "rw");
            //   fout = new FileOutputStream("/home//Videos/1.txt",true);
            FileChannel fileChannel = aFile.getChannel();
          //  System.out.println(fin.read());
            ByteBuffer xxx = ByteBuffer.allocate(11);
            ByteBuffer xxxx = ByteBuffer.allocate(63);
            ByteBuffer[] bufferArray = {xxx, xxxx};
            fileChannel.read(bufferArray);
            xxx.flip();
            xxxx.flip();
            System.out.println(xxx);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bos.write(xxx.array());
            bos.write(xxxx.array());
            byte[] bytes = bos.toByteArray();
            System.out.println(bytes.length);
            bos.close();
            ByteArrayInputStream arrayInputStream=new ByteArrayInputStream(bytes);
            ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(arrayInputStream));
            obj=ois.readObject();
            ois.close();
            fileChannel.close();
            arrayInputStream.close();

        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
           // fin.close();
        }
        return obj;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("ls");
        user.setAge(33);
        User user1 = new User();
        user1.setName("zsy");
        user1.setAge(20);

        // 保存
        try {
            SerializeUtil.saveObject(user);
        } catch (Exception e) {
            System.out.println(e);
        }
        // 读取
        User userObject;
        try {
            userObject = (User) SerializeUtil.readObject(user);
            System.out.println(userObject);
        } catch (Exception e) {
            System.out.println("读取时异常：" + e.getMessage());
        }
    }

}

