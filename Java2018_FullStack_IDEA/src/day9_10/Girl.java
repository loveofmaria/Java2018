package day9_10;

public class Girl {

    private String name;
    private int age;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void wantMarry(Boy boy){
        System.out.println(this.name + "想要嫁给" + boy.getName() + "为妻!");
        boy.marryGirl(this);
    }


    public void compare(Girl girl){
        // 通过不同对象的属性排序
        if(this.age > girl.getAge()){
            System.out.println(girl.getName() + "更加年轻哦.....");
        } else if(this.age < girl.getAge()) {
            System.out.println(this.getName() + "更加年轻哦.....");
        } else {
            System.out.println("一样年轻，一样漂亮!");
        }
    }
}
