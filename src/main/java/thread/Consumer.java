package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author grape
 * @date 2019-07-16
 */
public class Consumer implements Runnable {

	private WaitNotify wn;

	private CyclicBarrier cb;

	public Consumer(WaitNotify wn,CyclicBarrier cb){
		assert wn != null;
		assert cb != null;
		this.wn = wn;
		this.cb = cb;
	}

	@Override
	public void run() {
		try {
			cb.await();
			wn.consumeGood();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
