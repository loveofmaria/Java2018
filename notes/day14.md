#### 单例设计模式[Singleton]

* 设计模式是优选的代码结构、编程风格、思考方式，相当于针对不同的问题，使用不同的已经存在的“套路”去解决；
* 单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。如果我们要让类在一个虚拟机中只能产生一个对象，我们首先要将***类的构造器的访问权限设置成private***，这样，就不能通过new来在类的外部生产新的对象，但是在类的内部仍然可以产生该类的对象。在外部只能***调用该类的某个静态方法***返回类内部创建的对象，静态方法只能访问类中的静态成员变量，所以，指向***内部产生的该类对象的变量也必须定义成静态的***。

1. 饿汉式

   ```java
   public class SingletonTest1 {
       public static void main(String[] args) {
           Bank bank1 = Bank.getInstance();
           Bank bank2 = Bank.getInstance();
           System.out.println(bank1 == bank2); // 输出true，因为引用的是同一个Bank对象
       }
   }
   
   class Bank{
       //1.私有化构造器
       private Bank(){}
   
       //2.内部创建类的对象
       //4.此对象也必须声明为static才能返回
       private static Bank instance = new Bank();
   
       //3.提供公共的方法返回内部创建的对象
       public static Bank getInstance(){
           return instance;
       }
   }
   ```

2. 懒汉式

   ```java
   public class SingletonTest2 {
       public static void main(String[] args) {
           Order o1 = Order.getInstance();
           Order o2 = Order.getInstance();
   
           System.out.println(o1 == o2);// 输出true,引用了同一个对象
       }
   }
   
   class Order{
       //1.私有化类的构造器
       private Order(){}
   
       //2.声明当前类的一个对象，没有初始化；
       //4.此对象也必须声明为static
       private static Order instance = null;
   
       //3.声明public static 的返回当前对象的方法
       public static Order getInstance(){
           if(instance == null) {
               instance = new Order();
           }
           return instance;
       }
   }
   ```

3. 区别

   * 饿汉式：加载时间更长，但是线程安全性
   * 懒汉式：延迟对象的创建，但是不是线程安全—【多线程时在修改】

4. 单例模式的有点：

   * 由于单例模式只生成一个实例，***减少了系统性能开销***，当一个对象的生产需要比较多的资源时，如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久驻留内存的方式来解决。

   * 例子:

     ```java
     // java.lang.Runtime [饿汉式]
     public class Runtime{
         //2.创建一个私有化的当前类的对象
         //4.声明为static
         private static Runtime currentRuntime = new Runtime();
         
         //3.声明 public static，返回当前对象的方法
         public static Runtime getRuntime(){
             return currentRuntime;
         }
         //1.私有化构造器
         private Runtime(){};
     }
     ```

5. 单例模式的应用场景

   * 网站的计数器
   * 应用程序的日志应用
   * 数据库连接池
   * 项目中，读取配置文件的类
   * Application也是单例的典型应用【每一个手机应用】
   * WIndows的Task Mananger【任务管理器】
   * Windows的Recycle Bin【回收站】