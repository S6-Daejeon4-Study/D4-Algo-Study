package bfs;
import java.io.*;
import java.util.*;

public class Main_전쟁전투_1303 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); //가로
		int N = Integer.parseInt(st.nextToken()); //세로

		int B = 0, W = 0;
		char[][] map = new char[N][M];
		boolean[][] visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			map[i] = tmp.toCharArray();
		}//input
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visit[i][j])	continue;
				
				Node node = new Node(i,j);
				Queue<Node> queue = new LinkedList<>();
				queue.offer(node);
				visit[i][j] = true;
				
				int cnt=0;
				while(!queue.isEmpty()) {
					Node now = queue.poll();
					for(int d=0;d<4;d++) {
						int ni = now.i + di[d];
						int nj = now.j + dj[d];
						
						if(ni<0 || ni>=N || nj<0 || nj>=M || visit[ni][nj])
							continue;
						
						if(map[ni][nj]==map[now.i][now.j]) {
							queue.offer(new Node(ni,nj));
							visit[ni][nj] = true;
						}
					}
					cnt++;
					
				}
				if(map[i][j]=='W')
					W += cnt*cnt;
				else if(map[i][j]=='B')
					B += cnt*cnt;
			}
		}
		System.out.println(W+" "+B);
		
	}
	
	static class Node{
		int i,j;

		public Node(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}

}
