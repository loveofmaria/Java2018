#### 本日内容：

1. 数组概述和定义语法格式；
2. 数组的初始化-动态初始化；
3. Java中内存分配以及栈和堆的区别；
4. 数组内存图解「1个数组，多个数组，数组初始化」；
5. 数组操作的两个常见问题「越界，空指针」；
6. 二维数组概述和格式；
7. Java中的参数传递问题「图解」；



##### 数组的概述和语法格式

1. 数组是一个存储同类型数据的容器「集合」，既可以存储基本数据类型，也可以存储引用数据类型；

2. 数组定义格式：

   ```java
   // 数据类型[] 数组名 = new 数据类型[数组的长度];
   int[] arr = new int[5];
   ```

   

##### 数组初始化-动态初始化

1. 数组初始化：为数组开辟连续的内存空间，并为每个数组元素赋值；

   静态初始化

   ```java
   int[] arr;
   arr = new int[]{1, 22, 3, 10, -11};
   // 简化
   int[] arr1 = {1, 22, 3, 10, -11};
   ```

   

2. 动态初始化：

   ```java
   // 只指定长度，初始值由系统给出
   int[] arr = new int[5];
   // 元素为int的数组，系统默认值为0
   int[0] == 0;
   ```

3. 数组初始化不能动态和静态混合

   ```java
   // 错误示范
   int[] arr = new int[5]{1,2,3,4,5};
   
   // 正确示范
   int[] arr = new int[]{1,2,3,4,5};
   ```

   

##### 内存分配以及栈和堆

1. 单个一维数组内存图

   动态初始化默认值：
   byte、short、int、long类型的数组的初始值为0
   float、double类型的数组的初始值为0.0
   char类型的数组的初始值为'\u0000'，表现为空字符''，但要占位
   boolean类型的数组的初始值为false
   引用类型的数组的初始值为null

   ```java
   // 静态初始化
   String[] books = new String[]{"疯狂Java讲义","Thinking in Java","Java核心技术卷"};
   String[] names = new String[]{"张三","李四","王五","赵六"};
   
   // 动态初始化
   String[] strArr = new String[5];
   ```

   ![数组内存分配图1](/home/gux/Documents/Java2018/notes/images/数组内存分配图1.png)

2. 多维数组

   ```java
   public static void main(String[] args) {
       int[][] a;
       a = new int[4][];
       // 把a当成一维数组，遍历a数组的每个数组元素
       for(int i=0; i<a.length; i++){
             System.out.println(a[i]); // 输出都为null
       }
               
       a[0] = new int[2];
       a[0][1] = 2;
       for(int i=0; i<a[0].length; i++){
             System.out.println(a[0][i]); // 输出0和2
       }
   }
   ```

   ![数组内存分配图2](/home/gux/Documents/Java2018/notes/images/数组内存分配图2.png)



##### 数组操作的常见问题「越界和空指针」

1. 越界异常：java.lang.ArrayIndexOutOfBoundsException;

   原因：访问了不存在的索引

2. 空指针异常：java.lang.NullPointerException；

   原因：数组名已经不再指向堆内存的数组，而仍然适用该数组名去访问；

   ```java
   int[] arr = {1,2,3,4,5}
   // arr 不再指向 {1,2,3,4,5}
   arr = null;
   // 仍然使用 arr 去访问 {1,2,3,4,5}
   arr[0];
   ```

   

##### 数组遍历操作

1. arr.length 为数组的长度，数组的最大索引为 arr.length - 1

2. 遍历数组就是适用数组元素的索引去访问每一个元素

   ```java
   int[] arr = new int[] {11, 22, 0, 1, -20};
   // arr 的长度
   arr.length;
   // 遍历
   for(int i=0; i<=arr.length-1; i++) {
       System.out.println(arr[i]);
   }
   
   ```



##### 获取数组的最大「小」值

思路：用一个临时变量存储最大值，遍历数组内所有元素，如果比这个最大值大，那么就替换掉

```java
public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 获取数组的最大「最小值」
		// 思路：遍历所有元素，使用临时变量来存储比较后较大的值
		
		int[] arr = {2, 10, 33, -1, 0, 99, 34, 6};
		System.out.println("该数组最大值为: " + getMax(arr));
		
	}
	
	public static int getMax(int[] arr) {
		int max = 0;		
		for(int i=0; i<=arr.length-1; i++) {
			max = (max > arr[i]) ? max : arr[i]; 
		}		
		return max;
	}

}
```



##### 数组反转

思路: 

arr[0] <--> arr[ arr.length - 1 - 0 ] 交换

arr[1] <--> arr[ arr.length - 1 - 1 ] 交换

arr[2] <--> arr[ arr.length - 1 - 2 ] 交换

arr[3] <--> arr[ arr.length - 1 - 3 ] 交换

.....

arr[i] <--> arr[ arr.length - 1 - i ] 交换

实际操作的次数 = arr.length / 2

```java
// 只写出方法的代码
public static void reverseArr(int[] arr) {
    int tmp;
    for(int i=0; i<arr.length/2; i++) {
        tmp = arr[i];
        arr[i] = arr[arr.length-1-i];
        arr[arr.length-1-i] = tmp;
    }
}
```



##### 数组查找「根据输入的索引值」

方法返回值类型更具数组元素类型指定

例子：根据输入的整数，打印星期几

```java
import java.util.Scanner;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] weekStrings = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		Scanner sc = new Scanner(System.in);
		System.out.print("输入你要指定的星期数: ");
		int num = sc.nextInt() % 7;
		
		System.out.println(getWeek(weekStrings, num));
	}

	public static String getWeek(String[] arr, int number) {
		return arr[number];
	}
}
```



##### 数组元素查找「查找指定元素第一次在数组中出现的位置-索引」

思路：根据给出的元素，去数组遍历相等值，如果找到，则打印出i的值，

```java
public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 根据给出的元素去查找在数组中第一次出现的位置-索引值
		/*
		 * 通常比较两个字符串是否相同的表达式是“==” ，
		 * 但在 Java 中不能这么写。在 Java 中，
		 * 如果要比较 a 字符串是否等于 b 字符串，需要这么写： 
		 * if(a.equals(b)){ } 返回 true 或 false
		 */
		String[] arr = {"黄毛瓜", "绿豆芽", "大白菜", "马骡子", "茄子", "毛十八"};
		Scanner sc = new Scanner(System.in);		
		
		System.out.print("输入你要查找的同学名字: ");
		String str = sc.nextLine();
		sc.close();		
		
		System.out.println(str == arr[0]);
		
		int result = getIndex(arr, str);
		if(result != -1) {
			System.out.println("你要找的同学排在第 " + (result + 1) + "位");
		} else {
			System.out.println("没有找到该同学!");
		}
		
	}

	public static int getIndex(String[] arr, String str) {		
		for(int i=0; i<arr.length; i++) {
			if(str.equals(arr[i])) {
				return i;
			}
		}		
		return -1;
	} 
}
```

