package MapSubClassDemo;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    @Test
    public void test(){
        Map map = new HashMap();
//        map.put(null, null);
        map.put("Name", "高盛");
        map.put("Age", 20);
        map.put("Josh", 21);
        map.put("Jordan", 320);
        map.put("Mike", 204);
        map.put("Jack", 2065);
        map.put("Mack", 2022);

//        System.out.println(map);
//        System.out.println(map.get("Name"));
//        System.out.println(map.containsKey("Age"));
//        System.out.println(map.containsValue(20));
        Collection collection = map.values();
        for(Object obj: collection){
            System.out.println(obj);
        }
    }
}
