package socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created on 2018/3/9.
 *
 * @author qiyun
 */
public class ClientThread implements Runnable{
 private Socket socket;
 BufferedReader br = null;
 public ClientThread(Socket socket)throws IOException{
     this.socket = socket;
     br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
     MyServer.socketList.remove(socket);
   }
  public void run(){
    try{
      String content = null;
      while((content=br.readLine())!=null){
        System.out.println(content);
      }
    }catch (Exception e){
     e.printStackTrace();
    }
  }
}
