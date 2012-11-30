package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class AB{
	public void testIt(){
		
		//Parent p = new Parent();
		/* Not visible because x is protected */
		//System.out.println(p.x);
		
	}
}

class Child extends ArrayList<Integer>{
	public void test(){
		Child c = new Child();
		List<Integer> l = new Vector<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		
	}
	
	public boolean add(Integer e){
		System.out.println("Override : " + e);
		return true;
	}
	
	public static void main(String[] args){
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(2);
		ArrayList<Integer> a = new Child();
		a.add(3);	// only the methods which are in parent will be called from derived
		a = b;
		a.add(5);
		Child c = new Child();
		c.add(4);
		c.test();
	}
}


abstract class C{
	public void method1(){;}
	public void method2(){;}
	public void method3(){;}
	public abstract void method4();	
}

interface B{
	public void method1();
	public void method2();
	public void method3();
}