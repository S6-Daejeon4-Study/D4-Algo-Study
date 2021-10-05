package study09_week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697 {
	static int[] visit;
	static int N,K;
	
	// 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		visit = new int[100001];
		N = sc.nextInt();
		K = sc.nextInt();
		
		boolean out = false;
		visit[N] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		while(!q.isEmpty()) {
			for(int s=0;s<q.size();s++) {
				int target = q.poll();
				if(target==K) {
					out = true;
					
					break;
				}
				if(target-1>=0 && visit[target-1]==0) {
					visit[target-1] = visit[target]+1;
					q.add(target-1);
				}
				if(target+1<=100000 && visit[target+1]==0) {
					visit[target+1] = visit[target]+1;
					q.add(target+1);
				}
				if(target*2<=100000 && visit[target*2]==0) {
					visit[target*2] = visit[target]+1;
					q.add(target*2);
				}
				
			}
		
			
			if(out) break;
		}
		
		System.out.println(visit[K]);
	}

}