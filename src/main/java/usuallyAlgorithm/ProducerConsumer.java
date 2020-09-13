package usuallyAlgorithm;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.lang.Runnable;
import java.util.concurrent.*;

/**
 * @author <a href="jinyu52370@163.com">JJJ</a>
 * @date 2020/9/11 15:45
 *
 * 生产者消费者模型
 */
public class ProducerConsumer {
    private static int maxSize = 5;
    private static int currSize = 0;

    static class Producer implements Runnable {
        Producer(String name) {
            Thread.currentThread().setName(name);
        }

        @Override
        public void run() {
            //自旋锁
            while (true) {
                synchronized (ProducerConsumer.class) {
                    //仓库满时
                    while (currSize == maxSize) {
                        try {
                            System.out.println("仓库已满，停止生产");
                            ProducerConsumer.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //仓库未满时
                    System.out.println("生产者" + Thread.currentThread().getName() + "生产：" + ++currSize);
                    ProducerConsumer.class.notifyAll();
                    //休眠1s
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //休眠1s
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        Consumer(String name) {
            Thread.currentThread().setName(name);
        }

        @Override
        public void run() {
            //自旋锁
            while (true) {
                synchronized (ProducerConsumer.class) {
                    //仓库为空时
                    while (currSize == 0) {
                        try {
                            System.out.println("仓库为空，停止消费");
                            ProducerConsumer.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //仓库不为空时
                    System.out.println("消费者" + Thread.currentThread().getName() + "消费：" + --currSize);
                    ProducerConsumer.class.notifyAll();
                    //休眠1s
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //休眠2s
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 30L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadFactoryBuilder().setNameFormat("threadPool-%d").build());

        threadPool.execute(new Producer("p1"));
        threadPool.execute(new Producer("p2"));
        threadPool.execute(new Producer("p3"));
        threadPool.execute(new Producer("p4"));
        threadPool.execute(new Producer("p5"));

        threadPool.execute(new Consumer("c1"));
        threadPool.execute(new Consumer("c2"));
        threadPool.execute(new Consumer("c3"));
        threadPool.execute(new Consumer("c4"));
        threadPool.execute(new Consumer("c5"));
    }
}
