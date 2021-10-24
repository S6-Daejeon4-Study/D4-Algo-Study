import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	static int N;
	static char[][] board;
	static boolean[][] visit;
	static char alph;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static void pb() {
		for(char[] a : board) {
			for(char b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}
	static void printvisit() {
		for(boolean[] vis : visit) {
			for(boolean v : vis) {
				int tmp = v == true ? 1 : 0;
				System.out.print(tmp);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		visit = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					count++;
					bfs(i,j);
				}
			}
		}
		System.out.print(count + " ");
		count = 0;
		visit = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					count++;
					bfs2(i,j);
//					printvisit();
				}
			}
		}
		System.out.println(count);
		
		
		
		
	}
	static void bfs(int x,int y) {
		alph = board[x][y];
		visit[x][y] = true;
		Queue<point> queue = new LinkedList<point>();
		queue.offer(new point(x,y));
		while(!queue.isEmpty()) {
			point cur = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nx = dx[d] + cur.x;
				int ny = cur.y + dy[d];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(board[nx][ny] == alph && !visit[nx][ny]) {
					
						visit[nx][ny] = true;
						queue.offer(new point(nx, ny));
					}
				}
			}
		}
	}
	//R G 는 같고 B만 다르다.
	static void bfs2(int x,int y) {
		int flag = 0;
		alph = board[x][y];
		if(alph == 'B') flag = 1; 
		visit[x][y] = true;
		Queue<point> queue = new LinkedList<point>();
		queue.offer(new point(x,y));
		while(!queue.isEmpty()) {
			point cur = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nx = dx[d] + cur.x;
				int ny = cur.y + dy[d];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					
					if(flag == 1 && board[nx][ny] == 'B' && !visit[nx][ny]) {
//						System.out.print(board[nx][ny]);
						visit[nx][ny] = true;
						queue.offer(new point(nx, ny));
					}else if(flag == 0 && board[nx][ny] != 'B' && !visit[nx][ny]) {
//						System.out.print(board[nx][ny]);
						visit[nx][ny] = true;
						queue.offer(new point(nx, ny));
					}
				}
			}
		}
	}
	static class point{
		int x,y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}