package month10.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	static int cheeze, time;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		time = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*입력 완료*/
		
		/*로직 시작*/
		while(true) {
			cheeze = 0;
			time++;
			
			bfs();
			if(check()) {
				break;
			}
//			print();
		}
		
		System.out.println(time);
		System.out.println(cheeze);
	}
	
	private static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean check() {
		boolean flag = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 2) {
					cheeze++;
					map[i][j] = 0;
				}else if(map[i][j] == 1) {
					flag = false;
				}
			}
		}
		return flag;
	}

	private static void bfs() {
		Queue<Node> Q = new LinkedList<>();
		visit = new boolean[N][M];
		
		Q.add(new Node(0, 0));
		visit[0][0] = true;
		
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx <0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny])	continue;
				if(map[nx][ny] == 1) {
					map[nx][ny] = 2;
					visit[nx][ny] = true;
					continue;
				}
				Q.add(new Node(nx, ny));
				visit[nx][ny] = true;
			}
		}
	}

	private static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
