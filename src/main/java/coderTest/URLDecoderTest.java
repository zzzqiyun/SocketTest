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
    //½«application/x-www-from-urlencoded×Ö·û´®×ª»»³ÉÆÕÍ¨×Ö·û´®
    String keyboard = URLDecoder.decode("%E7%96%AF%E7%8B%82","utf-8");
    System.out.println("±àÂëºóµÄapplication/x-www-from-urlencoded×Ö·û´®:"+keyboard);
    //½«ÆÕÍ¨×Ö·û´®±àÂë³Éapplication/x-www-from-urlencoded×Ö·û´®
    String urlStr = URLEncoder.encode("ÄãºÃ","GBK");
    System.out.println("±àÂë³Éapplication/x-www-from-urlencodedµÄ×Ö·û´®:"+urlStr);
  }
}
