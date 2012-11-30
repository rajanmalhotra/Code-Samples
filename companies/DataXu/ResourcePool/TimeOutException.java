package companies.DataXu.ResourcePool;

public class TimeOutException extends Exception{

	private static final String errMsg= "TimeOut Occured while waiting for resource!";
	
	public TimeOutException(){
		super(errMsg);
	}
	
}
