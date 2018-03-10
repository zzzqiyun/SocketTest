package socketTest;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created on 2018/3/9.
 *
 * @author qiyun
 */
public class MyServer {
 public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
 public static void main(String args[])throws Exception{
   ServerSocket ss = new ServerSocket(8888);
   while(true){
     Socket s = ss.accept();
     socketList.add(s);
     ServerThread st = new ServerThread(s);
     Thread thread = new Thread(st);
     thread.start();
     OutputStream os = s.getOutputStream();
     String hello ="欢迎大家来到聊天室！";
     os.write((hello+"\n").getBytes());
   }
 }
}

