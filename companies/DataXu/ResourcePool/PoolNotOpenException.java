package companies.DataXu.ResourcePool;

public class PoolNotOpenException extends Exception{

	private static final String errMsg = "Resource Pool is not open";
	
	public PoolNotOpenException(){
		super(errMsg);
	}
}
