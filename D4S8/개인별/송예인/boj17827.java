package algo;

import java.util.Scanner;

public class boj17827 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		int[] arr = new int[N];
		for(int n=0;n<N;n++) {
			arr[n] = sc.nextInt();
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int m=0;m<M;m++) {
			int jump = sc.nextInt();
			if(jump>=N) {
				int tmp = ((jump-N)%(N-V+1))+(V-1);
				sb.append(arr[tmp]+"\n");
				//System.out.println(arr[tmp]);
			}else {
				sb.append(arr[jump]+"\n");
				//System.out.println(arr[jump]);				
			}
		}
		System.out.println(sb.toString());
	}
}