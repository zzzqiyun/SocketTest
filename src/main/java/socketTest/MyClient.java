package socketTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created on 2018/3/9.
 *
 * @author qiyun
 */
public class MyClient{
  public static  void main(String args[])throws Exception {
    Socket socket = new Socket("127.0.0.1",8888);
    new Thread(new ClientThread(socket)).start();
    PrintStream ps = new PrintStream(socket.getOutputStream());
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while ((line=br.readLine())!=null){
      ps.println(line);
    }
  }
}
