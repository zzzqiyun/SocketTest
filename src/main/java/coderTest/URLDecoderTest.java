package coderTest;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created on 2018/3/5.
 *
 * @author qiyun
 */
public class URLDecoderTest{
  public static void main(String args[])throws Exception{
    //��application/x-www-from-urlencoded�ַ���ת������ͨ�ַ���
    String keyboard = URLDecoder.decode("%E7%96%AF%E7%8B%82","utf-8");
    System.out.println("������application/x-www-from-urlencoded�ַ���:"+keyboard);
    //����ͨ�ַ��������application/x-www-from-urlencoded�ַ���
    String urlStr = URLEncoder.encode("���","GBK");
    System.out.println("�����application/x-www-from-urlencoded���ַ���:"+urlStr);
  }
}
