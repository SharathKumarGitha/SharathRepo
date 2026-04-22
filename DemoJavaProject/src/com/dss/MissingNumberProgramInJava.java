package com.dss;

public class MissingNumberProgramInJava {
	
	public static void main(String[] args) {
		
		int arr[]= {1,2,4,5,6,8,10,12};
		
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]!=arr[i+1]  && arr[i+1]!=arr[i]+1)
			{
				System.out.println("we found missing number"+(arr[i]+1));
			}
		}
	}

}
