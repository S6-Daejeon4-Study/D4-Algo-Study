package hw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1697 {
	static int N, K;
	static int[] di = { -1, 1 };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();	
		
		bfs();
	}
	
	static void bfs() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[200001];

		queue.add(N);
		visited[N] = 0; // 현재 인덱스에 도착한 tree의 높이를 적어두기.. 
		
		if(N == K) {
			System.out.println(visited[N]);
			return;
		}
		
		outerloop: while (!queue.isEmpty()) {
			int val = queue.poll();

//			System.out.println("현재 값:" + val);
			for (int i = 0; i < 3; i++) {
				int nextVal = 0;
				if (i == 2) {
					nextVal = val * 2;
				} else {
					nextVal = val + di[i];
				}

				if (nextVal >= 0 && nextVal <= 200000 && visited[nextVal] == 0 && nextVal != N) { // 방문하지 않았고, 숫자가 범위를 벗어나지 않는다면..
					visited[nextVal] = visited[val] + 1; // 부모노드보다 +1시켜
					queue.add(nextVal);
//					System.out.println("다음 값 = " + nextVal + "  방문 시간 = " + visited[nextVal]);
				}
				if (visited[K] != 0) { // 동생 위치에 도착할 수 있는 최소 횟수가 적힌 경우
					System.out.println(visited[K]);
					return;
				}
			}
		}
	}

}
