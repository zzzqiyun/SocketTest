package socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created on 2018/3/9.
 *
 * @author qiyun
 */
public class ServerThread implements Runnable{
Socket s = null;
BufferedReader br = null;
public ServerThread(Socket s)throws Exception{
  this.s = s;
  br = new BufferedReader(new InputStreamReader(s.getInputStream()));
}
  public void run(){
  try {
    String content = null;
    while((content=readFromClient())!=null){
      for (Socket s:MyServer.socketList){
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println(content);
      }
    }
  }catch (Exception e){
    e.printStackTrace();
  }


  }
  public String readFromClient(){
    try{
      return br.readLine();
    }catch (Exception e){
      MyServer.socketList.remove(s);
    }
    return  null;
  }

}
