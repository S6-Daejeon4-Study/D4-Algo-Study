package study_01;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1182_부분수열의합 {
	static int[] arr;
	static int n, s, cnt = 0;
	
	private static void dfs(int v, int su) {
		if(v == n) {//원소의 위치가 마지막이면,
			if(su == s) cnt++;//지금까지 합을 체크해서 맞으면 개수 +1
			return;
		}

		dfs(v + 1, su + arr[v]);//지금 원소를 합에 더하는 부분
		dfs(v + 1, su);//지금 원소를 포함하지 않는 부분
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt(); s = scan.nextInt(); arr = new int[n];
		
		for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
		Arrays.sort(arr);
		
		dfs(0, 0);
		System.out.print(s == 0? --cnt : cnt);//합이 0일 경우 공집합도 포함되기 때문에 하나 빼주고 출력
	}
}