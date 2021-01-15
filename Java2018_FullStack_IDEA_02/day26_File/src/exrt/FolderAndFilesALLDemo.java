package exrt;

import java.io.File;

public class FolderAndFilesALLDemo {
    public static void main(String[] args) {
        File f = new File("files");
        int folderSize = folderSize(f);
        System.out.println(folderSize);

        deleteAll(f);
    }

    public static int folderSize(File f) {
       int folderSize = 0;

       if(f.isDirectory()) {
           File[] items = f.listFiles();
           for(File item :items){
               folderSize += folderSize(item);
           }
       }
       folderSize += f.length();

        return folderSize;
    }

    public static void deleteAll(File file) {
        if(file.isDirectory()){
            File[] items = file.listFiles();
            for(File item : items){
                deleteAll(item);
            }
        }
        file.delete();
    }
}
