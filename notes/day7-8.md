>   面向对象第二天

##### 完成一个项目[或者功能]的思路

*   根据问题需要,选择问题所针对的现实世界中的实体;
*   从实体中寻找解决问题相关的属性和功能,这些属性和功能就形成 了概念世界中的类;
*   把抽象的实体用计算机语言描述,形成计算机世界中的类的定义,把类构造成计算机能够识别和处理的数据结构;
*   将类实列化成计算机世界中的对象.对象是计算机世界中解决问题的最终工具.



#### 匿名对象

*   创建对象没有显示的赋给一个变量名
*   特征: 匿名对象只能调用一次[ 结束后自动丢弃 ]
*   最常使用的场景: 使用其他类来调用[ 下面代码中的PhoneMall 类实列来调用 ]

```java
class TestPhone{
    public static void main(String[] args){
        //使用匿名对象
        // 下面每一次调用内方法,都是一个新的对象
        new Phone().sendEmail();
        new Phone().playGame();
        new Phone().price = 2000; // 设置了一个属性
        new Phone().showPrice(); // 这里不是2000,而是 0.0
        // 通过 PhoneMall 类的实例来使用 Phone的匿名对象
        // 实际作用就是在其他类的对象中调用另一个类实例的功能,但是又不会创建具体实例
        PhoneMall pm = new PhoneMall();
        // 这里的 new Phone() 这个对象已经赋值给了 show(Phone phone) 中的 phone形参,在内存中用 phone 这个形参名来调用
        pm.show(new Phone());
    }
}

class Phone {
    double price; //价格
    
    Phone() {};// 构造函数
    
    public void showPrice(){
        System.out.println(price);
    }
    public void sendMail(){
        System.out.println("发邮件!");
    }
    public void playGam(){
        System.out.println("玩游戏!");
    }
}

// 出现的使用场景
class PhoneMall{
    public void show(Phone phone){
        phone.sendEmail();
        phone.playGame();
    }
}
```







