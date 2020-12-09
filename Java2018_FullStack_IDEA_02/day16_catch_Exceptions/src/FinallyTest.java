import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FinallyTest {
    public static void main(String[] args) {
        TestFinally();
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Java真的好啰嗦啊....");
        }
    }

    static void TestFinally() {
        try {
            String str = "123";
            int number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            int[] arr = new int[10];
            System.out.println(arr[10]);
        } finally {
            System.out.println("最后的舞曲....");
        }
    }

    void finallyHandle() {
        FileInputStream f = null;
        try {
            File file = new File("hello.txt");
            f = new FileInputStream(file);

            int data = f.read();
            while (data != -1) {
                System.out.println((char) data);
                data = f.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert f != null;
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
