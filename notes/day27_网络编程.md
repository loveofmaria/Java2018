# Java的网络编程



## 网络编程概述

* Java 提供的网络类库，可以实现网络连接，联网的底层细节已经封装在Java的本机安装系统里，由JVM进行控制。并且Java实现了一个跨平台的网络库，程序员面对的是一个统一的网络编程环境。
* 网络编程中有两个主要的问题：
  1. 如何准确的定位网络上一台或者多台主机；定位主机上的特定应用;
  2. 找到主机后如何进行可靠高效的数据传输；
* 网络通信要素：
  1. ip和端口号
  2. 网络通信协议

* 由于网络通信协议比较复杂，所以就用抽象的分层思想来划分，如下图：

  ***OSI模型实际认同较少，事实上的标准是TCP/IP模型***

  ![网络协议分层图示](E:\OnGitHubProjects\JavaProjects\Java2018\notes\images\day27网络编程\网络协议分层图示.PNG)

* Java中通过一个类：***InetAddress*** 来抽象的表示IP地址

  ```java
  // 创建一个通信的实例，相当于文件对象的 File file = new File("text.txt");
  InetAddress inet = InetAddress.getByName("192.168.1.100");
  InetAddress inet1 = InetAddress.getByName("www.baidu.com");
  ```

  

  1. 本地回环地址：127.0.0.1； 主机名：localhost
  2. IP地址IPV大概42个，现已用尽；IPV6：128位【16字节】
  3. IP分为公网地址【万维网】和私有地址【局域网】
     * 私有地址以 192.168. 开头 【192.168.0.0 - 192.168.255.255】

* 端口号：

  ***端口号和IP地址组合得出一个网络套接字：Socket***

  1. 规定为16位整数：0 - 65535
  2. 端口分类：
     * 公认端口：0 - 1023，被预先定义的服务通信占用【比如：HTTP-80, FTP-21, Telent-23】
     * 注册端口：1024 - 49151，分配给用户进程或者应用程序【Tomcat-8080，MySql-3306，Oracle-1521】
     * 动态/私有端口：49152-65535



## 网络通信协议【TCP/IP UDP】

* 传输层协议中有两个非常重要的协议：

  TCP 传输控制协议【Transmission Control Protocol】

  UDP 用户数据报协议【User Datagram Protocol】

* TCP/IP以其两个主要协议：传输控制协议TCP和网络互联协议IP而得名，实际上是一组协议，包括多个具有不同功能且互为关联的协议

* IP【internet protocol】协议是网络层的主要协议，支持网间互连的数据通信

* TCP/IP协议模型从更实用的角度出发，形成了高效的四层体系结构，即物理链路层，ip层，传输层和应用层

* TCP/IP和UDP对比：

![TCP和UDP网络协议对比](E:\OnGitHubProjects\JavaProjects\Java2018\notes\images\day27网络编程\TCP和UDP网络协议对比.PNG)

一个soket同通信的基本流程：

```java
// 客户端
// 1.创建Socket对象
Socket socket = new Socket(InetAddress.getByName("服务器地址"), 端口号);
// 2.创建一个输出流，用于输出数据
OutputStream os = new socket.getOutputStream();
// 3. 发送【写出】数据
os.write("数据".getBytes());
// 4. 关闭资源
socket.close();
os.close();

// 服务端
// 1. 创建ServerSocket对象
ServerSocket ss = new ServerSocket(8999);
// 2. 调用accept表示开始接受来自客户端的socket
socket = ss.accept();
// 3. 获取一个输出流来显示打印数据
InputStream is = socket.getInputStream();
// 4. 读取流中的数据
// 关于中文数据的的获取应该使用 ByteArrayoutputStream 对象
ByteArrayoutputStream baos = new ByteArrayoutputStream();
byte[] buffer = new byte[字节大小];
int len;
while((len=is.read(buffer)) !=-1) {
    baos.write(buffer, 0, len);
}
// 4. 关闭资源
socket.close();
os.close();
is.close();
```

