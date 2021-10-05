package com.study.week02;

import java.util.Scanner;

public class Main2304 {
	
	static int[] arr=new int[1001];
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		int max=0;
		int firstMaxIdx=-1;
		int lastMaxIdx=-1;
		
		for(int i=0;i<TC;i++) {
			int idx=sc.nextInt();
			int num=sc.nextInt();
			
			arr[idx]=num;
			
			if(max<num) max=num; // 값 입력할 때 max값 구하기
		}
		
		int index=0;
		int height=0;
		int sum=0;
		
		while(firstMaxIdx==-1) { // 첫번째 max값을 찾기 전까지
			
			if(arr[index]==max) {
				firstMaxIdx=index;
			}
			
			if(height<arr[index]) {
				height=arr[index];
			}
			
			sum+=height;
			index++;
		}
		
		index=1000;
		height=0;
		
		while(lastMaxIdx==-1) { // 뒤에서 첫번째 max값을 찾기 전까지
			
			if(arr[index]==max) {
				lastMaxIdx=index;
			}
			
			if(height<arr[index]) {
				height=arr[index];
			}
			
			sum+=height;
			index--;
		}
		
		if(firstMaxIdx!=lastMaxIdx) {
			sum+=(lastMaxIdx-firstMaxIdx-1)*max;
		}
		if(firstMaxIdx==lastMaxIdx) {
			sum-=max;
		}
		
		System.out.println(sum);
	}

}
