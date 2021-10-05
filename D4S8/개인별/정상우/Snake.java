package study02;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Snake {

	static int res = 0;
	static List<int[]> curSnake;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] map = new int[N+1][N+1];

		int K = sc.nextInt();

		apple[] ap = new apple[K];
		curSnake = new LinkedList<>();
		curSnake.add(new int[] { 1, 1 });

		for (int i = 0; i < K; i++) { // 사과위치 받기
			ap[i] = new apple();
			ap[i].x = sc.nextInt();
			ap[i].y = sc.nextInt();
			map[ap[i].x ][ap[i].y] = 1;
		}

		int L = sc.nextInt();
		direction[] dir = new direction[L];

		for (int i = 0; i < L; i++) { // 방향이동 정보 받기
			dir[i] = new direction();
			dir[i].time = sc.nextInt();
			dir[i].pos = sc.next().charAt(0);
		}

		int curTime = 0;
		int curX = 1;
		int curY = 1;
		int curD = 0;
		int dr = 0;

		loop1: while (true) {


			int nextX = curX + di[curD];
			int nextY = curY + dj[curD];

//			System.out.println(nextX+" ," +nextY);
			//////////////////////////// 종료조건///////////////////////////
			if ((nextX < 1 || nextX >= N+1 || nextY < 1 || nextY >= N+1)) { // 맵을 나가면 종료
				System.out.println(++curTime);
				break;
			}
			for (int i = 0; i < curSnake.size(); i++) {// 몸통을 만나면 종료
				int[] s = curSnake.get(i); // 현재 뱀이 있는 위치중 하나라도 걸리면
//				System.out.println(s[0]+" "+s[1]);
				if (s[0] == nextX && s[1] == nextY) {
					System.out.println(++curTime);
					break loop1; // 종료시키자
				}
			}
			////////////////////////////////////////////////////////////////

			curX = nextX;
			curY = nextY;
			
			if (map[nextX][nextY] == 1) {// 사과가 존재할때
				curSnake.add(new int[] { nextX, nextY });
				
			} else {
				curSnake.add(new int[] { nextX, nextY });
				curSnake.remove(0); // 사과가 없으면 뒤에 꼬리부분 삭제
				// System.out.println(curSnake);
			}

			if (dr < L) { //방향 조정 부분 
				if (curTime+1 == dir[dr].time) {
					if (dir[dr].pos == 'L') {
						curD -= 1;
						if (curD == -1)
							curD = 3;

					}
					if (dir[dr].pos == 'D') {
						curD += 1;
						if (curD == 4)
							curD = 0;
					}
					dr++;
				}
			}
			curTime++;

		}



	}

}

class apple {

	int x;
	int y;

}

class direction {
	int time;
	char pos;

}