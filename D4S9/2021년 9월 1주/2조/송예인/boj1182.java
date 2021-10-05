package day0909;

import java.util.Scanner;

public class boj1182 {
static int N;
static int S;
static int[] arr;
static boolean[] check;
static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		// input end
		check = new boolean[N];
		
		subset(0);//현재 인덱스

		System.out.println(count);
	}

	//전형적인 부분집합 구하기 문제
	//각각의 인덱스에 대해 선택될 기화와, 선택 안될기회 모두 준다.
	//최종적으로 부분집합에 인덱스가 없는 경우를 제외하고 목적합인 S와 같다면 정 
	private static void subset(int idx) {
		if(idx == N) {
			int total = 0;
			boolean notallfalse = false;
			for(int n=0;n<N;n++) {
				if(check[n]) {
					total += arr[n];
					notallfalse = true;
				}
			}
			if(total == S && notallfalse) count++; 
			return;
		}
		
		if(!check[idx]) {
			check[idx] = true;
			subset(idx+1);
			check[idx] = false;
			subset(idx+1);
		}
	}

}
