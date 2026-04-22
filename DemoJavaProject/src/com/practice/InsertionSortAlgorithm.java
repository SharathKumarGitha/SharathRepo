package com.practice;

public class InsertionSortAlgorithm {
	
	public static void main(String[] args) {
		
		int arr[]= {39,1,40,45,2,4,3};
		
		for(int i=1;i<arr.length;i++)
		{
			int temp=arr[i];
			int j=i;
			
			while(j>0 && arr[j-1]>temp)
			{
				arr[j]=arr[j-1];
				j=j-1;
			}
			arr[j]=temp;
			
		}
		
		for(int a1:arr)
		{
			System.out.println(a1);
		}
	}

}
