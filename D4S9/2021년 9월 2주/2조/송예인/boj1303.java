package study09_week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1303 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,M;
	static boolean[][] check;
	static char[][] map;
	static int cnt;
	static int cntB, cntW;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st_arr = br.readLine().split(" ");
		N = Integer.parseInt(st_arr[0]);
		M = Integer.parseInt(st_arr[1]);
		check = new boolean[M][N];
		map = new char[M][N];
		
		
		for(int i=0;i<M; i++) {
			char[] ch_arr = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				map[i][j] = ch_arr[j];
			}
		}
		
		for(int i=0;i<M; i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					cnt = 1;
					dfs(i,j);
					
					if(map[i][j]=='B') cntB += Math.pow(cnt, 2);
					else cntW += Math.pow(cnt, 2);
				}
			}
		}
		
		System.out.println(cntW+" "+cntB);

	}

	private static void dfs(int i, int j) {
		check[i][j] = true;
		for(int t=0;t<4;t++) {
			int x = i+dx[t];
			int y = j+dy[t];
			if(x>=0 && x<M && y>=0 && y<N && !check[x][y] && map[x][y]==map[i][j]) {
				cnt++;
				dfs(x,y);
			}
		}
		
	}

}
