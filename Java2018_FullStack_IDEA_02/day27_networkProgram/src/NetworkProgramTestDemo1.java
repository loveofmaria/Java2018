import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.net.InetAddress.getByName;
import static java.net.InetAddress.getLocalHost;

public class NetworkProgramTestDemo1 {
    @Test
    public void test() {
        try {
            InetAddress inetAddress = getByName("www.baidu.com");
            InetAddress inetAddressLocalhost = getLocalHost();
            System.out.println(inetAddress);
            System.out.println(inetAddressLocalhost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClient() {
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket(InetAddress.getByName("localhost"), 8899);
            os = socket.getOutputStream();
            os.write("客户端数据发送: 数据。。。。".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testServer() {
        ServerSocket server = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            server = new ServerSocket(8899);
            socket = server.accept();
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            int len;
            byte[] bufferSize = new byte[5];
            while((len=inputStream.read(bufferSize)) != -1){
                byteArrayOutputStream.write(bufferSize, 0, len);
            }
            String client;
            client = socket.getInetAddress().toString();
            client =client.split("/")[1];
            System.out.println("来自 " + client + " " + byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream!=null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (server!=null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
