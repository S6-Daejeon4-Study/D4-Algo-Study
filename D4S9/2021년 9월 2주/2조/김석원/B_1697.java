package day0915;

import java.util.Scanner;

public class B_1697 {
	static int[] arr;
	static void printarr() {
		for(int a : arr) {
			System.out.print("[ " + a + " ]");
		}System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//술래가 서있는 위치
		int N = sc.nextInt();
		//잡아야하는 사람이 서있는 위치
		int M = sc.nextInt();
		arr = new int[100000+4];
		int max_num = Integer.max(N, M);
		//술래가 서있는 위치 0으로 초기화
		arr[N] = 0;
		
		//술래보다 앞에있는 놈들 초기화
		for(int i = N - 1; i >= 0; i--) {
			arr[i] = arr[i+1] + 1;
		}// end i
		
		
		for(int i = N+1; i <= max_num + 1; i++) {
			int num = 0;
			//최소비교를 해야해서 최대값을 넣어준다.
			arr[i] = Integer.MAX_VALUE;
			
			num = arr[i-1] + 1;
			arr[i] = Integer.min(num, arr[i]);
			if( i % 2 == 0) { // 요거 했을때 왼쪽에가 +1보다 크면 바꿔줘야함
				num = arr[i/2] + 1;
			}
			arr[i] = Integer.min(arr[i], num);
			
			if(arr[i] != 0 && arr[i-1] > arr[i] + 1) { //왼쪽에가  내 값 +1보다 크면 바꿔줘야함
				arr[i-1] = arr[i] + 1;
			}
			
			
		}//end i
		//printarr();
		System.out.println(arr[M]);
		
		
	}
}
