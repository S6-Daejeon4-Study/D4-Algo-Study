package baekjoon_Easy;

import java.util.Arrays;
import java.util.Scanner;

public class B_3985_1 {
	static int[] cakes;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt() + 1;
		int N = sc.nextInt();
		cakes = new int[N+1];
		visit = new boolean[L];
		int max = 0;
		int index = 0;
		for(int i = 1; i <= N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			for(int s = start; s <= end; s++) {
				if( max < end - start + 1) {
					max = end - start + 1;
					index = i;
				}
				if(!visit[s]) {
					visit[s] = true;
					cakes[i]++;
				}
			}
		}
		System.out.println(index);
		max = 0;
		index = 0;
//		System.out.println(Arrays.toString(visit));
		for(int i = 1; i < N+1; i++) {
		 if( cakes[i] > max) {
			 max = cakes[i];
			 index = i;
		 }	
		}
		System.out.println(index);
		
	}
}
