package companies.DataXu.ResourcePool;

import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.apache.log4j.Logger;

import org.junit.Test;
import dataXu.ResourcePool;
import dataXu.PoolNotOpenException;
import dataXu.TimeOutException;

public class TestResourcePool{
	
	private static Logger log = Logger.getLogger(TestResourcePool.class);
	ResourcePool<Integer> pool = new ResourcePool<Integer>();

	/* This test case creates two threads and calls acquires on both of them.
	 * It asserts that both the threads do not acquire the same resource*/
	@Test
	public void testAcquire() throws InterruptedException{
		pool.open();
		pool.add(new Integer(30));
		pool.add(new Integer(40));
		
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		
		log.debug(thread1.returnAcquiredRes().intValue());
		log.debug(thread2.returnAcquiredRes().intValue());
		Assert.assertNotSame(thread1.returnAcquiredRes(),thread2.returnAcquiredRes());
	}
	
	@Test
	/* This test case ensures that a thread cannot acqurie resource if the pool
	 * is not open and that it throws PoolNotOpenException.*/
	public void testOpenPool() throws InterruptedException{
		
		Thread1 thread1 = new Thread1();
		
		Thread t1 = new Thread(thread1);
		t1.start();
		t1.join();
		
		Assert.assertEquals(thread1.returnPoolNotOpenException(), true);
	}
	
	@Test
	/*This test checks for timed wait in acquire resource method.*/
	public void testResourceEmpty() throws InterruptedException{
		pool.open();
		Thread3 thread3 = new Thread3();
		Thread t1 = new Thread(thread3);
		t1.start();
		t1.join();

		Assert.assertEquals(thread3.returnTimeOutException(), true);

	}

	@Test
	public void testResourceAddAndAcquire() throws InterruptedException{
		pool.open();
		
		Thread1 thread1 = new Thread1();
		Thread4 thread4 = new Thread4();
		
		Thread t1 = new Thread(thread1);
		Thread t4 = new Thread(thread4);
		t1.start();

		Assert.assertNull(thread1.returnAcquiredRes());

		t4.start();
		
		Thread.sleep(10000); 
		//This sleep is necessary here so that 
		//Thread1 gets chance to aquire the resource before the condition is tested.

		Assert.assertNotNull(thread1.returnAcquiredRes());

		t1.join();
		t4.join();
	}

	@Test
	public void testRemove() throws Exception{
		pool.open();
		pool.add(new Integer(30));
		
		Thread5 thread5 = new Thread5();
		
		Thread t5 = new Thread(thread5);
		t5.start();
		
		Integer res = thread5.returnAcquiredRes();
		
		boolean isRemoved = pool.removeNow(res);
		
		t5.join();

		Assert.assertEquals(isRemoved, true);
	}
	
	private class Thread1 extends ThreadTest{
		
		@Override
		public void run() {
			try{
				resource = pool.acquire();
			}catch(PoolNotOpenException ex){
				log.debug("Pool Not Open Exception!");
				poolNotOpenException = true;
			}catch(TimeOutException ex){
				log.debug("Timeout occurred");
				timeoutException = true;
			}catch(Exception ex){
				
			}
			
		}
		
			}

	private class Thread2 extends ThreadTest{
		
		@Override
		public void run() {

			try{
				resource = pool.acquire();
			}catch(PoolNotOpenException ex){
				log.debug("Pool Not Open Exception!");
				poolNotOpenException = true;
			}catch(Exception ex){
				
			}
			
		}
		
	}

	private class Thread3 extends ThreadTest{

		@Override
		public void run() {
			try{
				resource = pool.acquire(5, TimeUnit.SECONDS);
			}catch(PoolNotOpenException ex){
				log.debug("Pool Not Open Exception!");
				poolNotOpenException = true;
			}catch(TimeOutException ex){
				log.debug("Timeout occurred");
				timeoutException = true;
			}catch(Exception ex){
				log.debug("Reached here3");
				ex.printStackTrace();
			}
			
		}
		
	}

	private class Thread4 extends ThreadTest{
		public void run(){
			pool.add(new Integer(20));
			pool.add(new Integer(50));
		}
	}

	private class Thread5 extends ThreadTest{
		
		public void run(){
			try{
				resource = pool.acquire();
				Thread.sleep(10000);
			}catch(PoolNotOpenException ex){
				log.debug("Pool Not Open Exception!");
				poolNotOpenException = true;
			}catch(TimeOutException ex){
				log.debug("Timeout occurred");
				timeoutException = true;
			}catch(Exception ex){
				log.debug("Reached here3");
				ex.printStackTrace();
			}
		}
	}
}
