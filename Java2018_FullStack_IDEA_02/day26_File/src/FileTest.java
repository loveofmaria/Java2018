import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {
    @Test
    public void test() {
        File file = new File("files/hello.txt");
        File file1 = new File("../", "JavaFiles");
        File file2 = new File(file1, "info.txt");

        System.out.println(file);
        System.out.println(file1);
        System.out.println(file2);
    }

    @Test
    public void test1() {
        File file = new File("files/test.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());

        File folder = new File("/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/Java2018_FullStack_IDEA_02/day26_File/src/files");
        System.out.println(folder.isDirectory());
        System.out.println(folder.isFile());
        System.out.println(folder.canExecute());
        System.out.println(folder.canRead());
        System.out.println(folder.canWrite());
        System.out.println(folder.isHidden());
    }

    @Test
    public void test2() throws IOException {
        File file = new File("files/test.txt");
        if (file.exists()) {
            System.out.println("文件已经存在");
        } else {
            System.out.println(file.createNewFile());
        }
        System.out.println(file.length());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
    }

    @Test
    public void test3() throws IOException {
//        File file = new File("files/tests");
//        System.out.println(file.mkdirs());
//        System.out.println(file.getName());

        File f = new File("files2");
        f.mkdirs();
        System.out.println(f.listFiles().length);

        File f2 = new File("files2/a.txt");
        f2.createNewFile();

        File f3 = new File(f2.getParent(), "b.txt");
        f3.createNewFile();
    }
}
