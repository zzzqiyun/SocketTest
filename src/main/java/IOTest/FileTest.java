package IOTest;

import java.io.File;

/**
 * Created on 2018/3/9.
 *
 * @author qiyun
 */
public class FileTest {
  public static void main(String args[])throws Exception{
    File file = new File("hello.txt");//指定文件目录
    System.out.println("hello文件的是否存在："+file.exists());
    file.createNewFile();//创建文件
    System.out.println("文件的name："+file.getName());
    System.out.println(file.getName()+"文件的是否存在："+file.exists());
    System.out.println(file.getName()+"文件的绝对路径："+file.getAbsolutePath());
    System.out.println(file.getName()+"文件的相对路径："+file.getPath());
    System.out.println("文件是否可读"+file.canWrite());
    System.out.println("文件是否隐藏"+file.isHidden());
  }
}
