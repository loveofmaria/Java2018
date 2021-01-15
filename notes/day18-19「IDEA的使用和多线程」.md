### 多线程



#### 基本概念： 程序、进程、线程

*   **程序**[Program] - 为了完成特定任务、用某种语言编写的一组指令的集合

*   **进程**[ process ] - 是程序的一次执行过程，或是正在运行的一个程序。

    进程是一个动态的过程：有自生的产生、存在和消亡的过程 —— 生命周期

    *   比如：运行中的QQ，运行中的播放器等等
    *   程序是静态的，进程是动态的
    *   进程作为资源分配的单位，系统在运行时会为每个进程分配不同的内存区域

*   线**程**[ thread ] - 进程可进一步细化为线程，是一个程序内部的一条执行路径

    若一个进程同一时间并行执行多个线程，就是支持多线程的

    线程作为调度和执行的单位，每个线程拥有独立的运行栈和程序计数器[ PC ]，线程切换的开销小

    一个进程中的多个线程共享相同的内存单元/内存地址空间 -» 它们从同一堆中分配对象，可以访问相同的变量和对象。这就使得线程间通信更简便、高效。但多个线程操作共享的系统资源可能会带来安全隐患

    单核CPU和多核CPU

    单核是一种假的多线程

    多核才能更好的发挥多线程效率

    一个Java的应用程序至少有3个线程：主线程main()  垃圾回收线程 gc()  异常处理线程

*   **并行和并发**

    *   并行：多个CPU同时执行多个任务
    *   并发：一个CPU「采用时间片」同时执行多个任务

*   **使用多线程的优点**

    *   提高应用程序相应，对图形化界面更有意义，可增强用户体验
    *   提高计算机系统CPU的利用率
    *   改善程序结构，将既长又复杂的进程分为多个线程，独立运行，利于理解和修改

*   **需要创建多线程的场景**

    *   程序需要同时执行两个或多个任务
    
    *   程序需要实现一些需要等待的任务时，如果用户输入、文件读写操作、网络操作、搜索等等
    
    *   需要一些后台运行的程序时
    
        

#### 线程的分类

Java中的线程分为两类:

一种是守护线程；

一种是用户线程；

*   它们在几乎每个方面都是相同的，唯一的区别就是判断JVM何时离开

*   守护线程是用来**服务用户线程**的，通过start()方法前调用 thread.setDaemon(true)可以把一个用户线程变成一个守护线程

*   Java垃圾回收就是一个典型的守护线程

*   若JVM中都是守护线程，当前JVM将退出

    

#### 线程的创建和使用

*   Java语言的JVM允许程序运行多个线程，它通过`java.lang.Thread`类来体现

*   **Thread类的特征**

    *   每个线程都是通过某个特定的Thread对象的run()方法来完成操作，经常把run()方法的主体称为线程体
    *   通过Thread对象的start()方法来启动这个线程，而非直接调用run()

*   **创建方式**「两种」:

    *   方式一：

        1.  继承Thread类

        2.  重写Thread类的run()方法 —> 此线程将要执行的操作写在该方法中

        3.  创建Thread类子类的对象

        4.  通过子类的实例对象调用start()方法

        5.  不能通过调用run()方法来创建线程；一个线程不能同时多次开启「除非创建一个新的线程」

        6.  也可以通过匿名类的方式创建

            ```java
            //匿名类的形式创建
            new Thread(){
                @Override
                public void run() {
                    // do something here
                }
            }.start();
            ```

            

    *   方式二:

        1.  创建一个实现了Runnable接口的类
        2.  实现类去实现Runnable中的抽象方法：run()
        3.  创建实现类的实例对象
        4.  将此对象作为参数传递给Thread类的构造器中，创建Thread对象
        5.  通过Thread类的对象调用start( )
        
        ```java
        // 
        class PrimeRun implements Runnable {
            long minPrime:
            primeRub(long minPrime) {
                this.minPrime = minPrime;
            }
            
            public void run() {
                // doSomething here
            }
        }
        
        PrimeRun p = new PrimeRun(143);
        new Thread(p).start();// 第一个线程
        new Thread(p).start();// 第二个线程
        ```
        
    *   两种创建方式的比较:

        实际使用中，优先选择实现Runnable接口的方式

        本质上，Thread类也是通过实现Runnable的run() 方法创建多线程的

        1.  Runnable 方式没有类的单继承性的局限性；
        2.  实现方式更适合处理多个线程有共享数据的情况；

