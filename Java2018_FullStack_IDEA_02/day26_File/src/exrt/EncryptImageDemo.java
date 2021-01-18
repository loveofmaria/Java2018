package exrt;

import java.io.*;

public class EncryptImageDemo {
    public static void main(String[] args) {

    }

    public void encryptImage(File file){
        try {
            FileInputStream fi = new FileInputStream(new File(String.valueOf(file)));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fi);

            FileOutputStream fo = new FileOutputStream(new File("encryptFile.png"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fo);

            byte[] bufferSize = new byte[10];
            int len=0;
            while(true){
                try {
                    if ((len = bufferedInputStream.read(bufferSize)) == -1) break;
                    bufferedOutputStream.write(bufferSize, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
