package EnumDemo1;

enum StuffInOffice implements Info {
    MANAGER("章麻子", "经理", 30){
        @Override
        public void show() {
            System.out.println("我是" + this.getName() + "我怕过谁啊?");
        }
    },
    USER("二傻子", "员工", 29){
        @Override
        public void show() {
            System.out.println("我是" + this.getName() + "把噶压路，去西藏");
        }
    },
    MODIFY("王二小", "管理员", 32){
        @Override
        public void show() {
            System.out.println("我是" + this.getName() + "把敌人引入我军的包围圈");
        }
    },
    OTHERS("无名", "闲人", 22){
        @Override
        public void show() {
            System.out.println("我是" + this.getName() + "闲杂人等，不要闯入");
        }
    };

    private final String name;
    private final String desc;
    private final int age;

    StuffInOffice(String name, String desc, int age){
        this.name = name;
        this.desc = desc;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "姓名: " + this.getName() +
                "\n" + "职位: " + this.getDesc() +
                "\n" + "年龄: " + this.getAge() +
                "\n";
    }
}

interface Info {
    void show();
}