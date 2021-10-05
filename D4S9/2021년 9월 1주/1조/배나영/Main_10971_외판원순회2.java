package com.study.week05;

import java.util.Scanner;

public class Main_10971_외판원순회2 {

	static boolean[] visited; // 방문한 도시
	static int[][] map; // 가중치? 비용 저장 배열
	static int N;
	static int minCost = Integer.MAX_VALUE; // 최소 비용
	static int first; // 제일 처음 방문한 도시

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			first = i;			
			visited = new boolean[N];
			visitCity(i, 0);
		}
		System.out.println(minCost);
	}

	static void visitCity(int current, int cost) {
		// current: 현재 위치
		// cost: 지금까지 드는 비용
		visited[current]=true;

		// 최소 경로를 구하는 것이기 때문에 경로값의 합이 minCost보다 커지면 더 이상 세지 않음
		if (cost > minCost) {
			visited[current]=false;
			return;
		}

		// 방문 안 한 도시가 있을 경우 isAllVisited에 false 저장
		boolean isAllVisited = true;
		
		for (int i = 0; i < N; i++) {
			if (!visited[i])
				isAllVisited = false;
		}

		// 모두 방문했다면
		if (isAllVisited) {
			if (map[current][first] != 0) { // 맨 처음으로 되돌아올 수 있는지 체크
				cost += map[current][first]; // 맨 처음으로 되돌아오는 값 경로에 추가
				
				if(cost<minCost) {
					minCost=cost;
				}
			}
			visited[current]=false;
			return;
		}// end isAllVisited check
		
		
		for(int i=0;i<N;i++) {
			if(!visited[i] && map[current][i]!=0) { // 아직 방문하지 않았고 방문 가능한 곳이 있다면
				visitCity(i, cost+map[current][i]); // 방문함
				visited[i]=false;
			}
			
		}
	}
}