*   **Thread类的常用方法:**

    *   void start() -> 启动线程，并执行 run( ) 方法

    *   run() -> 线程在被调度时执行的操作

    *   String getName() -> 返回线程的名称

    *   void setName(String name) -> 设置当前线程的名称, 

        或者直接使用构造器+name参数 subThread("子进程")

        ```java
        class SubThread extends Thread {
            SubThread(String name) {
                super(name);
            }
            @Override
            public void run () {
                // dosomething here
            }
        }
        ```

        

    *   static Thread currentThread() -> 返回当前线程，在Thread子类中就是 this, 通常用于主线程和Runnable实现类

    *   static void yield() -> 线程让步

        *   暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程
        *   若队列中没有同优先级的线程，忽略此方法

    *   join() -> 当某个程序执行流中调用其他线程的 join() 方法时，调用线程将被阻塞，直到join()方法加入的join线程执行完成为止

        *   低优先级的线程也可以获得执行

    *   static void sleep(long millis) -> 指定自定义阻塞时间[毫秒]

        *   令当前活动线程在指定时间段内放弃对CPU控制，使其他线程有机会被执行，时间到后重排队；
        *   抛出InterruptedException 异常

    *   stop() -> 强制线程生命期结束，不推荐使用

    *   boolean isAlive() -> 判断线程是否还存活

*   **线程的调度**

    *   调度策略 : 时间片  抢占式「高优先级的线程抢占CPU」
    *   Java的调度方法:
        1.  同优先级的线程组成先进先出队列「先到先服务」，使用时间片策略
        2.  对高优先级，使用优先调度的抢占式策略
    *   线程优先级
        *   线程的优先级等级
            *   MAX_PRIORITY: 10
            *   MIN_PRIORITY: 1
            *   NORM_PRIORITY: 5
        *   涉及的方法
            *   getPriority( ) 返回线程优先值
            *   setPriority(int newPriority) 改变线程的优先级
        *   说明
            *   线程创建时继承父线程的优先级
            *   低优先级只是获得调度的概率低，并非一定是在高优先级线程后才被调用
    
    

#### 线程的生命周期

*   JDK中用Thread.State类定义了线程的几种状态

    想要实现多线程，必须在主线程中创建新的线程对象。Java语言使用Thread类及其子类的对象来表示线程，在它的一个完整的生命周期中通常要经历如下五种状态：

    1.  新建：当一个Thread类或其子类的对象被声明并创建时，新生的线程对象处于新建状态；

    2.  就绪：处于新建状态的线程被start()后，将进入线程队列等待CPU时间片，此时它已具备了运行条件，只是没分配到CPU资源；

    3.  运行：当就绪的线程被调度并获得CPU资源时，并进入运行状态，run( ) 方法定义了线程的操作和功能

    4.  阻塞：在某种特殊情况下，被认为挂起或执行输入输出操作时，让出CPU并临时终止自己的执行，进入阻塞状态

    5.  死亡：线程完成了它的全部工作或者线程被提前强制性地终止或者出现异常导致结束

        ![ ](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/线程的生命周期.png)

#### 线程的同步

