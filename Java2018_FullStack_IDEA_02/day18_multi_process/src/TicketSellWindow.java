/**
 * @author 瓜哥
 * @projectName Java2018_FullStack_IDEA_02
 * @packageName PACKAGE_NAME
 * @createdTime 2020-12-12 4:05 PM
 */
public class TicketSellWindow {
    public static void main(String[] args) {
        Window window1 = new Window("窗口1");
        Window window2 = new Window("窗口2");
        Window window3 = new Window("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class Window extends Thread {
    private int ticket = 100;
    Window(String name){
        super(name);
    }
    @Override
    public void run() {
        while(true) {
            if(ticket > 0){
                System.out.println(getName() + ": 卖票, 票号为: " + ticket);
                ticket--;
            }
            else {
                System.out.println("票已售完.....");
                break;
            }
        }
    }
}