package socketTest;

import sun.font.TrueTypeFont;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created on 2018/3/7.
 *
 * @author qiyun;
 */
public class Server {
  public static void main(String args[])throws Exception{
    //����һ��ServerSocket�����ڼ����ͻ���Socket����������
    ServerSocket ss = new ServerSocket(30000);
    //����ѭ�����Ͻ������Կͻ��˵�����
    while(true){
      //ÿ�����յ��ͻ��˵�����ʱ��������Ҳ��Ӧ����һ��Socket
      Socket s = ss.accept();
      //��Socket��Ӧ���������װ��PrintStream
      PrintStream ps = new PrintStream(s.getOutputStream());
      //������ͨIO����
      System.out.println("��ã��Ѿ����յ������Է���������Ϣ");
      //�ر���������ر�Socke
      ps.close();
      s.close();
    }
  }
}
