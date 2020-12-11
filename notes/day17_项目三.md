## 目标

*   模拟实现一个基于文本基面的 <开发团队调度软件>
*   熟悉Java面向对象的高级特性，进一步掌握编程技巧和调试技巧
*   涉及的知识点：
    *   类的继承性和多态性
    *   对象的值传递、接口
    *   static和final修饰符
    *   特殊类的使用：包装类、抽象类、内部类
    *   异常处理





## 结构

*   **view**：

    负责显示菜单和处理用户的操作

    Data.java => 提供要显示的常量数据存储「相当于数据库的作用」

    TSUtiity.java => 通用性操作类,比如格式化时间，获取键盘输入等等

    TeamView.java => 提供主界面显示及控制方法

*   **service**：

    实体对象（Employee及其子类）的管理模块

    *   TeamException =>  自定义异常，在找不到指定员工时抛出
    *   NameListService => 负责把Data中的数据封装到Employee[]数组中，同时提供获取与员工对象的操作[Employee 的方法]
    *   TeamService => 负责管理成员对象，实现添加，删除等操作
    *   Status 枚举类，提供Programmer 的 status

*   **domain**

    Employee及其子类等JavaBean类所在的包

    *   Employee 包含3个子类 [ <- Programmer, <- Designer,  <- Architect]
    *   Equipment 接口规范  getDescription() 方法
    *   Equipment的实现类—StationPC
    *   Equipment的实现类—NoteBook
    *   Equipment的实现类—Printer

    

