package com.study.week03;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2346_풍선터뜨리기 {
	
	static class Balloon { // 풍선
		int idx;
		int num;
		
		public Balloon(int idx, int num) {
			this.idx=idx;
			this.num=num;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ArrayList<Balloon> list=new ArrayList<>();
		int N=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			int num=sc.nextInt();
			list.add(new Balloon(i+1, num));
		}
		
		int index=0;
		StringBuilder result=new StringBuilder();
		
		while(!list.isEmpty()) { // 풍선이 다 터지지 않은 동안

			result.append(list.get(index).idx+" ");
			index+=list.remove(index).num; // 삭제
			
			while(true) {
				
				if(index>=0&&index<list.size()) break;
				
				// 인덱스가 리스트의 범위 밖이 되었을 경우 
				if(index<0) index+=list.size(); 
				else if(index>list.size()) index-=list.size();
				
			}

///////////////////////////////////////////////////////////////////////			
//			디버깅
//			for(int i=0;i<list.size();i++) {
//				System.out.print("idx: "+list.get(i).idx);
//				System.out.println(", num: "+list.get(i).num);
//			}
//			System.out.println("result: "+result);
//			System.out.println("-----------------");
		}
		System.out.println(result);
	}
}
