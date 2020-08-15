package multithreading;

/**
 * Created with IntelliJ IDEA.
 * Description:让主线程睡眠一段时间，当然这个睡眠时间是主观的时间，是我们自己定的，
 * 这个方法不推荐，但是在这里还是写一下，毕竟是解决方法
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-08-15
 * @Time: 3:12 下午
 */
public class TestSleep
{
    public static void main(String[] args) throws InterruptedException
    {
        for (int i = 0; i < 5; i++)
        {
            new Thread(new Runnable()
            {
                @lombok.SneakyThrows
                @Override
                public void run()
                {
                    Thread.sleep(1000);
                    System.out.println("子线程执行结束");
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println("主线程执行结束");
    }
}
