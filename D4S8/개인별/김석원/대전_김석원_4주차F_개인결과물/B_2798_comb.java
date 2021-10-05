package baekjoon_Easy;

import java.util.Scanner;

public class B_2798_comb {
	static int N;
	static int M;
	static int max;
	static int[] numbers;
	static int[] cards;
	public static void main(String[] args) {
		//N개의 번호를 입력받아 3개를 선택해(조합) 그 합이 M과 작거나 같은 수중 최대값을 출력하는 문제.
		Scanner sc = new Scanner(System.in);
		//카드갯수 인풋
		N = sc.nextInt();
		//블랙잭의 목표수 원래 21일이지만 이 문제에서는 임의의 M
		M = sc.nextInt();
		//max값 초기화
		max = 0;
		//카드 초기화
		cards = new int[N];
		numbers = new int[3];
		//N개의 카드 인풋
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}//end input
		comb(0,0);
		System.out.println(max);
	}
	/**
	 * nC3을 수행하는 함수. numbers배열에 뽑은 수를 저장한다.
	 * @param target : 대입할 수
	 * @param cnt : 대입할 인덱스
	 */
	static void comb(int target,int cnt) {
		if(cnt == 3) {
			calc();
			return;
		}
		if(target == N) return;
		numbers[cnt] = cards[target];
		comb(target+1,cnt+1);
		comb(target+1,cnt);
	}
	
	/**
	 * 완성된 numbers배열을 모두 더해서 M보다 작거나 같을때 최대값을 대입하는 함수
	 */
	static void calc() {
		int sum = numbers[0] + numbers[1] + numbers[2];
		if(sum <= M && max < sum) {
			max = sum;
//			System.out.println(max);
		}
	}
	
}
