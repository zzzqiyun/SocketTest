package downUtil;
import java.net.URL;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
/**
 * Created on 2018/3/6.
 *
 * @author qiyun
 */
public class DownUtil {
  //��������·��
  private String path;
  //ָ�������ص��ļ��ı���λ��
  private String targetFile;
  //���������̵߳�����
  private int threadNum;
  //���������̵߳Ķ���
  private DownThread[] threads;
  //�����ļ����ܴ�С
  private int fileSize;

  public DownUtil(String path,String targetFile,int threadNum){
    this.path = path;
    this.targetFile = targetFile;
    this.threadNum = threadNum;
    threads = new DownThread[threadNum];
    this.targetFile = targetFile;
  }
  public void downLoad() throws Exception{
    URL url = new URL(path);
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    conn.setConnectTimeout(5 * 1000);
    //���� URL ����ķ����� GET POST HEAD OPTIONS PUT DELETE TRACE ���Ϸ���֮һ�ǺϷ��ģ�����ȡ����Э������ơ�
    conn.setRequestMethod("GET");
    //����һ���������ԡ�����Ѵ��ھ��иùؼ��ֵ����ԣ�������ֵ��д��ֵ��
    conn.setRequestProperty("Accpt",
            "image/gif,image/jpeg,image/pjpeg,image/pjpeg, "
                    + "application/x-shockwave-flash, application/xaml+xml, "
                    + "application/vnd.ms-xpsdocument, application/x-ms-xbap"
                    + "application/x-ms-application,application/vnd.ms-excel"
                    + "application/vnd.ms-powerpoint, application/msword,*/*");
    conn.setRequestProperty("Accept-Language", "zh_CN");
    conn.setRequestProperty("Charset", "UTF-8");
    conn.setRequestProperty("Connection", "Keep-Alive");

    //�õ��ļ���С
    fileSize = conn.getContentLength();
    conn.disconnect();
    int currentPartSize = fileSize / threadNum + 1;
    RandomAccessFile file = new RandomAccessFile(targetFile,"rw");
    //���ñ����ļ���С
    file.setLength(fileSize);
    file.close();
    for(int i = 0;i < threadNum;i++){
      //����ÿ���̵߳�����λ��
      int startPos = i * currentPartSize;
      //ÿ���߳�ʹ��һ��RandomAccessFile��������
      RandomAccessFile currentPart = new RandomAccessFile(targetFile,"rw");
      //��λ���̵߳�����λ��
      currentPart.seek(startPos);
      //���������߳�
      threads[i] = new DownThread(startPos, currentPartSize, currentPart);
      threads[i].start();
    }
  }
  public double getCompleteRate(){
    int sumSize = 0;
    for(int i = 0;i < threadNum;i++){
      sumSize += threads[i].length;
    }
    return sumSize * 1.0 / fileSize;
  }
  private class DownThread extends Thread{
    //��ǰ�̵߳�����λ��
    private int startPos;
    //���嵱ǰ�̸߳������ص��ļ���С
    private int currentPartSize;
    //��ǰ�߳���Ҫ���ص��ļ���,�����ʵ��֧�ֶ���������ļ��Ķ�ȡ��д�롣
    private RandomAccessFile currentPart;
    //������߳������ص��ֽ���
    public int length;
    private DownThread(int startPos,int currentPartSize,RandomAccessFile currentPart){
      this.startPos = startPos;
      this.currentPartSize = currentPartSize;
      this.currentPart = currentPart;
    }
    public void run(){
      try{
        URL url = new URL(path);
        //url.openConnection():����һ�� URLConnection ��������ʾ�� URL �����õ�Զ�̶�������ӡ�
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accpt", "image/gif,image/jpeg,image/pjpeg,image/pjpeg, "
                + "application/x-shockwave-flash, application/xaml+xml, "
                + "application/vnd.ms-xpsdocument, application/x-ms-xbap"
                + "application/x-ms-application,application/vnd.ms-excel"
                + "application/vnd.ms-powerpoint, application/msword,*/*");
        conn.setRequestProperty("Accept-Language", "zh_CN");
        conn.setRequestProperty("Charset", "UTF-8");
        InputStream inputStream = conn.getInputStream();
        //inputStream.skip(n);�����Ͷ����������������ݵ� n ���ֽ�
        inputStream.skip(this.startPos);
        byte[] buffer = new byte[1024];
        int hasRead = 0;
        //��ȡ��������д�뱾��
        while(length < currentPartSize && (hasRead = inputStream.read(buffer)) != -1){
          currentPart.write(buffer, 0, hasRead);
          length += hasRead;
        }
        currentPart.close();
        inputStream.close();
      }
      catch(Exception e){
        e.printStackTrace();
      }
    }
  }
}
