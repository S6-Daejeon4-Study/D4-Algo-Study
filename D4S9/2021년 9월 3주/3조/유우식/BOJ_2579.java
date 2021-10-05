package day0929;

import java.util.Scanner;

public class BOJ_2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] stair = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			stair[i] = sc.nextInt();
		}
		//계단이 한칸일 때 그 값이 최대값이므로
		dp[1] = stair[1];
		//연속으로 두칸을 이동할 수 있으므로 처음 두칸을 더한 값이 무조건 최대값
		if(N>=2) {
			dp[2] = stair[1]+stair[2];
		}
		//3번째 계단부터 계산 시작
		for(int i=3; i<N+1; i++) {
			//현 계단의 전 계단 + 3칸 전 계단의 값과 2칸전 계단(연속으로 3칸을 넘어갈 수 없으므로)의 값에서 최대값을 도출한 후
			//현재 계단의 가중치에 더한다.
			dp[i] = Math.max(dp[i-2], (dp[i-3]+stair[i-1])) + stair[i];
		}
		System.out.println(dp[N]);
	}
}
