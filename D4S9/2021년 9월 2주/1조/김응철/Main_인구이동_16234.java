package bfs;

import java.io.*;
import java.util.*;

public class Main_인구이동_16234 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input

		int[] di = { -1, 1, 0, 0 };
		int[] dj = { 0, 0, -1, 1 };
		int day = 0;
		while (true) {
			
			boolean[][] visit = new boolean[N][N];
			int flag = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visit[i][j] ==true)	continue;
					
					Queue<Country> queue = new LinkedList<>();
					ArrayList<Country> unionCountry = new ArrayList<Country>(); //합쳐진 나라들의 index만 따로 저장해놓을 Country배열
					queue.offer(new Country(i, j));
					visit[i][j] = true;
					unionCountry.add(new Country(i,j));
					int sum = map[i][j],cnt = 1,average = 0;// 나라인구수 합, 나라 수 초기화.
					while (!queue.isEmpty()) {
						Country now = queue.poll();
						
						for (int d = 0; d < 4; d++) {

							int ni = now.i + di[d];
							int nj = now.j + dj[d];

							if (ni < 0 || ni >= N || nj < 0 || nj >= N || visit[ni][nj])
								continue;

							if (Math.abs(map[ni][nj] - map[now.i][now.j]) >= L
									&& Math.abs(map[ni][nj] - map[now.i][now.j]) <= R) {// 두 나라의 차이가 L~R 사이면 visit
								queue.offer(new Country(ni, nj));
								visit[ni][nj] = true;
								cnt++;
								unionCountry.add(new Country(ni,nj));
								sum += map[ni][nj];
								flag++;
							}
						}//for d
					}//queue.while
					if(cnt == 1 && sum == map[i][j]) continue;//상하좌우 아무것도 없으면 밑에 for문 안돌고 바로 continue
					
					average = sum/cnt;
					for(Country node:unionCountry) {//합쳐진 나라들의 인덱스만 저장해놓은 배열을 따라서 
						map[node.i][node.j] = average;//배열의 인덱스에 저장된 나라들만 평균값을 준다.
					}
				}//for j

			}//for i
			
			if (flag == 0)//for문 2개 다 돌았는데도 flag에 변화가 없으면 모두 L~R사이에 차이가 없다는 의미이므로 break
				break;
			day++;//for문 다돌면 하루 지난거
			
		} // while
		
		System.out.println(day);

	}

	static class Country {
		int i, j;

		public Country(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}

}
