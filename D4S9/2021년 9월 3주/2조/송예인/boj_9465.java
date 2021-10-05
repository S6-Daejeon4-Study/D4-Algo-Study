package study09_week3;

import java.util.Scanner;

//1. 위, 아래 두개의 칸 각각에 현재 x 위치에서 가질수 있는 가장 큰 값 기록하면서 나아감
//2. ..

public class boj_9465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[2][N];
			for (int n = 0; n < N; n++) {
				map[0][n] = sc.nextInt();
			}
			for (int n = 0; n < N; n++) {
				map[1][n] = sc.nextInt();
			} // input end
			int[][] dp = new int[2][N];
			if (N == 1) {
				System.out.println(Math.max(map[0][0], map[1][0]));
			} else if(N==2){
				System.out.println(Math.max(map[0][0] + map[1][1], map[0][1]+map[1][0]));
			}else {
				dp[0][0] = map[0][0];
				dp[1][0] = map[1][0];
				dp[0][1] = dp[1][0] + map[0][1];
				dp[1][1] = dp[0][0] + map[1][1];

				// dp 채워나가기
				for (int i = 2; i < N; i++) {
					dp[0][i] = Math.max(dp[1][i - 1] + map[0][i], dp[1][i - 2] + map[0][i]);
					dp[1][i] = Math.max(dp[0][i - 1] + map[1][i], dp[0][i - 2] + map[1][i]);
				}

				System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
			}

		}

	}

}
