package algo;

import java.util.Arrays;
import java.util.Scanner;

public class boj2309_브루트포스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);//정렬 먼저
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				//서로다른 i,j 구하기
				if(i!=j && sum-arr[i]-arr[j]==100) {
					//i,j 인덱스를 제외한 나머지 출력
					print(arr,i,j);
					System.exit(0);;
				}
			}
			
		}

	}

	private static void print(int[] arr, int idx1, int idx2) {
		for(int i=0;i<9;i++) {
			if(i!=idx1 && i!=idx2) System.out.println(arr[i]);
		}
		
	}

	
}
