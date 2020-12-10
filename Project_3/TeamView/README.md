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

*   view：TeamView

    负责显示菜单和处理用户的操作

*   service：

    实体对象（Employee及其子类）的管理模块

    *   TeamException
    *   NameListService
    *   TeamService

*   domain

    Employee及其子类等JavaBean类所在的包

    *   Employee