import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_뱀_3190 {
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		int[][] map = new int[N][N];
		StringTokenizer st;
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		HashMap<Integer, String> direct = new HashMap<>();
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			direct.put(X, C); // 방향 정보담는 hashmap
		}

		int x = 0;
		int y = 0;
		int dir = 0;
		int time = 0;
		ArrayList<Point> list = new ArrayList<>();
		list.add(new Point(x, y));
		outer: while (true) {
			++time;
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				break;
			}
			for (int i = 0; i < list.size(); i++) {
				if (nx == list.get(i).x && ny == list.get(i).y) {
					break outer;
				}
			}

			if (map[nx][ny] == 1) {
				list.add(new Point(nx, ny));
				map[nx][ny] = 0;
			} else {
				list.add(new Point(nx, ny));
				list.remove(0); // 꼬리 삭제
			}
			
			if (direct.containsKey(time)) {
				if (direct.get(time).equals("D")) {
					dir += 1;
					if (dir == 4)
						dir = 0;
				} else if (direct.get(time).equals("L")) {
					dir -= 1;
					if (dir == -1)
						dir = 3;
				}
			}
			x = nx;
			y = ny;
		}

		System.out.println(time);
	}

}
