import java.util.concurrent.*;
import java.util.*;

public class MyThreadPool{
	ThreadFactory threadFactory;
	HashSet<Worker> threadPool;
	BlockingQueue<Runnable> queue;
	int poolSize;
	public MyThreadPool(int size) {
		this.poolSize=size;
		threadPool = new HashSet<>(this.poolSize);
		queue = new ArrayBlockingQueue<>(this.poolSize);
		threadFactory = new MyThreadFactory();
		Thread t = new Thread(new RunWorker());
		t.start();
	}

	
	void submit(Runnable task){
		queue.add(task);
	}
	class RunWorker implements Runnable{

		@Override
		public void run() {
			while(true){
				while(!queue.isEmpty()){
					if(threadPool.size()==poolSize){
						for(Worker localWorker:threadPool){
							if(!localWorker.busy){
								localWorker.setTask(queue.poll());
								localWorker.lockObject.notifyAll();
								break;
							}
						}
					}
					else{
						threadPool.add(new Worker(queue.poll()));
					}
				}
			}

		}
		
	}
	
	class Worker implements Runnable{
		Thread t;
		Object lockObject = new Object();
		volatile Runnable task;
		volatile boolean busy;
		Worker(Runnable task){
			System.out.println("Worker");
			this.t = threadFactory.newThread(this);
			this.task =task;
			t.start();
		}
		@Override
		public void run() {
			while(true){
				busy=true;
				task.run();
				busy=false;
				try {
					synchronized(lockObject){
					wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public void setTask(Runnable newTask){
			this.task=newTask;
		}
		
	}
	class MyThreadFactory implements ThreadFactory{

		@Override
		public Thread newThread(Runnable r) {
			// TODO Auto-generated method stub
			return new Thread(r);
		}
		
	}
}
