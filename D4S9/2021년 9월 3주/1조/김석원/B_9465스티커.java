package week9_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_9465스티커 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++ ) {
			int col = Integer.parseInt(br.readLine());
			
			int r1= 0;
			int r2 =0;
			int[][] arr= new int[2][col];
			int[][] dp= new int[2][col];
			
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < col; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}// end input
			//dp 초기화
			if(col == 1) {
				System.out.println(Integer.max(arr[0][0],arr[1][0]));
				continue;
			}
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[0][1] = dp[1][0] + arr[0][1];
			dp[1][1] = dp[0][0] + arr[1][1];
			if(col == 2) {
				System.out.println(Integer.max(dp[0][1],dp[1][1]));
				continue;
			}
			
			//점화식 dp[i][n] = dp[i+1%2][n-1] + arr[i][n]
			// dp[i][n] = max(dp[0][n-2],dp[1][n-2]) + arr[i][n];
			
				
			for(int c = 2; c < col; c++) {
				for(int i = 0; i < 2; i++) {
					r1 = dp[(i+1) %2][c-1] + arr[i][c];
					r2 = Integer.max(dp[0][c-2],dp[1][c-2]) + arr[i][c];
					dp[i][c] = Integer.max(r1, r2);
				}				
			}
			
			System.out.println(Integer.max(dp[0][col-1], dp[1][col-1]));
			
		}// end testcase
	}
}
