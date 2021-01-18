import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderTest {
    /*
     * 转换流测试
     */
    @Test
    public void test1() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream("test1.txt");
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            int len;
            char[] buffer = new char[1024];
            while ((len = isr.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        File file1 = new File("text1.txt");
        File file2 = new File("text_gbk.txt");
        FileOutputStream fos = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            osw = new OutputStreamWriter(fos, "GBK");

            int len;
            char[] buffer = new char[1024];
            while (true){
                try {
                    if ((len = isr.read(buffer)) == -1) break;
                    osw.write(buffer, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            if(osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
