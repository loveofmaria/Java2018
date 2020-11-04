package day8;

public class NamelessInstanceTest {
    public static void main(String[] args) {
        // 测试匿名对象
        new Phone().sendMail();
        new Phone().playGame();
        new Phone().price = 2000;
        new Phone().showPrice();
        // 实际使用方式和场景
        PhoneMall mall = new PhoneMall();
        mall.show(new Phone());
    }
}

class PhoneMall{
    public static void show(Phone phone){
        phone.sendMail();
        phone.playGame();
    }
}

class Phone {
    // 实际项目中,与金额有关的数据类型一定不能设置成带小数点的类型
    int price;

    // 功能
    public void sendMail() {
        System.out.println("发送邮件!");
    }

    public void playGame() {
        System.out.println("玩游戏!");
    }

    public void showPrice() {
        System.out.println(price);
    }
}
