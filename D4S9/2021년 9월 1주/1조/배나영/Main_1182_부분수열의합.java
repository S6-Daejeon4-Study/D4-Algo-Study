package com.study.week05;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1182_부분수열의합 {

	static int cnt;
	static int[] arr; // 입력된 수들의 배열
	static boolean[] visited; // 방문을 하면 true, 방문 안 하면 false
	static int N;
	static int S;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		func(0, 0);

		System.out.println(cnt);
	}

	static void func(int sum, int curr) {

		if (sum == S && curr==N) {

			boolean isAllFalse = true; // visited의 모든 값이 false인 경우

			for (int i = 0; i < visited.length; i++) {
				if (visited[i])
					isAllFalse = false; // visited의 하나라도 true인 경우 isAllFalse를 false
			}

			if (!isAllFalse) { // 하나라도 방문했을 때 증가시킴
			
//				System.out.println(Arrays.toString(visited));
				cnt++;
			}
			return;
		}
		
		if(curr==N) return;

		visited[curr] = true;
		func(sum + arr[curr], curr + 1); // 포함되는 경우
		visited[curr] = false;
		func(sum, curr + 1); // 포함 안되는 경우
		
		
	}
}
