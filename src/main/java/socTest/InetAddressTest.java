package socTest;

import java.net.InetAddress;

/**
 * Created on 2018/3/5.
 *
 * @author qiyun
 */
public class InetAddressTest {
  public static void main(String[] args) throws Exception{
    //根据主机名来获取对应的InetAddress实例
    InetAddress ip = InetAddress.getByName("www.baidu.com");
    System.out.println("百度是否可达:"+ip.isReachable(2000));
    //获取改InetAddress实例的IP字
    // 符串
    System.out.println("IP字符串是："+ip.getHostAddress());
    //根据原始IP地址来获取对应的InetAddress实例
    InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
    System.out.println("本机是否可达："+local.isReachable(200));
    //获取改InetAddtess实例对应的全限定域名
    System.out.println("全限定域名"+local.getCanonicalHostName());

  }
}
