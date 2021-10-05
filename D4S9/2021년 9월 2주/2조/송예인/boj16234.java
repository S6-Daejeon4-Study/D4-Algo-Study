package study09_week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj16234 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, L, R;
	static int[][] map;
	//static boolean[][] check_stage;
	static boolean[][] check;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Point> list;

	static int total_idx;
	static int total_sum;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// input end!

		ans = 0;
		//check_stage = new boolean[N][N];
		while (true) {
			check = new boolean[N][N];//하루기준으로 누적
			boolean change = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!check[i][j]) {
						total_sum = map[i][j];
						total_idx = 1;
						//check_stage = new boolean[N][N];//인접마을기준 누적
						list = new ArrayList<>();
						dfs(i, j);
						// check_stage 가 true 인것들만 total_idx, total_sum 이용해서 값 변경해주기
						if (total_idx > 1) {
							change_map();
							change = true;
							// print();
						}

					}
				}
			}
			if (!change)
				break;
			ans++;
		}

		System.out.println(ans);

	}

	private static void change_map() {

		for(int l=0;l<list.size();l++) {
			map[list.get(l).x][list.get(l).y] = total_sum/total_idx;
		}
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (check_stage[i][j]) {
//					map[i][j] = total_sum / total_idx;
//				}
//			}
//		}

	}

	private static void dfs(int i, int j) {// 좌표, 개수
		//check_stage[i][j] = true;
		check[i][j] = true;
		list.add(new Point(i,j));
		for (int t = 0; t < 4; t++) {
			int x = i + dx[t];
			int y = j + dy[t];
			if (x >= 0 && x < N && y >= 0 && y < N && Math.abs(map[i][j] - map[x][y]) >= L
					&& Math.abs(map[i][j] - map[x][y]) <= R && !check[x][y]) {

				total_idx += 1;
				total_sum += map[x][y];

				dfs(x, y);
			}
		}

	}
	
	private static void bfs(int i,int j) {
		check[i][j] = true;
		list.add(new Point(i,j));
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i,j));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int t=0;t<4;t++) {
				int x = p.x+dx[t];
				int y = p.y+dy[t];
				if(x>=0 && x<N && y>=0 && y<N && !check[x][y] && Math.abs(map[p.x][p.y] - map[x][y]) >= L
						&& Math.abs(map[p.x][p.y] - map[x][y]) <= R) {
					total_idx +=1;
					total_sum += map[x][y];
					check[x][y] = true;
					list.add(new Point(x,y));
					q.add(new Point(x,y));
				}
			}
		}
	}

}
