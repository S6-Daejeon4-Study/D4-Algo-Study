package com.study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2164 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[3*N];
		int[] ans=new int[N];
		int start=0;
		int end=N;
		int ansSize=0;
		
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		
		while(true) {
			
			ans[ansSize]=arr[start];
			start++;
			ansSize++;
			
			if(start==end-1) break;
			
			arr[end]=arr[start];
			start++;
			end++;
			
		}
		
		System.out.println(arr[start]);
	}
}
