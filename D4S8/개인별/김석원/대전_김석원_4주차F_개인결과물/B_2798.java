package baekjoon_Easy;

import java.util.Scanner;

public class B_2798 {
	public static void main(String[] args) {
		//N개의 번호를 입력받아 3개를 선택해(조합) 그 합이 M과 작거나 같은 수중 최대값을 출력하는 문제.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int max = 0;
		int[] cards = new int[N];
		
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}//end input
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if( max < sum && sum <= M) { // M보다 작은데 최대값이면 max에 대입!!!
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}
