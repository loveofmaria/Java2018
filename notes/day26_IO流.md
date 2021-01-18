# IO流



## 回顾

1.   如何遍历Map的key集合，value集合，key-value集合，使用泛型
2.  写出使用Iterator和增强for循环遍历List\<String\>的代码，使用泛型
3.  提供一个方法，用于遍历获取HashMap\<String, String\>中的所有value, 并存放在List中返回，考虑上集合中泛型的使用
4.  创建一个与a.txt文件同目录的另一个文件b.txt
5.  Map接口中常用的方法有那些



>   FIle类的使用
>
>   IO流原理及流的分类
>
>   节点流「或文件流」
>
>   缓冲流
>
>   转换流
>
>   标准输入、输出流
>
>   打印流
>
>   数据流
>
>   对象流
>
>   随机存取文件流
>
>   NIO.2中path、Paths、Files类的使用



## File类的使用

*   java.io.FIle 类：**文件和文件目录路径**的抽象标识形式，与平台无关
*   **FIle 能新建，删除，重命名文件和目录，但File不能访问文件内容本身，如果需要访问文件内容，则需要使用输入/输出流**
*   **想要在Java程序中标识一个真实存在的文件或目录，那么必须有一个FIle对象，但是Java程序中的一个FIle对象，可能没有一个真实存在的文件或目录**
*   File 对象可以作为参数传递给流的构造器

#### 常用构造器

*   public FIle(String pathName)

    以pathName为路径创建FIle对象，可以是**绝对或者相对路径**，如果是相对路径，则默认的当前路径在系统属性**user.dir**中存储

*   public File(String parent, String child)

    以parent为父路径，child为子路径创建File对象

*   public File(File parent, String child)

    根据一个父File对象和子文件路径创建File对象

#### 路径分隔符

*   windows和DOS使用"\\"来表示

*   UNIX和URL使用"/"来表示

*   Java支持跨平台，所以在使用分隔符时要慎用

*   java为了解决分隔符问题，File类提供了一个常量：public static final String separator, 根据不同的平台自动设置分隔符

    ```java
    String sep = File.separator;
    File file1 = new File("D:\\gua\\info.txt");
    File file2 = new File("D:" + sep + "gua" + sep + "info.txt");
    // UNIX
    File file3 = new File("/Home/gua/Documents/info.txt");
    ```

#### 常用方法

*   ***File 类的检查方法***

    public boolean isDirectory() 判断是否是文件目录

    public boolean isFile() 判断是否是文件

    public boolean exists() 判断是否存在

    public boolean canRead() 判断是否可读

    public boolean canWrite() 判断是否可写

    public boolean isHidden() 判断是否隐藏

*   ***File类的获取功能***

    **public String getAbsolutePath()** 获取绝对路径

    public String getPath() 获取路径

    public String getName() 获取名称

    public String getParent() 获取上层文件目录路径，无则返回null

    public long length() 获取文件长度「字节」，不能获取目录长度

    public long lastModified() 获取最后一次的修改时间，毫秒值

    public String[] list() 获取指定目录下的所有文件或者文件目录的名称数组

    public File[] listFiles() 获取指定目录下的所有文件或者文件目录的File数组

*   ***File类的重命名功能***

    public boolean renameTo(File dest) 把文件重命名为指定的文件路径

*   ***FIle的创建功能***

    public boolean createNewFile() 创建文件，若存在则不创建，返回false；否则返回true

    public boolean mkdir() 创建文件目录，如果此文件目录存在，就不创建；如果此文件目录的上层目录不存在，也不创建

    public boolean mkdirs() 创建文件目录，如果上层目录不存在，一并创建「**注意：如果创建文件或者文件目录没有写盘符，那么默认在项目的路径下**」

*   ***File类的删除功能***

    public boolean delete() 删除文件或者文件夹

    注意事项：

    1.  Java中的删除不放进回收站；
    2.  一个目录如果不为空，则无法删除

*   **File类的练习**

    ```java
    /*
    	1. 利用File构造器，new一个文件目录 file
    		* 在其中创建多个文件和目录
    		* 编写方法，实现删除file中指定的文件操作
    		
    	2. 判断指定的目录下是否有后缀名为 .jpg 的文件，如果有，就输出该文件名称
    	3. 遍历指定的目录所有文件名称，包括子文件目录中的文件
    		* 计算指定目录占用控件的大小
    		* 删除指定目录及其下的所有文件
    */
    ```

    

#### File 内存图示:

![File内存图示](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/File内存图示.png)



## IO流原理及流的分类

>    Google I/O  「Innovation in the Open」开放中的创新
>
>    Input/Output 「二进制的 1， 0」

### Java IO 原理

*   I/O 是Input/Output的缩写，IO技术用于处理设备之间的数据传输，比如文件读写，网络通信等等
*   Java中，对于数据的输入/输出操作以”流「steam」“的方式进行
*   java.io包下提供了各种”流“类和接口，用以获取不同种类的数据，并通过标准方法输入或输出数据



### 流的分类

