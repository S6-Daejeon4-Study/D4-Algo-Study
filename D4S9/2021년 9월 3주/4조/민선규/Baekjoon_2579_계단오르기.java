package day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2579_계단오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1]; // dp 배열 선언
		int[] arr = new int[N+1]; // arr 배열 선언
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // arr 배열에 값 넣기
		}
		dp[0] = arr[0] = 0;
		dp[1] = arr[1]; // dp[1]은 arr[1]값
		dp[2] = arr[1]+arr[2]; //dp[2]는 당연히 arr[2] 보다 arr[1] + arr[2]가 크다
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3]+arr[i-1]+arr[i]);
		}
		
		
		System.out.println(dp[N]);
		
	}
}
