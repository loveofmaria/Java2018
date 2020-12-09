import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsTest {
    public static void main(String[] args) {
        ThrowsTest.ExceptionsHandlerTest();
    }

    static void ExceptionsHandlerTest() {
        try {
            FileHandler();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void FileHandler() throws IOException {
        File file = new File("hello.txt");
        FileInputStream f = new FileInputStream(file);

        int data = f.read();
        while (data != -1) {
            System.out.println((char) data);
            data = f.read();
        }
        f.close();
    }
}
