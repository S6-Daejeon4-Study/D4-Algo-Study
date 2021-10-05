import java.util.Scanner;

public class Baekjoon_9465_스티커 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();

			int[][] map = new int[2][N];
			int[][] di = new int[3][N];

			// 입력 받기
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			di[0][0] = map[0][0];
			di[1][0] = map[1][0];

			for (int j = 1, i = 1; j < N; j++, i++) {
				if (i == 2)
					i = 0;
				di[0][j] = di[0][j - 1] + map[i][j];
			}
			for (int j = 1, i = 0; j < N; j++, i++) {
				if (i == 2)
					i = 0;
				di[1][j] = di[1][j - 1] + map[i][j];
			}
			for (int j = 2; j < N; j++) {
				di[2][j] = Math.max(Math.max(di[0][j-2], di[1][j-2]), di[2][j-2])  + Math.max(map[0][j], map[1][j]);
			}
			
			int ans = Math.max(Math.max(di[0][N-1], di[1][N-1]), di[2][N-1]);
			
			System.out.println(ans);
		}
	}
}
