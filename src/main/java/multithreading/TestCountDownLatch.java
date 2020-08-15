package multithreading;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:注意:countDownLatch不可能重新初始化或者修改CountDownLatch对象内部计数器的值，
 * 一个线程调用countdown方法happen-before另外一个线程调用await方法
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-08-15
 * @Time: 3:28 下午
 */
public class TestCountDownLatch
{
    public static void main(String[] args) throws InterruptedException,IllegalMonitorStateException
    {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++)
        {
            new Thread(new Runnable()
            {
                @SneakyThrows
                @Override
                public void run()
                {
                    Thread.sleep(1000);
                    System.out.println("子线程执行成功");
                    countDownLatch.countDown();//让countDownLatch的数值减1
                    //System.out.println(countDownLatch.getCount());
                }
            }).start();
        }
        countDownLatch.await();//柱塞当前线程，一直到countDownLatch的数值减到0就
        System.out.println("主线程执行成功");
    }
}
