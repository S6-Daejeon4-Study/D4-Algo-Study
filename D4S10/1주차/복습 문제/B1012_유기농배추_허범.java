package day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	
	static int m; // 가로길이.
	static int n; // 세로길이.
	static int k; // 배추가 심어져있는 위치의 갯수.
	static int[][] maps; // 배추를 위치를 담을 배열.
	static boolean[][] visited;
	static int result; // 지렁이 수.
	
	static int[] dx = {0, 1, 0, -1}; // 가로
	static int[] dy = {-1, 0, 1, 0}; // 세로

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			maps = new int[n][m];//배열 크기.
			visited = new boolean[n][m];//배열크기.
			result = 0;
			
			// 배추의 위치
			int x;
			int y;
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				maps[y][x] = 1;//좌표값을 배열에 저장.
			}
			
			// 배열을 돌면서 지렁이 필요한 곳 탐색.
			for(int a=0; a<n; a++) {
				for(int b=0; b<m; b++) {
					if(maps[a][b]==1 && !visited[a][b]) {//배추가 있고 방문하지 않았다면
						result++;//지렁이 추가
						visited[a][b] = true;
						dfs(a, b);//주변 탐색
					}
				}
			}
			//결과값 출력
			System.out.println(result);
		}
	}
	
	static void dfs(int y, int x) {
		int nx, ny;
		
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			// 범위 체크
			if(ny>=0 && nx>=0 && ny<n && nx<m) {
				// 배추가 있고 방문 안한 곳
				if(maps[ny][nx]==1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					dfs(ny, nx);
				}				
			}
		}
	}
}