*   按操作数据单位不同：字节流「8bit」，字符流[16bit」
*   按数据流的流向不同：输入流，输出流
*   按流的角色不同：节点流，处理流
    *   Java IO流涉及40多个类，实际上非常规则，都是从上图中抽象基类派生的；
       *   这四个类派生出来的子类名称都是以其父类名作为子类名后缀；

<img src="/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/流分类图.png" alt="流分类图" style="zoom:150%;" />



### IO 流体系

*[对于流的操作必须要手动关闭，JVM无法自动处理]*

*[常用-浅蓝色背景]*

![IO流体系图](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/IO流体系图.png)

***读写文件时要注意：非文本文件无法使用文件字符流「FileReader, FileWriter」来处理，而是需要使用文件字节流「FileInputStream, FileOutputStream 同理也不能处理超过一个字节存储范围的文本文件」处理。***

**比如：字节流可以处理文本"HelloWorld", 但是不能处理文本中: "中文"**



#### 数据流

***数据流的读，必须按照写的顺序，依次读取！***

*   为了持久化存储Java的**基本数据类型**「存储这些变量到文件」

*   ![数据流了解](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/数据流了解.png)

*   练习：将内存中的字符串、基本数据类型的变量写到文件中

    ```java
    // 写入
    public void test5()  {
            try {
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
    
                try {
                    dos.writeUTF("妖媚");
                    dos.flush();
                    dos.writeInt(20);
                    dos.flush();
                    dos.writeChar('男');
                    dos.flush();
                    dos.writeBoolean(true);
                    dos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        dos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
    
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    // 读取「必须按照写的顺序」
     public void test6(){
            try {
                DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
                try {
                    // 按照写的顺序依次读取
                    String name = dis.readUTF();
                    int age = dis.readInt();
                    char gender = dis.readChar();
                    boolean status = dis.readBoolean();
    
                    System.out.println("Name:" + name + "\n"
                    + "Aage: " + age + "\n"
                            + "Gender: " + gender + "\n"
                            + "Stuff: " + status
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        dis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    ```



#### 缓冲流

***「实际开发中，对于文件的读写都是使用缓冲流，因为比字节流文件读写效率更高」***

*   BufferedInputStream

    BufferedOutputStream

    BufferedReader

    BufferedWriter

```java
FileInputStream fis = null;
FileOutputStream fos = null;

BufferedInputStream bis = new BufferedInputStream(fis);
BufferedOutputStream bos = new BufferedOutputStream(fos);

// 关闭顺序
bos.close();
bis.close();
// 这里是自动关闭的,无需手动关闭
fos.close();
fis.close();
```

练习：

```java
// 1. 分别使用节点流：FileInputStream、FileOutputStream和缓冲流：BufferInputStream、BufferOutputStream实现文本文件/图片/视频文件的赋值，并比较数据复制的效率
// 节点流复制一个大小为 28.3MB的文件时间需要 10254 毫秒
// 							缓冲流需要 312 毫秒
// 2. 实现图片加密操作；提示：
        int b = 0;
        while((b = fis.read()) != -1){
            fos.write(b ^ 5);
        }
// 3. 获取文本上每个字符出现的次数，提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据写入文件
```



#### 转换流

***「根据后缀命名规则看：数据字符流」***

```java
// 一个utf8转换为GBK文件的示例
public void test2() {
    // 创建操作对象
        File file1 = new File("text1.txt");
        File file2 = new File("text_gbk.txt");
        FileOutputStream fos = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
			// isr 是以utf8读取文件流转换成字符流的对象
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            // osw 是以GBK编码字符流的对象
            osw = new OutputStreamWriter(fos, "GBK");
	// 以新的GBK编码写入
            int len;
            char[] buffer = new char[1024];
            while (true){
                try {
                    if ((len = isr.read(buffer)) == -1) break;
                    osw.write(buffer, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    // 关闭资源
        finally {
                if(osw != null){
                    try {
                        osw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(isr != null){
                    try {
                        isr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(fis != null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(fos != null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
```



*   提供了字节流和字符流之间的转换

*   Java API 提供了两个转换流

    InputStreanReader  --> 将InputStream 转换为Reader

    OutputStreamWriter --> 将Write转换为OutputStream

*   字节流中的数据都是字符时，转换成字符流操作效率更高

*   使用转换流处理文件乱码问题；实现编码和转码的功能

![转换流图示](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/转换流图示.png)

​	

#### 标准输入、输出流

![标准输入输出流](/home/huangzheng2011/Projects/JavaProjects/Java/Java2018/notes/images/标准输入输出流.png)

```java
// 练习：从键盘输入字符串，要求将读取到的整行字符串转换成大写输出。然后继续进行输入操作，直到输入'e'或者'exit'时，退出程序
// 不使用 Scanner, 而是使用标准流方式实现
// 通过转换流把标准输入转换成有readLine()方法的字符输入流
public static void main(String[] args) {

        BufferedReader br = null;
        try {
            // System.in 是一个标准的输入流，默认是键盘输入
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.print("输入： ");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                } else {
                    assert data != null;
                    System.out.println(data.toUpperCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
// 练习2:
// 创建一个程序：MyInput.java
// 其中包含从键盘输入的 int, double, float, boolean, short, byte, String 类型的值的方法
// 不能使用 Scanner 方式, 功能相当于Scanner
```



​	

​			





