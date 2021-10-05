// 대전 4반 이지순
package IM_BJ_DIFFICULTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_빙고_2578 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		StringTokenizer st;
		
		for (int i = 0; i < 5; i++) { //배열 채우기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int idx = 0;
		outer: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				idx++;
				zeroInit(Integer.parseInt(st.nextToken()));
				// 불러주는 수 받아와서 해당 위치 0으로 초기화
				
				if (idx >= 12) { //최소 12개부터 3개이상의 빙고가 나올 수 있다.
					int cnt = solve(); // solve함수에서 값 받아오기
					if (cnt >= 3) {
						System.out.println(idx);
						break outer;
					}
				}
			}
			
		}
	}
	static private void zeroInit(int num) { // 받아온 값과 같은 값 0으로 초기화
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(map[i][j] == num)
					map[i][j] = 0;
			}
		}
	}
	static private int solve() {
		int count = 0; // 빙고 개수를 뽑기 위한 변수
		int check = 0;
		int check2 = 0;
		for (int i = 0; i < 5; i++) { // 행, 열 빙고 판별
			check = 0;
			check2 = 0;
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 0) {// 행 체크 0이면 check++
					check++;
				}
				if (map[j][i] == 0) { // 열 체크 0이면 check2++
					check2++;
				}
			}
			if (check == 5) {	// check가 5일때 빙고 한줄
				count++;
			}
			if (check2 == 5) {// check2가 5일때 빙고 한줄
				count++;
			}
		}

		check = 0;
		check2 = 0;
		for (int i = 0; i < 5; i++) { //대각선
			if (map[i][i] == 0) // 좌-> 우로 가는 대각선 체크
				check++;
			if (map[i][4 - i] == 0) //우-> 좌로 가는 대각선 체크
				check2++;
		}
		if (check == 5)
			count++;
		if (check2 == 5)
			count++;
		return count;
	}
}
