package cn.enjoyedu.ch1.base;

import java.util.concurrent.ExecutionException;

/**
 *更多课程咨询 安生老师 QQ：669100976  VIP课程咨询 依娜老师  QQ：2470523467
 *
 *类说明：守护线程的使用
 */
public class DaemonThread {
	private static class UseThread extends Thread{
		@Override
		public void run() {
			try {
				while (!isInterrupted()) {
					System.out.println(Thread.currentThread().getName() 
							+ " I am extends Thread.");
				}
				System.out.println(Thread.currentThread().getName() 
						+ " interrupt flag is " + isInterrupted());
			} finally {
				// 守护线程中finally不一定起作用
				System.out.println(" .............finally");
			}
		}
	}
	
	public static void main(String[] args) 
			throws InterruptedException, ExecutionException {
		UseThread useThread = new UseThread();
		//useThread.setDaemon(true);
		useThread.start();
		Thread.sleep(5);
		useThread.interrupt();
	}
}
