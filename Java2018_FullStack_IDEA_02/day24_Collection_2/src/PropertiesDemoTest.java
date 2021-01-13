import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemoTest {
    public static void main(String[] args)  {
        Properties properties = new Properties();
        try{

            FileInputStream fileInputStream = new FileInputStream("/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/Java2018_FullStack_IDEA_02/day24_Collection_2/src/jdbc.properties");
            properties.load(fileInputStream);

            String name = properties.getProperty("name");
            String passwd = properties.getProperty("password");
            fileInputStream.close();
            System.out.println("name = " + name);
            System.out.println("password = " + passwd);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
