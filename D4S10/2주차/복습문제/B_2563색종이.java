package week10_2;

import java.util.Arrays;
import java.util.Scanner;

public class 색종이 {
	private static int[][] board;

	public static void main(String[] args) {
		final int paper_length = 100;
		final int color_length = 10;
		Scanner sc = new Scanner(System.in);
		int totalcnt = 0;
		int n = sc.nextInt();
		board = new int [paper_length][paper_length];
		for(int idx = 0 ;idx < n; idx++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int i = x-1; i < x+9; i++) {
				for(int j = y-1; j < y+9; j++) {
					if(board[i][j] == 0) totalcnt++;
					board[i][j] = 1;
				}
			}
			
			
			
			
		}//end i
//		for(int[] a : board) {
//			for(int b : a) {
//				System.out.print(b + " ");
//			}
//			System.out.println();
//		}
		System.out.println(totalcnt);
	}
}
