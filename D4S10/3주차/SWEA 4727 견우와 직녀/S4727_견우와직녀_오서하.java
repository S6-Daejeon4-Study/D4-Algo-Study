import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S4727_견우와직녀_오서하 {

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int[][] map;
	static int[][] visit; // 방문여부를 체크하되, int 타입으로 현재 위치를 몇분에 왔는지 기록
	static int N, T;
	static Queue<Point> queue;
	static int INF = -1; // 교차로인 경우는 갈 수 없다. 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		queue = new LinkedList<Point>();

		for (int tc = 1; tc <= TC; tc++) { // tc별로 반복한다.
			N = sc.nextInt(); // 맵의 크기 
			T = sc.nextInt(); // 분 주기

			queue.clear();
			map = new int[N][N];
			visit = new int[N][N];

			// 맵 입력받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//1. 교차로는 못건너기때문에, 위치를 파악해서  visit배열 inf로 값 채우기
			
			// 교차로인 경우 visit배열에 INF로 체크하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if (map[i][j] == 0) { // 견우가 건너지 못하므로 까마귀와 까치의 도움이 필요함

						boolean row = false, col = false;

						for (int k = 0; k < 4; k++) {
							int ni = i + di[k];
							int nj = j + dj[k];

							if (ni < 0 | ni >= N || nj < 0 || nj >= N)
								continue;
							if (map[ni][nj] == 0) {
								if (k == 0 || k == 2) { // 진행방향 위.아래를 합쳐 (세로)
									col = true;
								} else if (k == 1 || k == 3) { // 진행방향 오른쪽, 왼쪽를 합쳐 (가로)
									row = true;
								}
							}
						}
						// row와 col모두 true인 경우 교차로임.
						if (col == true && row == true) {
							visit[i][j] = INF;
						}
					}
				}
			} // 교차로 판단하는 for 종료

//		print(); // 교차로 잘 표시되었는지 출력
//
			Point start = new Point(0, 0); // 견우 출발점
			queue.add(start);
			visit[start.x][start.y] = 0; // 시간 기록

			bfs();

			System.out.println("#" + tc + " " + visit[N - 1][N - 1]);
		}
	}

	private static void bfs() {
		
		boolean falg = false;

		while (!queue.isEmpty()) {

			Point now = queue.poll();

			int currentTime = visit[now.x][now.y];

			for (int k = 0; k < 4; k++) {// 4방탐색하여 견우가 직녀를 만나러 갑니다
				int ni = now.x + di[k];
				int nj = now.y + dj[k];

				// 범위를 벗어난 경우
				// 이미 방문을 했으며 현재 오는게 돌아 돌아 오는 길인 경우
				// 건널수 없는 교차로인 경우
				if (ni < 0 | ni >= N || nj < 0 || nj >= N || (visit[ni][nj] != 0 && visit[ni][nj] <= currentTime + 1)
						|| visit[ni][nj] == INF)
					continue;
				
				if (map[ni][nj] == 1) { // 연결되어있는 경우, 시간 상관없이 건널 수 있다.
					queue.add(new Point(ni, nj));
					visit[ni][nj] = currentTime + 1;
				}
				
				// 까마귀 까치 도움이 필요하면서, 교차로가 아닌 곳이면 건널 가능성이 있다.
				else if (map[ni][nj] == 0) {
					// T시간의 배수 동안만 건널 수 있으므로, T배수가 될 때까지 현재 시간 증가시키면서 기다려
					while ((currentTime + 1) % T != 0) {
						currentTime = currentTime + 1; 
					}
					queue.add(new Point(ni, nj));
					visit[ni][nj] = currentTime + 1;
				}

				else if (map[ni][nj] > 1) { // 1보다 큰값인 경우는 적힌 시간만큼 기다리면 건널 수 있다.
					int T2 = map[ni][nj];
					while ((currentTime + 1) % T2 != 0) {
						currentTime = currentTime + 1;
					}
					queue.add(new Point(ni, nj));
					visit[ni][nj] = currentTime + 1;
				}
			}

		}

//		print();
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%3d", visit[i][j]);
			}
			System.out.println();
		}
	}
}

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
