package multithreading;

import lombok.SneakyThrows;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * Description:同步屏障CyclicBarrier
 *
 * 注意:countDownLatch和cyclicBarrier有什么区别?
 * countDownLatch只能使用一次，而CyclicBarrier方法可以使用reset()方法重置，所以CyclicBarrier方法可以能处理更为复杂的业务场景。
 * 我曾经在网上看到一个关于countDownLatch和cyclicBarrier的形象比喻，
 * 就是在百米赛跑的比赛中若使用 countDownLatch的话冲过终点线一个人就给评委发送一个人的成绩，
 * 10个人比赛发送10次，如果用CyclicBarrier，则只在最后一个人冲过终点线的时候发送所有人的数据，仅仅发送一次，这就是区别。
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-08-15
 * @Time: 3:39 下午
 */
public class TestCyclicBarrier
{
    public static void main(String[] args) throws InterruptedException, IllegalMonitorStateException, BrokenBarrierException
    {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++)
        {
            new Thread(new Runnable()
            {
                @SneakyThrows
                @Override
                public void run()
                {
                    Thread.sleep(3000);
                    System.out.println("子线程执行成功");
                    cyclicBarrier.await();//到达这里屏障
                }
            }).start();
        }
        cyclicBarrier.await();
        System.out.println("主线程执行成功");
    }
}
