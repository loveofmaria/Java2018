package exrt;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class CreateDeleteMultiFilesDemo {

    public static void main(String[] args) {

        File file = new File("files/1.txt");
        File file1 = new File("files/2.txt");
        File file2 = new File("files/3.txt");
        File folder = new File("files/newFolder");
        File folder1 = new File("files/newFolder1");
        try {
            folder.mkdirs();
            folder1.mkdirs();
            file.createNewFile();
            file1.createNewFile();
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(deleteFile("files/1.txt"));

        File f = new File("files");
        System.out.println(Arrays.toString(f.listFiles()));
    }

    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        }
        return file.delete();
    }
}
