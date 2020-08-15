package multithreading;

import lombok.SneakyThrows;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Description:等待所有的子线程执行完毕，主线程在执行，thread.join()把指定的线程加入到当前线程，
 * 可以将两个交替执行的线程合并为顺序执行的线程。比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-08-15
 * @Time: 3:17 下午
 */
public class TestJoin
{
    public static void main(String[] args) throws InterruptedException
    {
        Vector<Thread> threadVector = new Vector<Thread>();
        for (int i = 0; i < 5; i++)
        {
            Thread chard = new Thread(new Runnable()
            {
                @SneakyThrows
                @Override
                public void run()
                {
                    Thread.sleep(1000);
                    System.out.println("子线程执行成功");
                }
            });
            threadVector.add(chard);
            chard.start();
        }
        for (Thread thread : threadVector)
        {
            thread.join();
        }
        System.out.println("主线程执行成功");
    }
}
