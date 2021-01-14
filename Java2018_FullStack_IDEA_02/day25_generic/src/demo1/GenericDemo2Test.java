package demo1;

import java.util.*;

public class GenericDemo2Test {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Citizen>> map = new HashMap<>();
        ArrayList<Citizen> list = new ArrayList<>();
        list.add(new Citizen("张飞"));
        list.add(new Citizen("马超"));
        list.add(new Citizen("刘备"));

        map.put("张飞", list);

        Set<Map.Entry<String, ArrayList<Citizen>>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, ArrayList<Citizen>>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, ArrayList<Citizen>> entry = iterator.next();
            String key = entry.getKey();
            ArrayList<Citizen> value = entry.getValue();
            System.out.println("户主: "+ key);
            System.out.println("家庭成员："+value);
        }
    }
}
