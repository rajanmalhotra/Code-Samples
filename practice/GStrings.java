package practice;

import java.util.Iterator;

class GIterator implements Iterator<GStrings>{
	public GIterator(){
		
	}
	public boolean hasNext(){
		return true;
	}
	public GStrings next(){
		GStrings g = new GStrings();
		return g;
	}
	public void remove(){}
}

public class GStrings implements Iterable<GStrings>{
	
	public Iterator<GStrings> iterator(){
		GIterator iter = new GIterator();
		return iter;
	}
	
	public static int maxIndex=0;
	/* strings */
	public int lenUniqueStr(String str){
		int[] chars	= new int[256];
		int maxLen = 0;
		int currLen = 0;

		for(int i=0; i < 256; i++){
			chars[i] = -1;
		}

		chars[str.charAt(0)] = 0;
		int i;
		int prev_index;
		
		for(i=1; i < str.length(); i++){
			prev_index = chars[str.charAt(i)];
			if(prev_index==-1 || i-prev_index > currLen){
				currLen++;
			}else{
				if(currLen > maxLen){
					maxLen = currLen;
					maxIndex = i - currLen;
				}
				currLen = i - prev_index;
			}
			chars[str.charAt(i)] = i;
		}
		
		if(currLen > maxLen){
			maxLen = currLen;
			maxIndex = i - currLen;
		}
		return maxLen;		
	}

	public int largestSumContiguousSubArray(int[] arr){
		int currSum = 0;
		int maxSum = arr[0];

		for(int i=0; i < arr.length; i++){
			if(arr[i] < currSum + arr[i]){
				currSum += arr[i];		
			}else if(currSum < arr[i]){
				currSum = arr[i];
			}
			if(currSum > maxSum){
				maxSum = currSum;			
			}
		}
		return maxSum;
	}

	public int longestIncreasingSubSequence(int[] arr){
		int[] LIS = new int[arr.length];
		int maxn = 0;
		LIS[0] = 1;

		for(int i=1; i < arr.length; i++){
			maxn=0;
			for(int j=0; j<i; j++){
				if(arr[j] < arr[i] && LIS[j] > maxn){
					maxn = LIS[j];				
				}
			}
			LIS[i] = maxn+1;
		}

		int maxi=0;
		for(int i=0; i < arr.length; i++){
			if(LIS[i] > maxi){
				maxi = LIS[i];			
			}		
		}
		return maxi;
	}

	public int maxLengthChainPairs(pair[] arr){
		int LIS[] = new int[arr.length];
		int maxn;
		for(int i=1; i < arr.length; i++){
			maxn=0;
			for(int j=0; j < i; j++){
				if(arr[j].y < arr[i].x && LIS[j] > maxn){
					maxn=LIS[j];				
				}
			}
			LIS[i] = maxn+1;	
		}
		int maxi=0;
		for(int i=0; i < arr.length; i++){
			if(LIS[i] > maxi){
				maxi = LIS[i];			
			}		
		}
		return maxi;
	}

	public int maxProdSubArray(int[] arr){
		int OverallMax = 0;
		int maxPosProd = 1;
		int minNegProd = 1;

		for(int i=0; i< arr.length; i++){
			if(arr[i] > 0){
				maxPosProd = maxPosProd * arr[i];
				minNegProd = Math.min(minNegProd * arr[i], 1);
			}else if(arr[i] < 0){
				int temp = maxPosProd;
				maxPosProd = Math.max(minNegProd * arr[i], 1);
				minNegProd = temp * arr[i];			
			}else{
				maxPosProd = 1;
				minNegProd = 1;
			}
			if(maxPosProd > OverallMax){
				OverallMax = maxPosProd;			
			}
		}
		return OverallMax;
	}

	public boolean isSubSetSum(int[] arr, int n, int sum){
		if(sum==0){
			return true;		
		}
		if(n==0){
			return false;
		}
		return isSubSetSum(arr, n-1, sum) || isSubSetSum(arr, n-1, sum-arr[n-1]);
	}

	public boolean findPartitionRec(int[] arr){
		int Sum = 0;
		for(int i=0; i < arr.length; i++){
			Sum += arr[i];		
		}	
		
		if(Sum%2==1){
			return false;		
		}
		
		return isSubSetSum(arr, arr.length, Sum/2);
	}

	public boolean findPartitionIter(int[] arr){
		int len = arr.length;
		int sum = 0;
		for(int i=0; i < len; i++){
			sum += arr[i];
		}

		boolean sumArray[][] = new boolean[sum/2+1][len+1];
		for(int i=0; i < sum/2+1; i++){
			sumArray[i][0] = false;
		}
		
		for(int i=1; i < len+1; i++){
			sumArray[0][i] = true;
		}

		for(int i=1; i<sum/2+1; i++){
			for(int j=1; j<len+1; j++){
				sumArray[i][j] = sumArray[i][j-1];
				if(i >= arr[j-1]){
					sumArray[i][j] = sumArray[i][j] || 
								sumArray[i-arr[j-1]][j-1];
				}
			}		
		}
		return sumArray[sum/2][len];		
	}

	public static void main(String[] args){
		GStrings g = new GStrings();
		String str ="Ankurkobhooklagi";

		int len = g.lenUniqueStr(str);
		System.out.println(str.substring(maxIndex, maxIndex+len) + " of length : " + len);

		int[] arr = {-1, 3, -10, 0, 6, -2, 12, -4, 8, -2};
		//{8, -9, 10, -2 , -3, 12, 7, 4, -5, 9, -8};
		System.out.println(g.largestSumContiguousSubArray(arr));

		GStrings m = new GStrings();
		int arr1[] = {-1, 3, -10, 0, 6, -2, 12, -4, -5, 20};
		System.out.println(m.maxProdSubArray(arr1));

		int arr2[] = {-1, 3, -10, 6, -2, 12, -4, 8, 10};
		int arr3[] = {1, 3, 10, 6, 2, 12, 4, 8, 10};
		System.out.println(m.findPartitionRec(arr2));
		System.out.println(m.findPartitionIter(arr3));	
	}
}

class pair{
	int x;
	int y;
}
