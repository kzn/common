package name.kazennikov;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {
	
	/**
	 * Creates slightly customized ThreadPoolExecutor, which will block the execute() method
	 * when it wouldn't be able to schedule a task, waiting for a space in the queue
	 * 
	 * @param corePoolSize core thread pool size
	 * @param maxPoolSize maximum thread pool size
	 * @param keepAliveTime keep alive time for unused threads
	 * @param units time units of keep alive time
	 * @param queueSize task queue size
	 * @return fresh thread pool
	 */
	public static ThreadPoolExecutor newBlockingThreadPoolExecutor(int corePoolSize, 
			int maxPoolSize, long keepAliveTime, TimeUnit units, int queueSize) {
		
		return newBlockingThreadPoolExecutor(corePoolSize, maxPoolSize, 
				keepAliveTime, units, new ArrayBlockingQueue<Runnable>(queueSize));
	}
	
	/**
	 * Creates slightly customized ThreadPoolExecutor, which will block the execute() method
	 * when it wouldn't be able to schedule a task, waiting for a space in the queue
	 * 
	 * @param corePoolSize core thread pool size
	 * @param maxPoolSize maximum thread pool size
	 * @param keepAliveTime keep alive time for unused threads
	 * @param units time units of keep alive time
	 * @param workQueue work queue object
	 * @return fresh thread pool
	 */
	public static ThreadPoolExecutor newBlockingThreadPoolExecutor(int corePoolSize, 
			int maxPoolSize, long keepAliveTime, TimeUnit units, BlockingQueue<Runnable> workQueue) {

		ThreadPoolExecutor execService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 
				keepAliveTime, units, workQueue);
		execService.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				try {
					executor.getQueue().put(r);
				} catch (InterruptedException e) {
					throw new RejectedExecutionException(e);
				}
			}
		});
		
		return execService;

	}

}
