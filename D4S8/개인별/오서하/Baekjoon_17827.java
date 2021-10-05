package ws;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon_17827 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

	
		int N = sc.nextInt();
		int TC = sc.nextInt();
		int V = sc.nextInt() -1;
		
		int tempLength = N - V;
		int[] arr = new int[TC];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < TC; i++) {
			int k = sc.nextInt();

			if (k < N) // 달팽이리스트 길이 보다 k가 짧으면 그대로 출력
				System.out.println(arr[k]);
			else { //// 달팽이리스트보다 긴 경우
				System.out.println(arr[(k-V) % tempLength + V]); // 연결된 원형 부분에서 인덱스 값을 측정하여 반환 
			}
		}
	}
}
