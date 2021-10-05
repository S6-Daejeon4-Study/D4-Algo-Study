package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author comkkyu
 * @date 21. 8. 25
 * 
 * 백준 10157 - 자리배정
 * https://www.acmicpc.net/problem/10157
 *
 */
public class B10157_자리배정 {
	
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
	static int[] dy = {0, 1, 0, -1};
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		int K = Integer.parseInt(br.readLine());
		
		solve(K);
	}

	private static void solve(int k) {
		
		if (k > R * C) { // 대기번호가 배열의 크기를 벗어난다면
			System.out.println(0); // 관객에게 좌석을 배정할 수 없으므로 0을 출력
			return;
		}
		
		int cnt = 1; // 시작개수는 1
		int cx = R - 1; // 시작 행
		int cy = 0; // 시작 열
		int dir = 0; // 처음에는 위 방향으로
		
		while (cnt != k) {
			map[cx][cy] = cnt; // cnt 대기번호를 가진 관객의 좌석 위치는 map[cx][cy] 임을 표시
			
			int nx = cx + dx[dir]; // 현재 방향에 대한 다음 위치의 행
			int ny = cy + dy[dir]; // 현재 방향에 대한 다음 위치의 열
			
			if (!isInside(nx, ny) || map[nx][ny] != 0) { // 배열범위를 벗어나거나 이미 예약된 좌석이라면
				dir = (dir + 1) == 4 ? 0 : dir + 1; // 방향을 바꿔줘야 함.
				nx = cx + dx[dir]; // 바꾼 방향에 대해서 탐색한 행 정보로 바꿔준다.
				ny = cy + dy[dir]; // 바꾼 방향에 대해서 탐색한 열 정보로 바꿔준다.
			}
			
			// 현재 좌표를 갱신
			cx = nx;
			cy = ny; 
			// 탐색이 끝났으므로 cnt 1 증가
			cnt++;
		}
		
		System.out.println((cy+1)+" "+(R-cx)); // 문제에서는 왼쪽 한단이 (1,1) 이므로 주어진 형식에 맞춰서 바꿔서 출력
	}
	
	private static boolean isInside(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
