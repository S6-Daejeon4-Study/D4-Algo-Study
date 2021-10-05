package day0825;

import java.util.Scanner;

public class BOJ_2578 {
	static int[][] map;
	static boolean[][] check;
	static int num, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//빙고 숫자 입력 배열
		map = new int[5][5];
		//숫자 체크됐는지 확인하는 배열
		check = new boolean[5][5];
		//input
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//input end
		//사회자가 번호 25개 부를동안
		for(int k=0; k<25; k++) {
			//사회자가 부른 번호 저장
			num = sc.nextInt();
			//번호 부를때마다 번호부른횟수 1 증가 (0 초기값)
			cnt++;
			//배열탐색
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					//배열에 저장된 숫자가 사회자가 부른 번호와 같으면
					if (map[i][j] == num)
						//체크
						check[i][j] = true;
					//빙고 3번 외쳤으면
					if(bingo(i,j)) {
						//번호 부른 횟수 출력
						System.out.println(cnt);
						return;
					}
				}
			}
		}
	}
	//빙고 판별하는 메서드
	static boolean bingo(int n, int k) {
		//빙고 횟수
		int bingo=0;
		//가로 빙고 판별
		for(int i=0; i<5; i++) {
			int icnt=0;
			for(int j=0; j<5; j++) {
				if(check[i][j]) {
					//가로방향으로 가면서 숫자가 체크되어있으면 숫자증가 
					icnt++;
				}
			}
			//5개가 다 체크되어있으면
			if(icnt==5)
				//빙고
				bingo++;
		}
		//세로 빙고 판별
		for(int i=0; i<5; i++) {
			int jcnt=0;
			for(int j=0; j<5; j++) {
				if(check[j][i]) {
					jcnt++;
				}
			}
			if(jcnt==5)
				bingo++;
		}
		//좌상 대각선 빙고 판별
		int xcnt=0;
		for(int i=4; i>=0; i--) {
			if(check[4-i][i]) {
				xcnt++;
			}
			if(xcnt==5) {
				bingo++;
			}
		}
		//우하 대각선 빙고 판별
		int ycnt=0;
		for(int i=0; i<4; i++) {
			if(check[i][i]) {
				ycnt++;
			}
			if(ycnt==5) {
				bingo++;
			}
		}
		//빙고 3번 외치면
		if(bingo>=3) return true;
		else return false;
	}
}
