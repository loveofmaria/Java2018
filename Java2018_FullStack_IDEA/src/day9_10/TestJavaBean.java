package day9_10;
/*
    JavaBean是一种Java语言写成的可重用组件，是符合下面的标准的Java类:

    1. 类是公共的
    2. 有一个无参的公共构造器
    3. 有属性，且有对应的get、set方法
    4.* 用户可以使用JavaBean将功能、处理、值、数据库访问和其他的任何可以用Java
        代码创建的对象进行打包，并且其他的开发者可以通过内部的JSP页面，Servlet、
        其他JavaBean、applet程序或者应用来使用这些对象。用户可以认为JavaBean提供
        了一种随时随地的复制粘贴功能，而不用关心任何改变。
 */
// 1 类是公共的
public class TestJavaBean {
    // 3.1 有属性
    String description;
    public static void main(String[] args) {

    }

    // 2 有一个无参的公共构造器
    public TestJavaBean(){};
    // 3.2 有get，set方法
    void setDescription(String des){
        description = des;
    }
    String getDescription(){
        return description;
    }
}
