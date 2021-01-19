import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile randomAccessFile =
                null;
        RandomAccessFile writer =
                null;
        try {
            randomAccessFile = new RandomAccessFile(new File("test.txt"), "rw");
            writer = new RandomAccessFile(new File("test1.txt"), "rw");

            byte[] bufferSize = new byte[1024];
            int len;
            while ((len = randomAccessFile.read()) != -1) {
                writer.write(bufferSize, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
