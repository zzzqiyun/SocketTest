package IOTest;

import java.io.File;

/**
 * Created on 2018/3/9.
 *
 * @author qiyun
 */
public class FileTest {
  public static void main(String args[])throws Exception{
    File file = new File("hello.txt");//ָ���ļ�Ŀ¼
    System.out.println("hello�ļ����Ƿ���ڣ�"+file.exists());
    file.createNewFile();//�����ļ�
    System.out.println("�ļ���name��"+file.getName());
    System.out.println(file.getName()+"�ļ����Ƿ���ڣ�"+file.exists());
    System.out.println(file.getName()+"�ļ��ľ���·����"+file.getAbsolutePath());
    System.out.println(file.getName()+"�ļ������·����"+file.getPath());
    System.out.println("�ļ��Ƿ�ɶ�"+file.canWrite());
    System.out.println("�ļ��Ƿ�����"+file.isHidden());
  }
}
