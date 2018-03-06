package downUtil;


/**
 * Created on 2018/3/6.
 *
 * @author qiyun
 */
public class MultiThreadDown {

  public static void main(String[] args) throws Exception {
   final DownUtil downUtil = new DownUtil("https://ss0.baidu.com/"
            + "6ONWsjip0QIZ8tyhnq/it/u=1927822194,1885130936&fm=80&w=179&h=19&img.JPEG","1.JPEG",4);

    downUtil.downLoad();
    new Thread(() -> {
      while(downUtil.getCompleteRate() < 1)
      {
        System.out.println("已完成: "+ downUtil.getCompleteRate());
        try{//每隔0.1秒查询一次任务
          Thread.sleep(1000);
        }
        catch(Exception e){
          e.printStackTrace();
        }
      }
      System.out.println("已完成: "+ downUtil.getCompleteRate());
    }).start();
  }
}
