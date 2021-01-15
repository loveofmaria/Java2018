package IOoperationTest;

import org.junit.jupiter.api.Test;

import java.io.*;

public class FileStreamTest {
    @Test
    public void Test() {
        FileReader fr = null;
        try {
            File f = new File("testFiles/hello.txt");
            fr = new FileReader(f);
            while (fr.read() != -1) {
                System.out.print((char) fr.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        File f = new File("testFiles/hello.txt");
        FileReader fr = null;

        try {
            fr = new FileReader(f);
            char[] buffer = new char[5];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        File file = new File("testFiles/hello.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            fw.write("7. 魔兽世界完10年，还会是iname经典\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        File f = new File("testFiles/hello.txt");
        File f1 = new File("testFiles/hello1.txt");
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(f);
            fw = new FileWriter(f1, true);
            char[] bufferChars = new char[5];
            int len;
            while ((len = fr.read(bufferChars)) != -1) {
                fw.write(bufferChars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
