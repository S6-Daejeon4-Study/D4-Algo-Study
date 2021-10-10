import java.io.*;
import java.util.*;

public class Main_적록색약_10026 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {
				map[i] = tmp.toCharArray();
			}
		}//input
		
		int cnt1=0, cnt2=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (!visited[i][j]) {//visit하지 않았던 곳만 체크함.
					bfs(i,j);
					cnt1++;
				}
			}
		}//RGB map배열의 모든칸을 하나씩 탐색함.
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 'R')
					map[i][j] = 'G';
				if(visited[i][j])
					visited[i][j] = false;
			}//적록색약인 사람도 체크하기 위해 R을 G로바꾸고 visit배열을 초기화 시킴.
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (!visited[i][j]) {
					bfs(i,j);
					cnt2++;
				}
			}
		}//같은 방법으로 적록색약 GB map배열을 탐색함
		
		System.out.println(cnt1+" "+cnt2);//cnt1 = GRB, cnt2 = GB
	}
	
	static void bfs(int i, int j) {//i,j부터 탐색 시작
		Queue<Point> queue = new LinkedList<>();//queue 담음
		
		queue.add(new Point(i,j));//처음 시작한 곳을 queue에 담음
		visited[i][j] = true;//visit 체크도 해줌
		
		while(!queue.isEmpty()) {//queue가 빌때까지 탐색
			Point now = queue.poll();
			
			for(int d=0;d<4;d++) {//사방탐색
				int ni = now.i + di[d];
				int nj = now.j + dj[d];
				
				if(ni<0 || ni>=N || nj < 0 || nj >= N || visited[ni][nj]) continue;
				//배열의 끝이나 탐색햇던 곳이면 continue
				if(map[ni][nj]==map[now.i][now.j]) {//값이 같으면탐색
					queue.add(new Point(ni,nj));
					visited[ni][nj] = true;//visit체크도 해줌
				}
				
			}
		}
		
	}
	
	static class Point{//배열을 탐색하기위해 i,j를 저장하는 객체
		int i,j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	
}
