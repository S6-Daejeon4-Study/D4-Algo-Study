package day0928;

import java.util.Scanner;

public class Baekjoon_9465_스티커 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int TC =1 ; TC <=tc ; TC++) {
			
			int n = sc.nextInt();
			
			int[][] map = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			
			for (int i = 2; i <=n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
			
			
		}
	}
}
