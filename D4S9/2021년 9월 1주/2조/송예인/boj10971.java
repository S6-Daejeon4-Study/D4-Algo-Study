package day0909;

import java.util.Scanner;

public class boj10971 {
	static int N;
	static int[][] map;//양측 간선비용 저장
	static boolean[] check;//선택한 정점인지 확인
	static int[] dis;
	static int result;//최소거리

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		check = new boolean[N+1];
		dis = new int[N+1];
		for(int n=1;n<=N;n++) {
			for(int m=1;m<=N;m++) {
				map[n][m] = sc.nextInt();
			}
			dis[n] = Integer.MAX_VALUE;
		}
		// input end
		// 시작점 1로 설정
		// 시작점으로 다시 돌아와야 하기에 check true 는 안해줌
		
		result = Integer.MAX_VALUE;
		dis[1] = 0;
		check[1] = true;
		dfs(1,1,0);
		
		
		System.out.println(result);
		

	}

	//
	private static void dfs(int idx, int count, int price){
		if(count==N) {
			if(map[idx][1]==0) return;//마지막 점과 출발점이 연결되어 있지 않은경우
			result = result<price+map[idx][1]?result:price+map[idx][1];
			return;
		}
		
		//현재 idx에서 인접노드들 dfs 돌리기
		for(int i=1;i<=N;i++) {
			if(map[idx][i]!=0 && !check[i]) {
				check[i] = true;
				int origin = dis[i];
				dis[i] = dis[idx]+map[idx][i];
				dfs(i,count+1,dis[i]);
				check[i] = false;
				dis[i] = origin;
			}
		}
		
	}

}
