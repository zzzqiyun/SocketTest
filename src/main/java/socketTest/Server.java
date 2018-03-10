package socketTest;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created on 2018/3/7.
 *
 * @author qiyun;
 */
public class Server {
  public static void main(String args[]) throws Exception {
    //创建一个ServerSocket，用于监听客户端Socket的连接请求
    ServerSocket ss = new ServerSocket(9999);
    //采用循环不断接收来自客户端的请求
    while(true){
    //每当接收到客户端的请求时，服务器也对应产生一个Socket
    Socket s = ss.accept();
    //将Socket对应的输出流包装成PrintStream
    PrintStream ps = new PrintStream(s.getOutputStream());
    //String line = "hello";
    //OutputStream outputSteam = s.getOutputStream();
    //outputSteam.write((line + "\n").getBytes());
   // ps.println(line);
    //进行普通IO操作
    ps.println("你好，已经接收到了来自服务器的消息");
    //关闭输出流，关闭Socket
    ps.close();
    s.close();
     }
  }
}
