import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * Date : 2021.10.19(재 - 거의 1달만)
 * Level : BaekJoon Gold 5
 * URL : https://www.acmicpc.net/problem/2636
 * Select2 : cheeseCnt 계속 갱신해서 계산(매번 map 탐색하면서 계산 X)
 * Select3 : cheese 바로바로 없애주고 큐에 추가 안하면 저장해두고 나중에 한번에 없앨 필요 X 
 * Thinking : 치즈 다 없어질 때까지 겉부분 없애기
 * Method : BFS, DFS
 */
public class BJ2636_치즈_재 {
	static int N, M, lastCnt, cheeseCnt, time;
	static int[][] map;
	static boolean[][] visit;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheeseCnt++;
			}
		}
		while(cheeseCnt != 0) {
			lastCnt = cheeseCnt;
			time++;
			visit = new boolean[N][M];
			dfs(0, 0);
		}
		System.out.println(time);
		System.out.println(lastCnt);
	}
	static void dfs(int i, int j) {
		visit[i][j] = true;
		for(int d = 0 ; d < 4 ; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(isOutOfIdx(ni, nj) || visit[ni][nj]) continue;
			if(map[ni][nj] == 1) {		// 치즈면
				map[ni][nj] = 0;		// 없애주고
				cheeseCnt--;			// 개수 빼주고 큐에 안넣음
				visit[ni][nj] = true;
			}
			else { 						// 공란이면 넣어줌
				dfs(ni, nj);
			}
		}
	}
	static boolean isOutOfIdx(int i, int j) {
		return i < 0 || i >= N || j < 0 || j >= M;
	}
}
