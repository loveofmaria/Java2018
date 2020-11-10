#### Eclipse 的 DBUG方式

略过【后面使用IDEA】



#### 方法的重写【override/overwrite】

**在子类中**根据需要对从**父类中继承来**的方法进行改造，在执行程序的时候，**子类方法会覆盖父类的方法**

1. 子类方法必须和父类方法一致【相同的方法名，参数列表】

   **如果仅仅是方法名相同，参数列表不同，那么就是方法重载而不是重写了**

2. 子类方法重写后的返回值类型不能大于父类被重写方法的返回值类型【子类：int， 父类：short => 不行】

3. 子类重写的方法使用的访问权限不能小于父类被重写的方法访问权限【子类private，父类public => 不行】

   子类不能重写父类中声明为private权限的方法

4. 子类方法抛出的异常不能大于父类被重写方法的异常

   **总结：名+参 相同**

   ​			**异常+返回 不能大于父类[父类为void, 子类不能重写]**

   ​			**权限不能小于父类[private 不能重写，因为权限最小了]**

   ​			**static是静态方法，随着类的加载而加载，这类方法不能重写**

   重写的习题：

   ```java
   // 1 如果现在在父类的一个方法定义成private访问权限，在子类中将此方法声明为default访问权限，那么这样还叫重写吗？
   ```

   

#### 四种访问权限的修饰符【回顾protected】

主要是在父类，子类的情况下使用 protected 修饰符的回顾



#### super 关键字

子类重写父类的方法后，还需要用到父类该方法的场景

1. super 可以理解为“父类的”

2. super 可以用来调用父类的：属性、方法、构造器

3. 需要显示的使用super调用父类的属性和方法，通常是因为子类中重写了同名的属性和方法

   ```java
   public class Person{
   	int id=1000;
       
       public void showID(){
           System.out.println("父类的ID：" + id);
       }
   }
   
   public class Child extends Person{
       // 重写属性
       int id=1001;
       // 重写方法，在方法中通过super调用父类的id属性
       @Override
       public void showID(){
           System.out.println("父类的ID: " + super.id);
           System.out.println("子类的ID: " + this.id);
       }
   }
   ```

   