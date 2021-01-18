package exrt;

import org.junit.jupiter.api.Test;

import java.io.*;

public class CopyFileDemo {

    @Test
    public void CopyVideoFileByFileStream() {
        // 节点流赋复制视频文件
        try {
            FileInputStream video = new FileInputStream(new File("test.avi"));
            FileOutputStream videoCopy = new FileOutputStream(new File("复制.avi"));

            byte[] buffer = new byte[10];
            int len;
            long start = System.currentTimeMillis();
            while (true) {
                try {
                    if (!((len = video.read(buffer)) != -1)) break;
                    videoCopy.write(buffer, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            try {
                video.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                videoCopy.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        FileInputStream v = null;
        try {
            v = new FileInputStream(new File("test.avi"));
            FileOutputStream o = new FileOutputStream(new File("复制.avi"));

            BufferedOutputStream bo = new BufferedOutputStream(o);
            BufferedInputStream bi = new BufferedInputStream(v);

            byte[] bufferSize = new byte[10];
            int len;
            long start = System.currentTimeMillis();
            while(true){
                try {
                    if (!((len=bi.read(bufferSize)) != -1)) break;
                    bo.write(bufferSize, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            long end = System.currentTimeMillis();
            try {
                bo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(end - start);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
