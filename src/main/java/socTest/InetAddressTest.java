package socTest;

import java.net.InetAddress;

/**
 * Created on 2018/3/5.
 *
 * @author qiyun
 */
public class InetAddressTest {
  public static void main(String[] args) throws Exception{
    //��������������ȡ��Ӧ��InetAddressʵ��
    InetAddress ip = InetAddress.getByName("www.baidu.com");
    System.out.println("�ٶ��Ƿ�ɴ�:"+ip.isReachable(2000));
    //��ȡ��InetAddressʵ����IP��
    // ����
    System.out.println("IP�ַ����ǣ�"+ip.getHostAddress());
    //����ԭʼIP��ַ����ȡ��Ӧ��InetAddressʵ��
    InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
    System.out.println("�����Ƿ�ɴ"+local.isReachable(200));
    //��ȡ��InetAddtessʵ����Ӧ��ȫ�޶�����
    System.out.println("ȫ�޶�����"+local.getCanonicalHostName());

  }
}
