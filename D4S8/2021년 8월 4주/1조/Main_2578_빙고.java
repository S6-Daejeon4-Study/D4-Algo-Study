// 대전 4반 배나영
package com.study.week04;

import java.util.Scanner;

public class Main_2578_빙고 {

	static boolean[][] visited; // 사회자가 불렀는지 아닌지 체크
	static int[] row; // 값이 가지고 있는 행 위치
	static int[] col; // 값이 가지고 있는 열 위치

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		visited = new boolean[5][5];
		row = new int[26]; // 수가 1~25까지이므로
		col = new int[26];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int num = sc.nextInt(); // 입력되는 숫자
				row[num] = i; // 숫자 행 위치 저장
				col[num] = j; // 숫자 열 위치 저장
			}
		}

		int count = 0; // 사회자가 부른 수가 몇번째인지
		int[] rowCount = new int[5]; // 같은 행끼리의의 합
		int[] colCount = new int[5]; // 같은 열끼리의 합

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				count++;
				int bingo = 0; // 만들어진 빙고의 수 저장
				int callNum = sc.nextInt(); // 사회자가 부른 숫자
				visited[row[callNum]][col[callNum]] = true; // 방문 처리
				rowCount[row[callNum]]++;
				colCount[col[callNum]]++;

				// 사회자가 불렀던 수들이 대각선이 되는지 점검
				if (visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4]) {
					bingo++;
				}
				if (visited[4][0] && visited[3][1] && visited[2][2] && visited[1][3] && visited[0][4]) {
					bingo++;
				}

				for (int k = 0; k < 5; k++) {
					// 같은 행에 방문한 원소 5개->빙고
					if (rowCount[k] == 5)
						bingo++;

					// 같은 열에 방문한 원소 5개->빙고
					if (colCount[k] == 5)
						bingo++;

				}
				if (bingo >= 3) {
					System.out.println(count);
					return;
				}
			}
		}
	}

}
