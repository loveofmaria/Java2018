#### 本日内容：

1. 循环结构「for」

2. 循环结构「while」

3. 循环结构「do  while」

4. 方法的概述和语法格式

5. 方法的重载概述和基本适用

   

#### for 循环练习：

1. 控制台输出 1 - 10；

2. 控制台输出 10 - 1；

3. 求1 - 10 之和

4. 求1 - 100 之和

5. 求1 - 100 之间 偶数 | 奇数 和

6. 水仙花数「水仙花数是一个三位数，其各位数字的立方和等于该数本身」

   比如：153 = 1x1x1 + 5x5x5 + 3x3x3 = 1 + 125 + 27 = 153

   统计数量

   ```java
   public class Demo6 {
   
   	public static void main(String[] args) {
   		// TODO Auto-generated method stub
   		// 输出所有水仙花数
   		// 水仙花数：三位，各位数字的立方之和等于该数字
   		// 153 = 1*1*1 + 5*5*5 + 3*3*3 = 1 + 125 + 27 = 153
   		
   		int h,t,d,count;
           
           count = 0;
   		
   		for (int i=100; i<=999; i++) {
   			
   			b = i / 100 % 10;
   			s = i / 10 % 10;
   			g = i % 10;				
   			
   			if ((b*b*b + s*s*s + g*g*g) == i) {
                   count += 1;
   				System.out.println(i);
   			}			
   		}
           System.out.println("1000以内的水仙花数为" + count + "个");
   	}
   
   }
   ```

   

#### while 循环练习:

实现「for循环」的练习



#### 循环嵌套练习「print 和 println 的区别」:

1. 输出一个4行5列的星星图

   ```java
   public class Demo14 {
   
   	public static void main(String[] args) {
   		// TODO Auto-generated method stub
   		// while循环实现输出一个4行5列的星星图
   		
   		int i = 1;
   		int j = 1;
   
   		while (i < 5) {
   			while (j < 6) {
   				System.out.print("*");
   				j++;
   			}
   			System.out.println();
   			i++;
   			// j 一定要初始化，不然内while循环只能执行一次
   			j = 1;
   		}
   		
   	}
   
   }
   ```

   

2. 输出一个正三角形

   ```java
   public class Demo15 {
   
   	public static void main(String[] args) {
   		// TODO Auto-generated method stub
   		// 输出一个由*构成的正角三角形
   		
   		for(int i=1; i<6; i++) {
   			for(int j=1; j<=i; j++) {
   				System.out.print("*");
   			}
   			
   			System.out.println();
   		}
   	}
   
   }
   ```

3. 输出九九乘法表

   控制台输出格式优化

   | '\x' | x表示任意，\是转义符号 |
   | ---- | ---------------------- |
   | '\t' | tab键的位置            |
   | '\r' | enter键                |
   | '\n' | 换行                   |

   ```java
   public class Demo16 {
   
   	public static void main(String[] args) {
   		// TODO Auto-generated method stub
   		// 输出九九乘法表
   		/*
   		 * 1x1=1
   		 * 1x2=2 2x2=4
   		 * 1x3=3 2x3=6  3x3=9
   		 * 1x4=4 2x4=8  3x4=12 4x4=16
   		 * 1x5=5 2x5=10 3x5=15 4x5=20 5x5=25
   		 * 1x6=6 2x6=12 3x6=18 4x6=24 5x6=30 6x6=36
   		 */
   		
   		for(int i=1; i<10; i++) {
   			for(int j=1; j<=i; j++) {
   				System.out.print(j + "x" + i + "=" + i*j + '\t');
   			}
   			System.out.println();
   		}
   	}
   
   }
   ```

   

#### 控制跳转标识：

用以标识循环体

```java
class Demo16 {
    public static void main(String[] args) {
        a: for(int 1=1; i<=10; i++) {
            //外层循环，标识为a
            b: for(int j=1; j<=11; j++) {
                //内层循环，标识为 b
                
                // 跳出循环，适用标识符来指定跳出那层循环体
                break a;
            }
        }
    }
}
```

控制调整语句练习：

在控制台各输出2，7，13次 「我爱Java编程」