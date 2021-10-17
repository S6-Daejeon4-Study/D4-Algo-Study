package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준15662_톱니바퀴2 {
	static int T, magneticInfo[][], rotateInfo[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		magneticInfo = new int[T][8];
		for (int i = 0; i < T; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++)
				magneticInfo[i][j] = tmp[j] - '0'; // 입력완료
		}
		int K = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < K; k++) {
			rotateInfo = new int[T]; // 회전방향(시계/반시계/회전안함)
			 String[] tmp = br.readLine().split(" ");
			check(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
			for (int r = 0; r < T; r++)
				rotate(r, rotateInfo[r]);
		}
		int ans = 0;
		for (int i = 0; i < T; i++)
			ans += (magneticInfo[i][0] == 1) ? 1 : 0;
		System.out.println(ans);
	}

	// 모든 바퀴같고 다름을 체크해서 다르고 회전이 가능하면 회전시켜주기
	//
	private static void check(int num, int dir) {
		rotateInfo[num - 1] = dir;
		if (num == 1) {
			for (int i = 0; i < T - 1; i++) {
				if (magneticInfo[i][2] != magneticInfo[i + 1][6]) {
					rotateInfo[i + 1] = -1 * rotateInfo[i];
				} else
					return;
			}
		}
		if (num == T) {
			for (int i = T - 1; i > 0; i--) {
				if (magneticInfo[i][6] != magneticInfo[i - 1][2]) {
					rotateInfo[i - 1] = -1 * rotateInfo[i];
				} else
					return;
			}
		}
		for (int i = num - 1; i > 0; i--) {
			if (magneticInfo[i][6] != magneticInfo[i - 1][2]) {
				rotateInfo[i - 1] = -1 * rotateInfo[i];
			} else
				break;
		}
		for (int i = num - 1; i < T - 1; i++) {
			if (magneticInfo[i][2] != magneticInfo[i + 1][6]) {
				rotateInfo[i + 1] = -1 * rotateInfo[i];
			} else
				break;
		}
	}

	private static void rotate(int num, int dir) {
		if (dir == 1) { // 시계방향
			int last = magneticInfo[num][7];
			for (int i = 6; i >= 0; i--)
				magneticInfo[num][i + 1] = magneticInfo[num][i];
			magneticInfo[num][0] = last;
		} else if (dir == -1) {// 반시계 방향
			int start = magneticInfo[num][0];
			for (int i = 0; i < 7; i++)
				magneticInfo[num][i] = magneticInfo[num][i + 1];
			magneticInfo[num][7] = start;
		} else {
			// System.out.println("잘못된 숫자는 " + dir + "입니다. 1과 -1만 허용가능합니다.");
		}

	}

}
