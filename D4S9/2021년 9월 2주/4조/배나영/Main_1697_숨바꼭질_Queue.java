package com.study.week06.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질_Queue { // BFS 방식으로 풀었음

	static class Subin {
		int location; // 수빈이의 위치
		int count; // 몇 초나 지났는지 (깊이)

		public Subin(int location, int count) {
			this.location = location;
			this.count = count;
		}
	}

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); 
		int K=sc.nextInt();
		
		// 수빈이 위치가 동생 위치랑 같게 주어졌을 때
		if(N==K) {
			System.out.println(0);
			return;
		}
		
		// 방문한 곳을 저장할 queue
		Queue<Subin> q=new LinkedList<>();
		q.offer(new Subin(N-1, 1));
		q.offer(new Subin(N+1, 1));
		q.offer(new Subin(N*2, 1));
		
		while(true) {
			Subin curr=q.poll();
			
			// 수빈이의 위치가 동생 위치와 일치할 때
			if(curr.location==K) {
				System.out.println(curr.count);
				return;
			}
			
			// 수빈이의 위치가 동생 위치와 일치하지 않을 때 
			q.offer(new Subin(curr.location-1, curr.count+1));
			q.offer(new Subin(curr.location+1, curr.count+1));
			q.offer(new Subin(curr.location*2, curr.count+1));
			
		}
		
	}
}
