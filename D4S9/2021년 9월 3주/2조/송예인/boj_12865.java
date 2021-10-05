package study09_week3;

import java.util.Scanner;

public class boj_12865 {
	static class Knapsack{
		int weight;
		int value;
		Knapsack(int weight, int value){
			this.weight = weight;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Knapsack[] knapsack = new Knapsack[N+1];
		knapsack[0] = new Knapsack(0,0);
		for(int i=1;i<=N;i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			knapsack[i] = new Knapsack(w,v);
		}//input end
		
		//2차원 배열 dp 만들기
		//p[i,w] = i개의 보석이 있고 무게한도가 w일때 최대가치
		//1)if(wi>w) p[i,w] = p[i-1,w]
		//2)else p[i,w] = max(p[i-1,w],p[i-1,w-wi]+vi) 
		
		int[][] dp = new int[N+1][K+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				if(i==0 || j==0) {//채울수 있는 무게가 0이거나 채울 물건이 없을때 가치도 0
					dp[i][j] = 0;
					continue;
				}
				if(knapsack[i].weight>j) dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-knapsack[i].weight]+knapsack[i].value);
				}
			}
		}
		
		System.out.println(dp[N][K]);

		
	}

}
