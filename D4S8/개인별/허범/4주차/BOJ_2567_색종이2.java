package im_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567_색종이2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//배열 탐색을 위한 델타배열
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int N = Integer.parseInt(br.readLine());
		int ans = 0;

		int[][] map = new int[101][101];//사각형을 입력받아서 기록할 배열

		for (int i = 0; i < N; i++) {//사각형 개수 만큼 반복하면서 입력받음.
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {//사각형을 입력받아서 1로 채움.
				for (int k = y; k < y + 10; k++) {
					map[j][k] = 1;
				}
			}
		}

		for (int i = 1; i <= 100; i++) {//전체를 탐색하면서
			for (int j = 1; j <= 100; j++) {
				if (map[i][j] == 1) {//사각형을 만나면
					for(int dir = 0; dir < 4; dir++) {//4방향 탐색해서 
						int x = i + dx[dir];
						int y = j + dy[dir];
						
						if(map[x][y] == 0)//경계선이면
							ans++;//둘레 1씩 증가.
					}
				}
			}
		}
		System.out.println(ans);
	}
}
