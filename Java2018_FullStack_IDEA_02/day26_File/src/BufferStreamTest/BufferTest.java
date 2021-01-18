package BufferStreamTest;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferTest {
    @Test
    public void test1() throws IOException {
        File f = new File("index.jpeg");
        File f1 = new File("复制品.jpeg");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f1);
            fis = new FileInputStream(f);

            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while (true) {

                if (!((len = bis.read(buffer)) != -1)) break;
                try {
                    bos.write(buffer, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


