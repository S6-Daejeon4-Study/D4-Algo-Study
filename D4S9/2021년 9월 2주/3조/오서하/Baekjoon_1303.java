import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1303 {

	static char[][] map;
	static int[][] visit;
	static int time;
	static Queue<point> queue;
	static int N, M;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static char currentColor;

	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로 -  열의 갯수 (|)
		M = Integer.parseInt(st.nextToken()); // 세로 - 행의 갯수 (-)

		map = new char[M][N];
		visit = new int[M][N];
		queue = new LinkedList<point>();

		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// W
		currentColor = 'W';
		int whiteVal = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0 && map[i][j] == 'W') {
					time = 1;
					visit[i][j] = time;
					queue.add(new point(i, j));
					whiteVal += bfs();
				}
			}
		}
		// B
		currentColor = 'B';
		int blueVal = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0 && map[i][j] == 'B') {
					time = 1;
					visit[i][j] = time;
					queue.add(new point(i, j));
					blueVal += bfs();
				}
			}
		}
		System.out.println(whiteVal+" "+blueVal);

	}

	private static int bfs() {
		// TODO Auto-generated method stub

		point now = null;
		while (!queue.isEmpty()) {
			now = queue.poll();

			for (int k = 0; k < 4; k++) {
				int mi = now.x + di[k];
				int mj = now.y + dj[k];

				if (mi < 0 || mi >= M || mj < 0 || mj >= N) // 맵을 벗어나면 패스
					continue;
				if (currentColor != map[mi][mj] || visit[mi][mj] != 0) // 이미 방문했던 곳이거나, 현재 찾고자하는 색이 아닌경우도 패스
					continue;
				time = time + 1;
				visit[mi][mj] = time;
				queue.add(new point(mi, mj));
			}
		}
		return visit[now.x][now.y] * visit[now.x][now.y];
	}

}