*    问题一：线程的安全问题

    某个线程操作数据尚未完成，而其他线程也参入进来操作数据

    1.  多个线程执行的不确定性引起执行结果的不稳定
    2.  多个线程对账本的共享，会造成操作的不完整性，会破坏数据
    3.  卖票的极端情况，几个线程同时卖最后一张票

    **问题解决方式**：当前存在某个线程操a作数据时，其他线程必须禁止参入进来，直到当前a线程操作完成,这种情况。即使a出现阻塞情况，也不能让其他线程参入进来！在Java中，通过同步机制，来解决线程的安全问题。

    1.  方式一：同步代码块 

        **同步代码**：操作共享数据的代码即为同步代码块

        **共享数据**：多个线程共同操作的变量

        **同步监视器**：俗称为进程锁。任何一个类的对象，都可以充当进程锁「该对象必须是同一个对象，即同一把锁」

        ```java
        /*
            synchronized(同步监视器){ 
                // 需要被同步的代码
            }
        */
        // 进程锁[同步监视器] - obj「任意一个类对象」
        Object obj = new Ojbect();
        synchronized(obj) {
            // 需要同步的代码
        }
        ```

    2.  方式二：同步方法
    
        如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的
    
        ```java
        // 同步方法-把需要同步的代码块包裹在方法内部中,同步监视器就是 this
        pvivate synchronized void show() {
            if (ticket > 0) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("[%s] - 票号: %s\n", Thread.currentThread().getName(), ticket);
                ticket--;
            }
        }
        
        // run() 方法中调用
        @Override
        public void run() {
            while (true) {
                show();
            }
        }
        ```
    
    3.  **同步方法总结**：
    
        [如果是Runnable方式，则无需static修饰方法，如果是继承方式，那么就要使用static修饰方法]
    
        ```java
        // 继承 Thread 的方式的同步方法
        // 同步监视器是 this
        private static synchronized void runWindow();
        
        // 实现 Runnable 方式的同步方法
        // 同步监视器是 class
        private synchronized void runWindow();
        ```
    
        
    
        *   同步方法仍然涉及到同步监视器，只是不需要我们显示的声明
        *   非静态的同步方法，同步监视器是 this 「当前实例」
        *   静态的同步方法，同步监视器是：当前类本身
    
    4.  **单例懒汉模式的线程锁示例**
    
        ```java 
        class Bank {
            private Bank() {
            }
        
            private static Bank instance = null;
        	
            // 方式一
            public static synchronized Bank getInstance() {
                if (instance == null) {
                    instance = new Bank();
                }
                return instance;
            }
            
            // 方式二
            public static Bank getInstance() {
                synchronized (Bank.class) {
                    if (instance == null) {
                    instance = new Bank();
                }         
               }
                return instance;
            }
        }
        ```
    
    5.  **线程的死锁问题**
    
        *   死锁的描述
            *   不同的线程分别占用对方需要的同步资源不放弃，从而造成都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
            *   出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
        *   解决方法
            *   专门的算法和原则来规避
            *   尽量减少同步资源的定义
            *   尽量避免嵌套同步
        
    6.  **Lock[锁]**
    
        *   从JDK5.0开始，Java提供了更强大的线程同步机制——通过显示的定义同步锁对象来实现同步。同步锁使用Lock对象充当。
    
        *   java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具。锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁，线程开始访问共享资源之前应先获得Lock对象
    
        *   ReentrantLock 类实现了Lock，它拥有与 synchronized 相同的并发性和内存语义，在实现线程安全的控制中，比较常用的是ReentrantLock, 可以显示加锁，释放锁
    
            ```java
            class WindowLock implements Runnable {
                private int tickets = 100;
                private ReentrantLock lock = new ReentrantLock();
            
                @Override
                public void run() {
                    // 上锁
                    lock.lock();
                    try {
                        while (true) {
                            if (tickets > 0) {
                                try {
                                    Thread.sleep(300);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                tickets--;
                            } else {
                                break;
                            }
                        }
                    } finally {
                        // 解锁
                        lock.unlock();
                    }
            
                }
            }
            
            // synchronized 和 lock的区别
            // lock 手动设置加锁和释放, synchronized 自动加锁和释放锁
            // lock 只有代码块锁， synchronized 有代码块锁和方法锁
            // 使用 Lock 锁，JVM将话费较少的时间来调度线程，性能更好。并且有更好的扩展性（提供更多的子类）
            
            ```
    
            
    
    7.  练习：
    
        ```java
        // 银行账户，两个储户分别向同一个账户存3000，每次存1000，存3次。每次存完打印账户余额。
        // 如何解决存在的线程安全问题
        // 1. 明确需要多线程运行的部分
        // 2. 明确共享部分的数据
        // 3. 明确多线程运行代码中的需要操作共享数据的代码
        ```
    
        

#### 线程的通信

