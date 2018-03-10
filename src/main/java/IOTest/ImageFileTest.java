package IOTest;

import java.io.File;

/**
 * Created on 2018/3/9.
 *
 * @author qiyun
 */
public class ImageFileTest {
  public static void main(String args[]){
    File file = new File("D:/");
    File [] f = file.listFiles();
    if(f!=null){
      for (File fi:f) {
        if (fi.isDirectory()){
          String[] s = fi.list();
          if(s!=null){
            for (String str:s) {
              if (str.endsWith(".jpg")){
                System.out.println(str);
              }
            }
          }
        }
      }
    }else{
      System.out.println("没有文件对象");
    }

  }
}
