package cn.enjoyedu.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 *
 *类说明：如何新建线程
 */
public class NewThread {
	/*扩展自Thread类*/
	private static class UseThread extends Thread{
		@Override
		public void run() {
			super.run();
			//do my work
			System.out.println("I am extended Thread.");
		}
	}
	
	/*实现Runnable接口*/
	private static class UseRun implements Runnable{

		@Override
		public void run() {
			System.out.println("I am implements Runnable");
		}
		
	}
	
	/*实现Callable接口，允许有返回值，不能算是*/
	private static class UseCall implements Callable<String>{

		@Override
		public String call() throws Exception {
			System.out.println("I am implements Callable");
			return "CallResult";
		}
		
	}	
	
	public static void main(String[] args) 
			throws InterruptedException, ExecutionException {
		
		UseRun useRun = new UseRun();
		new Thread(useRun).start();
		Thread t = new Thread(useRun);
		t.interrupt();
		
		UseCall useCall = new UseCall();
		FutureTask<String> futureTask = new FutureTask<>(useCall);
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
	}
}
