package socketTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created on 2018/3/7.
 *
 * @author qiyun
 */
public class Client {
  public static void main(String args[])throws Exception{
    Socket socket = new Socket("127.0.0.1",33000);
    //��socket��Ӧ����������װ��bufferedReader
    InputStream is = socket.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    //BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    //������ͨ��IO����
    String readLine = br.readLine();
    System.out.println("���Է������˵����ݣ�"+readLine);
    is.close();
    br.close();
    socket.close();
  }
}
