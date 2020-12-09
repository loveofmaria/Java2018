public class ExceptionTest_01 {
    public static void main(String[] args) {
        String string = "string";
        try {
            int number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            System.out.println("没有转换成功......");
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println("另一种错误....");
        }
        finally {
            System.out.println("无论如何我都要输出一句话....");
        }
    }
}
