package day0819;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1021 {
	static LinkedList<Integer> list;
	static int N, M;

	public static void main(String[] args) {
		list = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		// 리스트 크기
		N = sc.nextInt();
		// 뽑을 숫자 횟수
		M = sc.nextInt();
		// 리스트의 원소 위치 저장할 배열
		int[] loc = new int[M];
		// 리스트에 아무거나 집어넣기
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		for (int i = 0; i < M; i++) {
			loc[i] = sc.nextInt();
		}

		// 순서 찾을 횟수만큼 반복
		for (int i = 0; i < M; i++) {
			//loc 배열에 저장된 숫자의 인덱스를 반환 
			//(횟수를 반복할 수록 리스트의 크기가 변해서 인덱스의 값이 변하므로 내가 찾고싶은 값의 인덱스 반환) 
			int target_idx = list.indexOf(loc[i]);
			int half_idx;
			if (list.size() % 2 == 0) {
				half_idx = list.size() / 2 - 1;

			} else {
				half_idx = list.size() / 2;
			}
			// 원소의 위치가 리스트의 크기의 반보다 작으면
			// 2번연산 ㄱㄱ
			if (target_idx <= half_idx) {
				// 기존의 원소 위치의 값을 임시 저장
				for (int j = 0; j < target_idx; j++) {
					leftspin();
					cnt++;
				}
			}
			// 원소의 위치가 리스트의 크기의 반보다 크면
			// 3번연산 ㄱㄱ
			else {
				for (int j = 0; j < list.size() - target_idx; j++) {
					rightspin();
					cnt++;
				}

			}
			// 연산 후 첫번째 원소 빼기
			list.pollFirst();

		}

		System.out.println(cnt);

	}

	// 2번 연산
	static void leftspin() {
		// 첫번째 원소 저장 및 삭제
		int first = list.pollFirst();
		// 첫번째 원소 마지막 위치에 삽입
		list.addLast(first);
	}

	// 3번 연산
	static void rightspin() {
		// 마지막 원소 저장 및 삭제
		int last = list.pollLast();
		// 마지막원소 첫번째 삽입
		list.addFirst(last);

	}

}
