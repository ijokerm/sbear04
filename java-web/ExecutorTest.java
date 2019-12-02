package lesson7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
   //常用的四种线程池
    private static final ExecutorService EXE= Executors.newSingleThreadExecutor();
    private static final ExecutorService EXE2=Executors.newFixedThreadPool(5);
  //  private static final ExecutorService EXE3=Executors.newCachedThreadPool();
  //  private static final ExecutorService EXE4=Executors.newScheduledThreadPool(5);
  public static void main(String[] args) {
      for(int i=0;i<100;i++){
          final int j=i;
          EXE2.submit(new Runnable() {
              @Override
              public void run() {
                  System.out.println(j);
              }
          });

      }
      EXE2.shutdown();
  }

}
