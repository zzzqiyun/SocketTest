package IOTest;

import java.io.File;

/**
 * Created on 2018/3/9.
 *
 * @author qiyun
 */
public class FileTest2 {
  public static void main(String args[]){
    File file = new File("D:/");
    String[] str = file.list();
    System.out.println(file.getAbsolutePath()+"下的所有文件或者文件夹：");
    for (String s:str) {
      System.out.println(s);
    }
  }
}
