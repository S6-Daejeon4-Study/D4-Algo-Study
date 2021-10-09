package month10.study.week1;

import java.util.Scanner;

public class SWEA_햄버거다이어트 {
	static int T,N,L,max;
	static Node[] arr;
	static boolean[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			max = Integer.MIN_VALUE;
			arr = new Node[N];
			check = new boolean[N];
			
			for(int i=0;i<N;i++) {
				arr[i] = new Node(sc.nextInt(), sc.nextInt());
			}
			// 입력 완료
			
			/* 로직 시작 */
			comb(0);
			
			System.out.println("#" + tc + " " + max);
		}
	}
	
	private static void comb(int target) {
		if(target == N) {
			int sum = 0;
			int kSum = 0;
			boolean isOver = false;
			for(int i=0;i<N;i++) {
				if(check[i]) {
					sum += arr[i].score;
					kSum += arr[i].k;
					if(kSum > L) {
						isOver = true;
						break;
					}
				}
			}
			if(!isOver) {
				max = Math.max(max, sum);
			}
			
			return;
		}
		
		check[target] = true;
		comb(target+1);
		check[target] = false;
		comb(target+1);
	}

	private static class Node{
		int score;
		int k;
		
		public Node(int score, int k) {
			super();
			this.score = score;
			this.k = k;
		}
	}
}
