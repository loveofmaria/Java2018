package extr;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 定义一个泛型类 DAO<T>, 在其定义一个Map成员变量，Map的键为String类型，值为T类型；
 * <p>
 * 创建一下方法：
 * <p>
 * *   public void save(String id, T entity) 保存T类型的对象到Map成员变量
 * *   public T get(String id) 从map中获取id对应的对象
 * *   public void update(String id, T entity) 替换map中key为id的内容，改为entity对象
 * *   public List<T> list() 返回map中存放的所有T的对象
 * *   public void delete(String id) 删除指定id的对象
 * <p>
 * 定义一个User类： *
 * 该类包含 private int id, age,     private String  name
 * <p>
 * 定义一个测试类： *
 * 创建DAO类的对象，分别调用save，get，update，list，delete方法操作User对象
 */
public class DAO<T> {

    private Map<String, T> map;

    public Map<String, T> getMap() {
        return map;
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for(T t:values){
            list.add(t);
        }
        return list;
    }

    public void delete(String id) {
        if (map.keySet().contains(id)) {
            map.remove(id);
        }
    }
}

class User {
    private String name;
    private int age, id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (id != user.id) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + id;
        return result;
    }

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
}

class DAOtest {
    @Test
    public void test1() {
        User u1 = new User("张晓化", 23, 1001);
        User u2 = new User("张非", 28, 1002);
        User u3 = new User("刘备", 35, 1003);
        User u4 = new User("聊化", 43, 1004);
        User u5 = new User("马晓", 52, 1005);
        User u6 = new User("关于", 33, 1006);
        User u7 = new User("曹操", 37, 1007);

        HashMap<String, User> map = new HashMap<>();
        map.put("1001", u1);
        map.put("1002", u2);
        map.put("1003", u3);
        map.put("1004", u4);
        map.put("1005", u5);
        map.put("1006", u6);
        map.put("1007", u7);

        DAO<User> userDao = new DAO<User>(map);
        System.out.println(userDao.get("1002"));
        userDao.save("1008", new User("陆丰", 32, 1008));

        System.out.println(userDao.get("1001"));
        userDao.update("1001", new User("黄忠", 55, 1001));
        System.out.println(userDao.get("1001"));

        userDao.delete("1001");

        ArrayList<User> listUser = (ArrayList<User>) userDao.list();
        System.out.println(listUser);


    }
}