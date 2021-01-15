package exrt;

import java.io.File;

public class FindJpgFilesDemo {
    public static void main(String[] args) {
        File folder = new File("files");
        System.out.println(findJPG(folder.getName()));
    }

    public static StringBuffer findJPG(String folder) {
        File path = new File(folder);
        StringBuffer fs = new StringBuffer();
        if (!path.exists()) {
            return fs;
        }
        String fileType = ".txt";
        File[] filesList = path.listFiles();
        if (filesList != null) {
            for (File file : filesList) {
                if (file.isFile()) {
                    if (file.getName().endsWith(fileType)) {
                        fs.append(file.getName()).append(" ");
                    }
                } else {
                    findJPG(file.getName());
                }
            }
        }
        return fs;
    }
}
