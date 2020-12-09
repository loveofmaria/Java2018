public class EcmDef {

    public static void main(String[] args) {
        try {
            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);
            System.out.println(ecm(x, y));
        } catch (NumberFormatException | ArithmeticException | MyExceptionTest | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double ecm(double x, double y) throws  MyExceptionTest {
        if(x < 0 || y < 0) {
            throw new MyException("参数不能输入负数");
        }
        return x / y;
    }
}
