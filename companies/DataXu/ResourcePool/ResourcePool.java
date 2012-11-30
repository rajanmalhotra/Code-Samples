package companies.DataXu.ResourcePool;

import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.LinkedList;

public class ResourcePool<R> {

	/*HashMap resourceMap is used to keep track of occupied resources
	 *key=ThreadId, value=Resource Object*/
	private HashMap<Long, R> resourceMap = new HashMap<Long, R>();
	
	/*Linked List freeResources will keep track of available resources*/
	private LinkedList<R> freeResources = new LinkedList<R>();
	
	/* Boolean variable to see if the pool is open or not */
	private boolean isPoolOpen;

	public ResourcePool(){
		this.isPoolOpen = false;
	}
	
	public void open(){
		System.out.println("Opening Resource Pool...");
		if(!this.isPoolOpen)
			this.isPoolOpen = true;
	}
	
	public boolean isOpen(){
		return this.isPoolOpen;
	}
	
	public void close(){
		System.out.println("Closing Resource Pool...");
		this.isPoolOpen = false;
	}
	
	/* check if pool is open
	 block until resource is available
	 If resource is available, remove it from the queue and put it in resourceMap */
	public synchronized R acquire() throws Exception{
		return acquire(-1, TimeUnit.MILLISECONDS);		
	}
	
	/* Acquires the resource,  blocks if resource is not available*/
	public synchronized R acquire(long timeout, TimeUnit timeUnit) throws Exception{
		// timeout - TimeOutException
		boolean isTimeoutSet = true;
		
		if(timeout==-1){
			isTimeoutSet = false;
		}

		//timeUnit.
		if(timeUnit==TimeUnit.NANOSECONDS){
			timeout = (long)(timeout/Math.pow(10, 6));
		}else if(timeUnit==TimeUnit.MICROSECONDS){
			timeout = (long)(timeout/Math.pow(10, 3));
		}else if(timeUnit==TimeUnit.SECONDS){
			timeout = (long)(timeout*Math.pow(10, 3));
		}else if(timeUnit==TimeUnit.MINUTES){
			timeout = (long)(timeout*Math.pow(10, 3)*60);
		}else if(timeUnit==TimeUnit.HOURS){
			timeout = (long)(timeout*Math.pow(10, 3)*3600);
		}else if(timeUnit==TimeUnit.DAYS){
			timeout = (long)(timeout*Math.pow(10, 3)*3600*24);
		}
		
		if(isPoolOpen){
			synchronized(freeResources){
			while(freeResources.isEmpty()){
				System.out.println(Thread.currentThread().getId() + " is waiting for resource");
				if(isTimeoutSet){
					System.out.println("Waiting for timeout "+timeout);
					freeResources.wait(timeout);
					break;
				}else{
					freeResources.wait();
				}
			}
			}

			// Condition to check if timeout occurred or not.
			if(freeResources.isEmpty()){
				System.out.println("Timeout occured! No free resource available...");
				throw new TimeOutException();
			}
			
			R resource = freeResources.remove(0);
			resourceMap.put(Thread.currentThread().getId(), resource);
			System.out.println(Thread.currentThread().getId() + " is acquiring resource: " + resource);
			return resource;
		}else{
			System.out.println("Please Open the Resource Pool");
			throw new PoolNotOpenException();
		}
	}
	
	public synchronized void release(R resource){
		// can be released anytime
		if(resourceMap.get(Thread.currentThread().getId())==resource){
			System.out.println(Thread.currentThread().getId() + " is releasing resource: " + resource);
			resourceMap.remove(Thread.currentThread().getId());
			resourceMap.notify();
			add(resource);
		}
	}
	
	public boolean add(R resource){
		// can be added anytime
		synchronized(freeResources){
			freeResources.add(resource);
			freeResources.notify();
		}
		return true;
	}
	
	public synchronized boolean remove(R resource) throws Exception{
		// check if resouce is getting used, then block to wait
		if(resourceMap.containsValue(resource)){
				while(resourceMap.containsValue(resource)){
					resourceMap.wait();
				}
		}
		if(freeResources.contains(resource)){
				freeResources.remove(resource);
				return true;
		}
		return false;
	}
	
	// difference between remove and removeNow is that removeNow will not block
	// if the resource is acquired.
	public synchronized boolean removeNow(R resource){
		
		long threadId = Thread.currentThread().getId();
		
		if(resourceMap.containsValue(resource)){
			resourceMap.remove(threadId);
			return true;
		}
		
		else if(freeResources.contains(resource)){
			freeResources.remove(resource);
			return true;
		}
		return false;
	}
	
	public void closeNow(){
		close();
	}
}


