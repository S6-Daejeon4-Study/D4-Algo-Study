package com.study.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {

	static int N, M; // 지도 크기
	static int[][] map;
	static boolean[] visited; // 방문 여부 표시할 1차원 배열
	static int areaResult; // 안전영역의 최대값

	// 델타: 오른쪽, 아래, 왼쪽, 위
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	// 바이러스의 위치들 저장해둘 배열
	static ArrayList<Point> virus;

	public static void main(String[] args) throws IOException {

		// 입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N * M];
		areaResult = Integer.MIN_VALUE; // 최소값으로 초기화해주기
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) { // 바이러스인 경우
					virus.add(new Point(i, j)); // virus에 넣어주기
				}
			}
		}
		// 입력 끝

		chooseWall(0, 0);
		System.out.println(areaResult);

	}// end main

	// 3개의 벽을 선택하는 메소드
	// cnt: 지금까지 선택한 수, index: 지금 고려할 인덱스
	static void chooseWall(int cnt, int index) {

		if (cnt == 3) { // 3개 선택한 경우 안전영역 계산
			int[][] copyMap = deepcopy(); // map과 같은 새 배열 만들어줌

			for (int i = 0; i < visited.length; i++) { // visited 배열 전체에 대해서
				if (visited[i]) {// 내가 고른 3개의 벽에 해당되면
					copyMap[i / M][i % M] = 3; // 벽 세워줌
				}
			}

			bfs(copyMap); // 바이러스 퍼뜨리기

			return;
		}

		if (index >= visited.length) {
			return;
		}

		int i = index / M;
		int j = index % M;

		if (map[i][j] == 0) { // 방문한 적 없는 빈 공간(벽 세워질 수 있음)일 때
			visited[index] = true; // 선택됨
			chooseWall(cnt + 1, index + 1); // 1개 선택하고 다음 인덱스를 고려하도록 재귀 호출
		}
		visited[index] = false; // 벽이 세워질 수 없는 곳일 때 
		chooseWall(cnt, index + 1); // 다음 위치 탐색

	}// end chooseWall

	private static void bfs(int[][] copyMap) {

		Queue<Point> queue = new LinkedList<>();

		// 바이러스의 위치들 전부 큐에 넣어주기
		queue.addAll(virus);

		while (!queue.isEmpty()) { // 큐가 비지 않은 동안
			Point now = queue.poll(); // dequeue

			for (int dir = 0; dir < 4; dir++) { // 4가지 방향에 대해서
				int ni = now.i + di[dir];
				int nj = now.j + dj[dir];

				// 다음 좌표가 map 배열 범위 안이고, 바이러스 전파 가능(0값)한 경우
				if (ni >= 0 && nj >= 0 && ni < N && nj < M && copyMap[ni][nj] == 0) {
					queue.add(new Point(ni, nj)); // 큐에 넣어주기
					copyMap[ni][nj] = 2; // 바이러스 전파
				}
			}
		} // end while

//		print(copyMap);
		// areaResult보다 크면 저장
		int num = 0; // 안전영역 세어줄 변수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0)
					num++; // 빈칸 세어준다
			}
		}

		areaResult = Math.max(areaResult, num); // 더 큰 것 저장해주기
//		print(copyMap);
	}

	// map 배열을 복사해주는 메소드
	static int[][] deepcopy() {
		int[][] arrays = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arrays[i][j] = map[i][j];
			}
		}

		return arrays;
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static void print(int[][] copyMap) {
		System.out.println("------------------------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(copyMap[i][j] + " ");
			}
			System.out.println();
		}
	}
}
