package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 *  经典的生产者消费者模式简易实现
 * @author grape
 * @date 2019-07-16
 */
public class WaitNotify {

	private List<Integer> goods = new ArrayList<>();

	private final static Integer MAX_SIZE = 5;

	public synchronized void  productGood(Integer good) throws InterruptedException {
		while(goods.size() >= MAX_SIZE){
			System.out.println(Thread.currentThread()+" 生产商品 库存满了");
			wait();
		}
		goods.add(good);
		System.out.println(Thread.currentThread()+" 生产商品："+ good + " ,商品列表：" + goods);
		notify();
	}

	public synchronized void consumeGood() throws InterruptedException {
		while(goods.size() == 0 ){
			System.out.println(Thread.currentThread()+" 消费商品 库存不足");
			wait();
		}
		System.out.println(Thread.currentThread()+" 商品列表:"+ goods +" 消费商品:" + goods.remove(0));
		notify();
	}

	public static void main(String[] args) {
		WaitNotify wn = new WaitNotify();

		int size = 5;

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2*size,2*size,10, TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));

		CyclicBarrier cb = new CyclicBarrier(2*size);


		for(int i = 0;i < size;i++){
			threadPool.execute(new Consumer(wn,cb));
			threadPool.execute(new Producer(wn,cb,i));
		}

		threadPool.shutdown();
	}
}


