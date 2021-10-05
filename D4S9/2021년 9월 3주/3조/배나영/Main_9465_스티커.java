package com.study.week07.DP;

import java.util.Scanner;

public class Main_9465_스티커 {
	
	static int n;
	static int[][] sticker;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt(); 
		
		for(int tc=0;tc<TC;tc++) {
			// 입력 시작
			n=sc.nextInt();
			sticker=new int[2][n];
			
			for(int i=0;i<2;i++) {
				for(int j=0;j<n;j++) {
					sticker[i][j]=sc.nextInt();
				}
			}
			// 입력 끝
			
			for(int i=1;i<n;i++) {
				
				// 0행-자기 자신이 포함되는 경우: 자기자신+앞 열에서 가능한 값
				int include=sticker[0][i]+sticker[1][i-1];
				
				// 0행-자기 자신이 포함되지 않는 경우 : 자신의 앞 열 두개 중에서 더 큰 것 자유롭게 선택
				int exclude=Math.max(sticker[0][i-1], sticker[1][i-1]);
				
				// 자기 자신을 포함하는 경우랑 포함하지 않는 경우 중 더 큰 것 선택함
				sticker[0][i]=(include>exclude)?include:exclude;
				
				// 1행-자기 자신이 포함되는 경우: 자기자신+앞 열에서 가능한 값
				include=sticker[1][i]+sticker[0][i-1];
				
				// 1행-자기 자신이 포함되지 않는 경우: 앞의 exclude와 같음
				
				// 자기 자신을 포함하는 경우랑 포함하지 않는 경우 중 더 큰 것 선택함
				sticker[1][i]=(include>exclude)?include:exclude;
			}
			
			System.out.println(Math.max(sticker[0][n-1], sticker[1][n-1]));
		}
		
		
	}

}
