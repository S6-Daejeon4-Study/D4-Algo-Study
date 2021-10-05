package study09_week3;

import java.util.Scanner;

//계단 매 칸에서, 전칸에서 온경우의 최댓값, 전전 칸에서 온 경우의 최댓값 메모하며 끝계단까지 가기

public class boj_2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		//arr[0] = 0으로 
		for(int i=1;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}//input end
		
		int[][] dp = new int[2][N+1];//바로 전 칸에서 온 경우, 전전 칸에서 온 경우
		dp[0][1] = arr[1];
		dp[1][1] = arr[1];
		for(int i=2;i<=N;i++) {
			dp[0][i] = dp[1][i-1]+arr[i];
			dp[1][i] = Math.max(dp[0][i-2]+arr[i], dp[1][i-2]+arr[i] );
		}
		System.out.println(Math.max(dp[0][N], dp[1][N]));

	}

}
