package teamView.service;

/*
    定义 Programmer中的状态status 属性
    枚举类
**/
public class Status {
    private final String NAME;

    private Status(String name) {
        this.NAME = name;
    };

    public String getName(){
        return this.NAME;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");
    
    @Override
    public String toString() {
        return NAME;
    }
}
