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
        Window window4 = new Window("窗口4");

        window1.start();
        window2.start();
        window3.start();
        window4.start();
    }
}

class Window extends Thread {
    private static int TICKETS = 100;
    Window(String name){
        super(name);
    }


    @Override
    public void run() {
        while(true) {
            if(TICKETS > 0){
                System.out.println(getName() + ": 卖票, 票号为: " + Window.TICKETS);
                Window.TICKETS--;
            }
            else {
                System.out.println("票已售完.....");
                break;
            }
        }
    }
}