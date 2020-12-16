package MultiThreadDay4;

/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName MultiThreadDay4
 * @createdTime 2020-12-15 3:45 PM
 */
public class ProductAndCustomerModel {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Production production = new Production(clerk);
        production.setName("生产者1: ");
        Customer customer = new Customer(clerk);
        customer.setName("消费者1: ");
        Customer customer1 = new Customer(clerk);
        customer1.setName("消费者2: ");


        production.start();
        customer.start();
        customer1.start();
    }
}

class Clerk {
    // 店员类
    private int productions = 0;
    private int productionsCounter = 1;

    public synchronized void produceProduct() {
        if (productions < 20) {
            System.out.println(Thread.currentThread().getName() + "开始生产第" +
                    productionsCounter + "个产品");
            productions++;
            productionsCounter++;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if (productions > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" +
                    productionsCounter + "个产品!");
            productions--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getProductions() {
        return productions;
    }
}


class Production extends Thread {
    // 生产者类
    private Clerk clerk;

    Production(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产.....");
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Customer extends Thread {
    // 消费者
    private Clerk clerk;

    Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "顾客消费中.....");
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}