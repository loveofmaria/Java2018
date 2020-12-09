class MyExceptionTest extends RuntimeException {
    static final long serialVersionUID = 203910394L;

    public MyExceptionTest () {}
    public MyExceptionTest (String msg) {
        super(msg);
    }
}