package algo;

import java.util.Arrays;
import java.util.Scanner;

public class boj2309_조합 {
	static int[] arr;
	static boolean[] check;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
		}///======>input end
		
		Arrays.sort(arr);//먼저 정렬해줌
		check = new boolean[9];
		comb(0,0);//현재 인덱스
	}
	private static void comb(int idx,int cnt) {
		if(cnt==2) {//제거할 두난쟁이 선택됨
			int sum = 0;
			for(int i=0;i<9;i++) {
				sum += arr[i];//제거가 안된 난쟁이들은 더해주고
				if(check[i]) {
					sum -= arr[i];//제거가된 난쟁이 두면 찾아서 빼줌
				}
			}
			if(!flag) {
				if(sum==100) {
					print();
					flag = true;
					
				}
				
			}
			return;
		}
		if(idx==9) return;
		
		if(!check[idx]) {
			check[idx] = true;//idx 번째 난쟁이가 선택됨
			comb(idx+1,cnt+1);
			check[idx] = false;//선택안됨
			comb(idx+1,cnt);
		}
	}
	private static void print() {
		for(int i=0;i<9;i++) {
			if(!check[i]) {
				System.out.println(arr[i]);
			}
		}
		
	}

}
