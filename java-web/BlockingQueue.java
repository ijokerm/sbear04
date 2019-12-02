package lesson7;

import java.util.Random;

public class BlockingQueue <E>{
    //循环式队列
    private Object[] elements; //泛型类型擦除
    //添加索引
    private int addIndex;
    //取出索引
    private int takeIndex;
    //队列大小
    private int size;
    //定义构造方法
    public BlockingQueue(int capacity){
        elements=new Object[capacity];

    }
    public synchronized  E poll(){
        E element=null;
        try {
            while(size==0)
                wait();
            element=(E)elements[takeIndex];
            takeIndex=(takeIndex+1)%elements.length;
            size--;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return element;
    }
    public synchronized void offer(E element){
        try {
            while(size==elements.length){
                wait();
            }
            elements[addIndex]=element;
            addIndex=(addIndex+1)%elements.length;
            size++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer>queue=new BlockingQueue<>(10);
        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                 for(int i=0;i<100;i++){
                    int num=new Random().nextInt(100)+1;
                     System.out.println(num);
                     queue.offer(num);
                 }
                }
            }).start();
        }
        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000;i++){
                        System.out.println(queue.poll());
                    }
                }
            }).start();
        }
    }
}
