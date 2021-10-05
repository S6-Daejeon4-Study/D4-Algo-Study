package week9_1;

import java.util.Scanner;

public class B_1182 {
	static int N;
	static int S;
	static int count;
	static int[] input;
	static boolean[] isUsed;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		count = 0;
		input = new int[N];
		isUsed = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		subset(0,0,0);
		System.out.println(count);
//		String test = "100";
//		System.out.println(Integer.parseInt(test));
		
	}
	private static void subset(int target, int cnt, int sum) {
		// TODO Auto-generated method stub
		if(cnt == N) {
			//System.out.println(sum);
			if(sum == S) {
				int check = 0;
				for(int i = 0; i < N; i++) {
					if(!isUsed[i]) check++;
				}
				if(check == N) return;
				count++;
			}
			return;
		}
		isUsed[target] = true;
		subset(target + 1, cnt  + 1, sum + input[target]);
		isUsed[target] = false;
		subset(target + 1, cnt + 1 , sum);
	}
}
