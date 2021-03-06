package socketTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created on 2018/3/7.
 *
 * @author qiyun
 */
public class Client {
  public static void main(String args[])throws Exception{
    Socket socket = new Socket("127.0.0.1",9999);
    socket.setSoTimeout(10000);
    System.out.println("与服务器端是否连接成功："+socket.isConnected());
    //将socket对应的输入流包装成bufferedReader
    InputStream is = socket.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    //BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    //进行普通的IO操作
    String readLine = br.readLine();
    System.out.println("来自服务器端的数据："+readLine);
    is.close();
    br.close();
    socket.close();
  }
}
