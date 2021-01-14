package demo1;

public class GenericDemo3Test {
}

class Person<T extends Info> {
    private T info;

    public Person(T info) {
        // 通过构造器设置信息属性内容
        this.info = info;
    }
    public void setInfo(T info){
        this.info = info;
    }
    public T getInfo(){
        return info;
    }
    @Override
    public String toString(){
        return "Peron [info=" + info + "]";
    }
}

// 假设已经定义好的接口或者类  Contact, Introduction
class GenericPerson{
    public static void main(String[] args){
        Person<Contact> per = null;
        per = new Person<Contact>(new Contact("北京市", "01065858258", "102206"));

        Person<Introduction> per1 = null;
        per1 = new Person<Introduction>(new Introduction("李磊", "男", 24));
    }
}