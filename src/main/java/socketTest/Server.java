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
    //����һ��ServerSocket�����ڼ����ͻ���Socket����������
    ServerSocket ss = new ServerSocket(9999);
    //����ѭ�����Ͻ������Կͻ��˵�����
    while(true){
    //ÿ�����յ��ͻ��˵�����ʱ��������Ҳ��Ӧ����һ��Socket
    Socket s = ss.accept();
    //��Socket��Ӧ���������װ��PrintStream
    PrintStream ps = new PrintStream(s.getOutputStream());
    //String line = "hello";
    //OutputStream outputSteam = s.getOutputStream();
    //outputSteam.write((line + "\n").getBytes());
   // ps.println(line);
    //������ͨIO����
    ps.println("��ã��Ѿ����յ������Է���������Ϣ");
    //�ر���������ر�Socket
    ps.close();
    s.close();
     }
  }
}
