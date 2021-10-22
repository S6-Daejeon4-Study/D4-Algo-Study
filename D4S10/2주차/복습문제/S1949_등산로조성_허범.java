package day1015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성 {
	static int T;
	static int N;//지도 크기.
	static int K;//공사 깊이.
	static int[][] map;
	static boolean[][] visited;
	static int max_height;
	static int result;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 전체 초기화.
			map = new int[N][N];
			visited = new boolean[N][N];
			max_height = 0;
			result = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 입력받으면서 최고 높이 갱신.
					max_height = Math.max(map[i][j], max_height);
				}
			}
			
		
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max_height) { // 최고높이라면
						//탐색.
						visited[i][j] = true;
						dfs(i, j, map[i][j], 1, 1);// x좌표, y좌표, 시작점의 높이, 산을 깎을 수 있는 횟수, 이동 횟수
						visited[i][j] = false;
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}

	public static void dfs(int x, int y, int height, int cnt, int move) {
		for (int i = 0; i < 4; i++) {
			if (result < move) {
				result = move;
			}
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
				// 범위 안에 있으면서 방문하지 않았다면
				if (height <= map[nx][ny]) {
					// 가야할 곳의 높이가 현재의 높이보다 높다면
					if (cnt == 1 && height > map[nx][ny] - K) {
						// 깎을 횟수가 남아 있고 깎았을 때 현재 높이 보다 낮아진다면
						visited[nx][ny] = true;
						dfs(nx, ny, height - 1, cnt - 1, move + 1);
						visited[nx][ny] = false;
					}
				}
				else { // 가야할 곳의 높이가 현재 높이보다 작으니까
					visited[nx][ny] = true;
					dfs(nx, ny, map[nx][ny], cnt, move + 1);
					visited[nx][ny] = false;
				}
			}
		}
	}
}
