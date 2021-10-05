package com.study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2161 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[2*N];
		int[] ans=new int[N];
		int start=0;
		int end=N;
		int ansSize=0;
		
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
			ans[i]=-99;
		}
		
		while(ansSize<N) {
			
			ans[ansSize]=arr[start];
			start++;
			ansSize++;
			arr[end]=arr[start];
			start++;
			end++;
			
		}
		
		for(int i=0;i<ansSize;i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
