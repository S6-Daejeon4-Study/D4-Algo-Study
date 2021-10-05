import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2578 {

	static int[][] map;
	static Queue<Integer> numList = new LinkedList<Integer>();
	static	int bingoCnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		map = new int[5][5];
		for (int i = 0; i < 5; i++) { // 맵채우기
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		} //맵 입력 종료

		for (int j = 0; j < 25; j++) { // 사회자가 부르는 넘버 입력 받기
			numList.add(sc.nextInt());
		}
		
		int cnt = 0;
		boolean flag = true;

		while (flag) { // 사회자가 부르는 넘버를 찾아 해당 맵위치 값을 0으로 설정
			int num = numList.poll();
			++cnt; // 빙고 카운트 세기
			
			outerloop: for (int i = 0; i < 5; i++) { // 해당 맵을 통해 사회자가 부른 입력값 찾기
				for (int j = 0; j < 5; j++) {
					if (num != map[i][j]) // 사회자가 부른 값과 맵의 값이 다르면 패스
						continue;
					map[i][j] = 0; // 사회자가 부른 값과 맵의 값이 일치한다면 해당 값을 0으로 설정
					if (check(i, j)) { // 해당 위치의 정보를 전해주고, 현재 맵이 빙고인지 여부를 반환
						flag = false; // 3줄 빙고가 완성되면 true가 되어 while문을 빠져 나감.
						break outerloop;
					}

				}
			} // outerloop 종료
		}
		System.out.println(cnt);
	}

	static boolean check(int i, int j) {
		// 가로 빙고 판단
		for (int m = 0; m < 5; m++) {
			if (map[i][m] != 0)
				break;
			if (m == 4) {
//				System.out.println("가로 빙고");
				bingoCnt++;
			}
		}

		// 세로 빙고 판단
		for (int m = 0; m < 5; m++) {
			if (map[m][j] != 0)
				break;
			if (m == 4) {
//				System.out.println("세로 빙고");
				bingoCnt++;
			}
		}

		if (i == j) {
			for (int k = 0; k < 5; k++) {
				if (map[k][k] != 0)
					break;
				if (k == 4) {
//					System.out.println("왼쪽 대각선 빙고");
					bingoCnt++;
				}
			}
		}

		if (i + j == 4) {
			for (int n = 0; n < 5; n++) {
				int m = 4 - n;
				if (map[n][m] != 0)
					break;
				if (n == 4) {
//					System.out.println("오른쪽 대각선 빙고");
					bingoCnt++;
				}
			}
		}

//		System.out.println("빙고카운트:  " + bingoCnt);
		if (bingoCnt >= 3)
			return true;
		else
			return false;
	}

	static void print() { // 맵출력 함수
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
	}
}
