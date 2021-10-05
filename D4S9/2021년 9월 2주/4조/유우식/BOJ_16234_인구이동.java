package day0916;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//국가 위치를 기록할 객체
class Country {
	int n;
	int m;

	public Country(int n, int m) {
		this.n = n;
		this.m = m;
	}
}

public class BOJ_16234_인구이동 {
	static int[][] map;
	static int N, L, R;
	static boolean[][] visited;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	static Queue<Country> que;
	static List<Country> union;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		//국가
		map = new int[N][N];
		que = new LinkedList<>();
		union = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(Move());
	}
	//인구이동 함수
	static int Move() {
		//인구이동 할 때 걸리는 시간
		int cnt=0;
		//인구이동을 할 수 있는지 판단
		boolean isMove = false;
		
		while(true) {
			//국가 방문 배열
			visited = new boolean[N][N];
			isMove= false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//방문했으면 패스
					if(visited[i][j]) continue;
					//국경선을 열 수 있으면, 인구이동 가능
					if(open(i,j)) isMove=true;
				}
			}
			//인구이동이 가능하면 인구이동하는데 걸리는 시간 증가
			if(isMove) cnt++;
			else return cnt;
			
		}
		
	}
	//국경선 열기
	static boolean open(int n, int m) {
		que.clear();
		union.clear();
		//현재 위치 넣기
		que.offer(new Country(n, m));
		//현재위치 연합에 넣기
		union.add(new Country(n,m));
		//방문체크
		visited[n][m] = true;
		//인구수
		int pop = map[n][m];
		
		
		while(!que.isEmpty()) {
			Country c = que.poll();
			//4방향 탐색
			for(int i=0; i<4; i++) {
				int ni = c.n + di[i];
				int nj = c.m + dj[i];
				//범위에 벗어나거나 방문했으면
				if(ni<0 || ni>=N || nj<0 || nj>=N || visited[ni][nj]) continue;
				//인구차이
				int popdiff = Math.abs(map[ni][nj] - map[c.n][c.m]);
				//인구차이가 인구이동 가능한 범위 내에 없으면 패스
				if(popdiff<L || popdiff>R) continue;
				//인구이동이 가능하면, 인구이동이 가능한 국가의 인구수 더하기
				pop += map[ni][nj];
				//다음 국가 넣기
				que.offer(new Country(ni,nj));
				//연합에 인구이동 가능한 국가 넣기
				union.add(new Country(ni,nj));
				//방문체크
				visited[ni][nj] = true;
			}
		}
		//처음 국가를 제외하고 연합이 없으면 false 반환
		if(union.size()==1) return false;
		
		else {
			//인구수를 연합 국가의 개수만큼 나누기
			int tmp = pop / union.size();
			//연합 내 국가들에 대해서 인구수 반영
			for(Country c : union) {
				map[c.n][c.m] = tmp;
			}
			//인구이동이 가능하므로 true 반환
			return true;
		}
		
		/*
		 * 인구이동을 할 때 인구수를 연합 마다 일정하게 나누는게 결과에 영향이 미치는지 궁금해졌고,
		 * 결과에 영향이 없다면 굳이 인구수를 나눌 필요가 있을 까 고민을 해보고 다시 풀어보았지만,
		 * 연합에 따라 인구수를 나누지 않으면 시간초과가 떠서 엄청 큰 영향을 주었다.
		 */
		
	}
}




