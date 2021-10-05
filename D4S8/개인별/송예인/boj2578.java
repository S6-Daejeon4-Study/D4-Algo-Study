package algo;

import java.io.IOException;
import java.util.Scanner;

public class boj2578 {
	static int[] H = new int[5];// 가로 총 인덱스를 계산하는 배열
	static int[] V = new int[5];// 세로 -> 한 인덱스가 5가 되면 빙고!
	static boolean[][] check = new boolean[5][5];// 대각선을 체크하기 위함
	static int[][] map = new int[5][5];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 사회자가 번호를 외침
		int result = 0;
		for (int t = 0; t < 25; t++) {

			int total = 0;
			int num = sc.nextInt();
			// 해당 숫자의 행, 열을 찾아야함
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == num) {
						H[i] += 1;
						V[j] += 1;
						check[i][j] = true;
						break;
					}
				}
			}

			// 가로,세로 빙고가 있는지 확인
			for (int k = 0; k < 5; k++) {
				if (H[k] == 5)
					total += 1;
				if (V[k] == 5)
					total += 1;
			}

			// 대각선 두방향중 빙고가 있는지 확인
			boolean flag_l = true;
			for (int g = 0; g < 5; g++) {
				if (!check[4 - g][g]) {
					flag_l = false;
					break;
				}
			}
			if (flag_l)
				total += 1;

			boolean flag_r = true;
			for (int h = 0; h < 5; h++) {
				if (!check[h][h]) {
					flag_r = false;
					break;
				}
			}
			if (flag_r)
				total += 1;

			if (total >= 3) {
				result = t + 1;
				break;
			}
		}

		System.out.println(result);

	}

}
