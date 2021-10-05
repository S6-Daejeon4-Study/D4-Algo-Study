package com.study.week04;

import java.util.Scanner;

public class Main_10158_개미 {

	static int[] dw = { 1, 1, -1, -1 }; // 오른쪽 위, 오른쪽 아래, 왼쪽 아래, 왼쪽 위
	static int[] dh = { 1, -1, -1, 1 }; // 오른쪽 위, 오른쪽 아래, 왼쪽 아래, 왼쪽 위
	static int w, h, t; // 입력되는 가로, 세로 범위, 시간

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		int width = sc.nextInt(); // 개미의 처음 가로 위치
		int height = sc.nextInt(); // 개미의 처음 세로 위치
		t = sc.nextInt();
		// 입력 끝

		int cnt = 0;
		int dir = 0;

		while (cnt < t) {

			if (!possible(width + dw[dir], height + dh[dir])) { // 가능하지 않은 경우
				
				int tmpDir1=(dir+1)%4; // 오른쪽 90도
				int tmpDir2=(dir-1)==-1?3:(dir-1); // 왼쪽 90도. -1일 경우는 3으로 바꿔줌
				int tmpDir3=(dir+2)%4; // 반대 방향
				
				if(possible(width+dw[tmpDir1], height+dh[tmpDir1])) {
					dir=tmpDir1;
				}
				else if(possible(width+dw[tmpDir2], height+dh[tmpDir2])) {
					dir=tmpDir2;
				}
				else if(possible(width+dw[tmpDir3], height+dh[tmpDir3])) {
					dir=tmpDir3;
				}
			}
			
			width = width + dw[dir];
			height = height + dh[dir];
			
			cnt++;
		}// end while
		System.out.println(width+" "+height);
	}

	// 가로와 세로가 범위 안인지 검사
	// 다음 자리가 이동 가능한지 검사하기 위해
	static boolean possible(int width, int height) {
		
		if (width < 0 || width > w || height < 0 || height > h) return false;
		return true;
	}
}