package com.study.week07.DP;

import java.util.Scanner;

public class Main_12865_배낭 {
	
	static int N, K;
	static int[] weights; // 물건의 무게
	static int[] values; // 물건의 가치
	static int[][] arr;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		weights=new int[N+1];
		values=new int[N+1];
		arr=new int[N+1][K+1]; // 열이 부분배낭의 용량이라서 K+1개
		
		for(int i=1;i<=N;i++) {
			weights[i]=sc.nextInt();
			values[i]=sc.nextInt();
		}
		
		for(int i=0;i<=N;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(i==0||j==0) arr[i][j]=0;
				else if(weights[i]>j) arr[i][j]=arr[i-1][j];
				else 
					arr[i][j]=Math.max(arr[i-1][j], arr[i-1][j-weights[i]]+values[i]); // 선택하지 않는 경우, 선택하는 경우
			}
		}
		
//		print();
		System.out.println(arr[N][K]);
	}

//	static void print() {
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i].length;j++) {
//				System.out.print(arr[i][j]+" ");
//			}System.out.println();
//		}
//	}
}