*   wait( ) 一旦执行此方法，当前的线程就会进入阻塞状态「沉睡状态」，并且释放同步监视器「线程锁」
*   notify( ) 一旦执行此方法，就会唤醒被 wait() 的一个线程[ 根据线程优先级 ]
*   notifyAll( ) 一旦执行此方法，就会唤醒被 wait() 的所有线程
*   注意点：
    1.  上面的3种方法，只能出现在同步代码块或者同步方法中
    2.  该三个方法的**调用者**必须是同步代码块或者同步方法的监视器「相同的对象」
    3.  这三个方法被定义在 java.lang.Ojbect 类中
    4.  习题：sleep() 和 wait() 的异同
        *   相同：都可以让线程进入阻塞状态
        *   不同：
            1.  两个方法的声明位置不同
            2.  调用的范围不同「一个是自由调用，一个是必须在同步代码块或者同步方法中调用」
            3.  关于是否释放同步监视器：sleep()不会释放，wait() 会释放



#### 经典例子：生产者/消费者问题

*   生产者「Productor」将产品交给店员「Clerk」，而消费者「Customer」从店员处取走产品，店员一次只能持有固定数量的产品「比如：20」，如果生产者试图生产更多的产品，店员会叫生产者停一下，，如果店中有空位放置产品了在通过生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了在通知消费者来取走产品；
*   可能出现的两个问题：
    1.  生产者比消费者快时，消费者会漏掉一些数据没有获取到；
    2.  消费者比生产者快时，消费者会获取到相同的数据；
*   分析：
    1.  是否是多线程问题 =＞　是！消费者线程和生产者线程
    2.  是否存在线程安全问题「是否有共享数据」＝＞　是，比如店员或者产品
    3.  解决方式　＝＞　同步及其，三种方法
    4.  是否涉及线程间通信 => 是



#### 新增线程创建方式「 JDK5.0后新增 」

*   新增方式一：实现 Callable接口

    *   与Runnable相比，Callable功能更加强大些

        1.  相比run( )方法，call()可以有返回值

        2.  可以抛出异常

        3.  支持泛型的返回值

        4.  需要借助FutureTask类，比如获取返回结果

            **Future接口：**

            *   可以对具体Runnable，Callalble任务的执行结果进行取消、查询是否完成，获取结果等。
            *   FutureTask是Future接口的唯一实现
            *   FutureTask同时实现了Runnable、Future接口，它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值

    *   避免创建大量线程时的资源耗费，影响性能，可以提前创建多个线程，放入线程池，在使用的时候直接获取，使用结束放回池中。
    *   优点：
        1.  提高相应速度「减少创建新线程的时间」
        2.  降低资源消耗「重复利用池中线程，不需要每次都创建」
        3.  便于线程管理：
            *   corePoolSize => 核心池大小
            *   maximumPoolSize => 最大线程数
            *   keepAliveTime => 线程没有任务时最多保持多长时间后会终止
            *   ......

    

    #### 线程池相关API

    *   API => ExecutorService、Executors

    *   ExecutorService：真正的线程池接口。常见的子类ThreadPoolExecutor

        -> void execute(Runnable command): 执行任务/命令，没有返回值，一般用来执行Runnable

        -> <T>Future<T>submit(Callable<T>task): 执行任务，有返回值，一般又来执行Callable

        -> void shutdown(): 关闭连接池

        -> execute() 适合用于Runnable;  submit() 适合用于 Callable;

    *   Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池

        *   Executors.newCachedThreadPool() 创建一个可以根据需要创建新线程的线程池
        *   Executors.newFixedThreadPool(n) 创建一个可重用固定线程数的线程池
        *   Executors.newSingleThreadExecutor() 创建一个只有一个线程的线程池
        *   Executors.newScheduledThreadPool(n) 创建一个线程池，它可以安排在给定延迟后运行命令或者定期执行

    *   代码

        ```java
        public class ThreadPoolDemo01 {
            public static void main(String[] args) {
                // 1. 提供指定线程数量的线程池
                ExecutorService service = newFixedThreadPool(10);
                // 获得真实的线程池类对象
                ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
                // 设置属性
                service1.setCorePoolSize(15);   
                // 2. 执行指定的线程操作，需要提供实现Runnable接口或Callable接口实现类的对象
                service.execute(new NumberThread());
                service.execute(new NumberThread1());
                // 3.关闭连接池
                service.shutdown();
        		//  service.submit() => 适用于Callable
            }
        }
        
        // 要实现的功能
        class NumberThread implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.printf("[%s] - %s\n", Thread.currentThread().getName(), i);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
        // 要实现的功能1
        class NumberThread1 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.printf("[%s] - %s\n", Thread.currentThread().getName(), i);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        ```

        

    

    

    

    

    

    

    