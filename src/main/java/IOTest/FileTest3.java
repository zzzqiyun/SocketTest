package IOTest;

import java.io.File;

/**
 * Created on 2018/3/9.
 *
 * @author qiyun
 */
public class FileTest3 {
  public static void main(String args[])throws Exception{
    File file = new File("D;/");
    System.out.println(file.getAbsolutePath()+"的所有文件或者文件夹的File");
    File[] files = file.listFiles();
    if(files!=null){
      for (File f:files) {
        System.out.println(f);
      }
    }else{
      System.out.println("没有文件对象");
    }
  }
}
