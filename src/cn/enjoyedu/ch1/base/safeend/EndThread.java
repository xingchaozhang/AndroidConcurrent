package cn.enjoyedu.ch1.base.safeend;

/**
 *类说明：如何安全中断线程
 */
public class EndThread {
	
	private static class UseThread extends Thread{

		public UseThread(String name) {
			super(name);
		}
//		private boolean cancel;
//		public void setCancel(boolean cancel) {
//			this.cancel = cancel;
//		}

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+" interrrupt flag ="+isInterrupted());
//			while (cancel) {
//				Thread.sleep(1000);
//			}
			while(!isInterrupted()){
				//while(!Thread.interrupted()){
				//while(true){
				System.out.println(threadName+" is running");
				System.out.println(threadName+"inner interrrupt flag ="
						+isInterrupted());
			}
			System.out.println(threadName+" interrrupt flag ="+isInterrupted());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread endThread = new UseThread("endThread");
		endThread.start();
		Thread.sleep(20);
		// 中断线程，其实设置线程的标识位true
		endThread.interrupt();
//		((UseThread) endThread).setCancel(true);
	}

}
