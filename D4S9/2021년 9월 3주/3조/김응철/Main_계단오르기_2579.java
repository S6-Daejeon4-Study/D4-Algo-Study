package DP;

import java.util.*;

public class Main_계단오르기_2579 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] stairs = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int n=1;n<=N;n++) {
			stairs[n] = sc.nextInt();
		}
		
		dp[1] = stairs[1];
		dp[2] = stairs[1]+stairs[2];
		dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
		
		for(int i=4;i<=N;i++) {
			dp[i] = Math.max(stairs[i-1] + dp[i-3],dp[i-2])+stairs[i];
		}
		System.out.println(dp[N]);
	}
}
