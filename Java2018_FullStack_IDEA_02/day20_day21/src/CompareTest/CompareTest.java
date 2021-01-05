package CompareTest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName CompareTest
 * @createdTime 2021-01-05 11:24 AM
 */
public class CompareTest {
    @Test
    public void test() {
        Goods[] goodsList = {
                new Goods("xiaomi", 230),
                new Goods("huawei", 220),
                new Goods("vovo", 70),
                new Goods("iphone", 22),
                new Goods("oppo", 10),
                new Goods("saumsun", 120),
                new Goods("motolula", 40),
                new Goods("pixels 2L", 40),
        };

        Arrays.sort(goodsList);
        for (int i = 0; i < goodsList.length; i++) {
            System.out.println(goodsList[i]);
        }
    }

    @Test
    public void test1() {
        String[] arr = new String[]{
                "AA", "CC", "BB", "FF", "GG", "MM", "WW", "NN"
        };
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    return ((String) o1).compareTo((String) o2);
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test2() {
        Goods[] goodsList = {
                new Goods("xiaomi S8", 230),
                new Goods("xiaomi S8", 20),
                new Goods("huawei", 220),
                new Goods("Volvo", 70),
                new Goods("iphone", 22),
                new Goods("oppo", 10),
                new Goods("samsung", 120),
                new Goods("Motorola", 40),
                new Goods("pixels 2L", 40),
        };

        Arrays.sort(goodsList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if(g1.getName().equals(((Goods) o2).getName())) {
                        return Integer.compare(((Goods) o1).getPrice(), ((Goods) o2).getPrice());
                    } else {
                        return ((Goods) o1).getName().compareTo(((Goods) o2).getName());
                    }
                }
                throw new RuntimeException("传入的类型不一致!");
            }
        });

        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }
}

class Goods implements Comparable {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    Goods() {
    }

    Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            int result = Integer.compare(this.price, goods.price);
            if (result == 0) {
                result = this.name.compareTo(goods.name);
            }
            return result;
        }
        throw new RuntimeException("传入的数据类型不一致!");
    }

    @Override
    public String toString() {
        return "<" + this.name + " - " + this.price + ">";
    }
}
