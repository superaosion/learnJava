package main.java;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接。。。。。");
            Socket accept = serverSocket.accept();
            System.out.println("有客户端连接了。。。。。");
            handler(accept);
        }
    }

    private static void handler(Socket accept) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read。。");
        int read = accept.getInputStream().read(bytes);
        System.out.println("read完毕。。");
        if (read != -1) {
            System.out.println("接受到客户端的数据："+ new String(bytes, 0, read));
        }
    }
}
