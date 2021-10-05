package com.ssafy.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author comkkyu
 * @date 21. 8. 17
 * 
 * 백준 17827 - 달팽이 리스트
 * https://www.acmicpc.net/problem/17827
 *
 */
public class B17827_ArrayList {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int m = 0; m < M; m++) {
			int k = Integer.parseInt(br.readLine());
			
			sb.append(list.get(where(N, k, V))+"\n");
		}
		
		System.out.println(sb);
	}
	
	/**
	 * cycle 까지 계산해 실제 노드 위치를 반환하는 메서드
	 * 
	 * @param n 노드 개수
	 * @param k 이동 횟수
	 * @param v n 번 노드가 가리키는 번호
	 * @return k 번 이동한 노드의 인덱스 번호
	 */
	private static int where(int n, int k, int v) {
		if (k < n) return k; // cycle 진입 전에는 노드번호 반환
		if (v == n) return n - 1; // 민달팽이 리스트
		
		return where(n, k - (n - v + 1), v); // 생성되는 cycle의 크기 : n - v + 1
//		return (k - v + 1) % (n - v + 1) + (v - 1);
	}

}
