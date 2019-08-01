package thread;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author grape
 * @date 2019-07-16
 */
public class Producer implements Runnable {

	private WaitNotify wn;
	private CyclicBarrier cb;
	private int good;


	public Producer(WaitNotify wm, CyclicBarrier cb,int good) {
		assert wm != null;
		assert cb != null;
		assert good > -1;
		this.wn = wm;
		this.cb = cb;
		this.good = good;
	}

	@Override
	public void run() {
		try {
			cb.await();

      		wn.productGood(good);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
