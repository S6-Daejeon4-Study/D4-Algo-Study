import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon_1303_전쟁 {

	static int N, M, cnt;
	static char[][] map;
	static boolean[][] visit;
	static char currentC;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];

		
		System.out.println(di.length);
		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}

		
		currentC = 'W';
		visit = new boolean[M][N];
		int wAns = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == currentC) {
					cnt = 0;
					dfs(i, j);
					wAns += cnt * cnt;
				}
			}
		}
		
		currentC = 'B';
		visit = new boolean[M][N];
		int bAns = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == currentC) {
					cnt = 0;
					dfs(i, j);
					bAns += cnt * cnt;
				}
			}
		}
		
		System.out.println(wAns + " " +bAns);
	}

	private static void dfs(int i, int j) {
		visit[i][j] = true;
		cnt++;
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];

			if (ni < 0 || ni >= M || nj < 0 || nj >= N || visit[ni][nj] || map[ni][nj] != currentC)
				continue;
			dfs(ni, nj);
		}
	}

}
