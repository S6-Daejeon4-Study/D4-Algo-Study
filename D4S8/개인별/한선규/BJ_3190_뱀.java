package com.ssafy.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_3190_뱀 {
	
	static int[][] board; // 보드 배열 (-1 : 뱀, 0 : 사과X, 1 : 사과O)
	static int[] dRow = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dCol = {1, 0, -1, 0}; // 우 하 좌 상
	static int N, K, C, time;
	static Deque<Point> snake = new LinkedList<>();
	static Map<Integer, Character> dirMap = new HashMap<>(); 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			
			board[row][col] = 1; // 사과 세팅
		}
		
		C = Integer.parseInt(br.readLine());
		
		for (int c = 0; c < C; c++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			
			dirMap.put(t, d);
		}
		
		playGame(0, 0, 0);
		
		System.out.println(time);
	}
	
	private static void playGame(int startRow, int startCol, int startDir) {
		int dir = startDir; // 처음 뱀의 시작방향은 상 하 좌 우 중에서 오른쪽 방향
		board[startRow][startCol] = -1; // 뱀의 몸이 있는 칸은 -1 로 표시
		snake.add(new Point(startRow, startCol)); // 초기 뱀의 머리와 꼬리는 같은 위치
		
		while (true) {
			time++;
			
			int nRow = snake.peek().x + dRow[dir];
			int nCol = snake.peek().y + dCol[dir];
			
			if (!isAlive(nRow, nCol)) break;
			
			// 위의 조건이 통과된다면 머리가 이동가능하다는 뜻
			// #1. 사과 탐색
			// #1-1. 사과가 있다면 머리만 이동
			if (board[nRow][nCol] == 1) {
				snake.addFirst(new Point(nRow, nCol));
				board[nRow][nCol] = -1;
			} else {
				//#1-2. 사과가 없다면 머리 이동하고 꼬리를 당겨와야 함
				snake.addFirst(new Point(nRow, nCol));
				board[nRow][nCol] = -1;
				board[snake.peekLast().x][snake.pollLast().y] = 0;
			}
			
			// #2. 방향전환이 있는지 확인
			if (dirMap.containsKey(time)) {
				char d = dirMap.get(time);
				
				// #2-1. 왼쪽으로 90도 회전
				if (d == 'L') {
					/**
					 * 오른쪽(0) -> 위(3)
					 * 아래(1) -> 오른쪽(0)
					 * 왼쪽(2) -> 아래(1)
					 * 위(3) -> 왼쪽(2)
					 * 기존방향에 -1하고 4로 나눈 나머지 (반시계방향)
					 * 0의 경우 -1로 되버리므로 각각의 경우에 4를 더해줘서 해결 == 즉 3을 더해준다음 4로 나눈거와 동일
					 */
					dir = (dir + 3) % 4;
				} else {
					// #2-2. 오른쪽으로 90도 회전
					/**
					 * 오른쪽(0) -> 아래(1)
					 * 아래(1) -> 왼쪽(2)
					 * 왼쪽(2) -> 위(3)
					 * 위(3) -> 오른쪽(0)
					 * 기존방향 +1하고 4로 나눈 나머지 (시계방향 진행)
					 */
					dir = (dir + 1) % 4;
				}
				
				dirMap.remove(time); // 작업이 완료된 방향전환은 map 에서 제거
			}
		}
	}
	
	private static boolean isAlive(int row, int col) { // 좌표(row, col)에 대해서 뱀의 생존유무를 true, false 로 반환하는 메서드
		return row >= 0 && row < N && col >= 0 && col < N && board[row][col] != -1;
	}

}

class Point { // 좌표 클래스
	int x; // row
	int y; // col
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
