package com.ssafy.im;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author comkkyu
 * @date 21. 8. 25
 * 
 * SWEA 4796 - 의석이의 우뚝 선 산
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWS2h6AKBCoDFAVT&categoryId=AWS2h6AKBCoDFAVT&categoryType=CODE&problemTitle=4796&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 *
 */
public class SWEA_4796_의석이의우뚝선산 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] arr;
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int cnt = 0;
			arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			cnt = solve(arr, N);
			
			sb.append("#"+t+" "+cnt+"\n");
		}
		
		System.out.println(sb);
		
		sc.close();
	}
	
	private static int solve(int[] arr, int n) {
		int high = 0, low = 0, cnt = 0; // 산의 높이 증가 횟수, 산의 높이 감소 횟수, 우뚝 선 산 구간 개수
		
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) { // 현재 산이 이전 산보다 높이가 높다면 high++
				if (low > 0) { // 단 이미 한번 낮아졌다가 다시 높아진 경우는 우뚝 선 산이 아니므로
					cnt += high * low; // 지금까지 구한 high 와 low 값으로 구간의 경우의 수를 구한다.
					high = low = 0; // 새로온 구간을 찾아야 하므로 다시 0으로 초기화
				}
				high++;
			} else { // 현재 산의 높이가 이전 산보다 낮으면 low++
				low++;
			}
		}
		
		cnt += high * low; // 최종적으로 low 로 마무리 된 경우가 있을 수도 있으므로 한번더 경우의 수를 더 해준다.
		return cnt;
	}

}
