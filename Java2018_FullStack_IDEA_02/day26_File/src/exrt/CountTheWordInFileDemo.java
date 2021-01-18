package exrt;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountTheWordInFileDemo {
    public static void main(String[] args) {
        File f = new File("test1.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeToFile(Objects.requireNonNull(getCountMap(f)));
    }

    public static Map<Character, Integer> getCountMap(File file) {
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            Map<Character, Integer> map = new HashMap<>();
            int c;
            while (true) {
                try {
                    if ((c = fr.read()) == -1) break;
                    char ch = (char) c;
                    map.merge(ch, 1, Integer::sum);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return map;
        } catch (FileNotFoundException e) {
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
        return null;
    }

    public static void writeToFile(Map<Character, Integer> map) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("count.txt"));
            for(Map.Entry<Character, Integer> c : map.entrySet()){
                System.out.println(c);
                fw.write(c.toString() +"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
