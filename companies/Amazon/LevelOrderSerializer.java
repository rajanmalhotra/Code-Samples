package companies.Amazon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import com.rajan.geeksforgeeks.trees.*;

public class LevelOrderSerializer {

	public ArrayList<String> serializeLevelOrder(TreeNode<Integer> root){
		if(root==null){
			return null;
		}
		LinkedList<TreeNode<Integer>> list = new LinkedList<TreeNode<Integer>>();
		list.add(root);
		StringBuffer sb1 = new StringBuffer("");
		StringBuffer sb2 = new StringBuffer("");
		ArrayList<String> all = new ArrayList<String>();
		int val = 0;
		while(!list.isEmpty()){
			sb1.delete(0, sb1.length());
			sb2.delete(0, sb2.length());
			int len = list.size();
			for(int i=0; i < len; i++){
				TreeNode<Integer> current = list.poll();
				if(current.left!=null){
					list.add(current.left);
				}
				if(current.right!=null){
					list.add(current.right);
				}
				sb1.append(current.data + ",");
				if(current.left==null && current.right==null){
					val = 0;
				}else if(current.left!=null && current.right!=null){
					val = 2;
				}else if(current.left!=null){
					val = 1;
				}else{
					val = -1;
				}
				sb2.append(val + ",");
			}
			sb1.append("|"+sb2);
			all.add(sb1.toString());
		}
		return all;
	}
	public static void main(String[] args){
		LevelOrderSerializer l = new LevelOrderSerializer();
		int arr[] = {50, 23, 67, 89, 34, 36, 65, 32, 12, 10, 99, 78, 70, 19};
		BST<Integer> bst = new BST<Integer>();
		for(int val:arr){
			bst.insert(val);
		}
		ArrayList<String> list = l.serializeLevelOrder(bst.root);
		try{
			FileWriter fstream = new FileWriter("/home/rajan/Work_MS/Code-Samples/companies/Amazon/text");
			BufferedWriter out = new BufferedWriter(fstream);
			for(String s : list){
				out.write(s+"\n");
			}
			out.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
	}
}
