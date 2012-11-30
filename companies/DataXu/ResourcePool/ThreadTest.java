package companies.DataXu.ResourcePool;

abstract public class ThreadTest implements Runnable{
	Integer resource = null;
	boolean poolNotOpenException = false;
	boolean timeoutException = false;
		
	public Integer returnAcquiredRes(){
		return this.resource;
	}
	
	public boolean returnPoolNotOpenException(){
		return this.poolNotOpenException;
	}
	
	public boolean returnTimeOutException(){
		return this.timeoutException;
	
	}
}
