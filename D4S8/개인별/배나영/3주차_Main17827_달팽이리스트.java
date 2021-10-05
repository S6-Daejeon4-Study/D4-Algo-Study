package com.study.week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main17827_달팽이리스트 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int V=sc.nextInt();
		
		ArrayList<Integer> list=new ArrayList<>();
		int[] inputK=new int[M];
		
		for(int i=0;i<N;i++) {
			list.add(sc.nextInt());
		}
		
		for(int i=0;i<M;i++) {
			inputK[i]=sc.nextInt();
		}
		
		for(int i=0;i<M;i++) {
			
			// 수식 써보기
			while(inputK[i]>=list.size())
				inputK[i]=inputK[i]-list.size()+V-1;
			
			System.out.println(list.get(inputK[i]));
		}
	}
}
