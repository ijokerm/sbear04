package lesson7;

public class MyThreadPool {
    //利用阻塞式队列保证线程安全
    private BlockingQueue<Runnable>queue=new BlockingQueue<>(10);

    private MyWorker[] wokers;
    public MyThreadPool(int capacity,int size){
        wokers=new MyWorker[capacity];
        queue=new BlockingQueue<>(size);
        for(int i=0;i<capacity;i++){
            wokers[i]=new MyWorker();
            wokers[i].start();
        }
    }
    public void execute(Runnable task){
        queue.offer(task);
    }
}
class MyWorker extends Thread{
    @Override
    public void run() {
        super.run();
    }
}
