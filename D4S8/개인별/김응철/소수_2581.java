package Array;

import java.util.Scanner;

public class 소수_2581 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		int sum = 0, min = Integer.MAX_VALUE;

		boolean[] arr = new boolean[N + 1];

		arr[0] = true;
		arr[1] = true;

		for (int i = 2; i <= Math.sqrt(N + 1); i++) {
			for (int j = i * i; j < N + 1; j += i) {
				arr[j] = true;
			}
		}
		// arr = 60 61 62 63 ... 100

		for (int i = M; i < N + 1; i++) {
			if (arr[i] == false) {
				if (min > i) {
					min = i;
				}
				sum += i;
			}
		}

		if (sum == 0)
			System.out.println(-1);
		else
			System.out.printf("%d\n%d", sum, min);

	}
}
//4부터 100까지  4 6 8 10 
//9부터 100까지 9 12 15
//16부터 100까지 16 20 