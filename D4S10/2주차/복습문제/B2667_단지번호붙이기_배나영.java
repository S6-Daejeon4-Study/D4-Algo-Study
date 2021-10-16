package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class B2667_단지번호붙이기 {
	
	static int N;
	static char[][] map;
	
	static int[] di= {1,0,-1,0};
	static int[] dj= {0,1,0,-1};
	
	static int num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		ArrayList<Integer> list=new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		// map을 돌면서 1인 것은 방문해줌
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='1') {
					num=0;
					DFS(i, j); // 자기 자신이 1
					list.add(num);
				}
			}
		}
		
		System.out.println(list.size());
		list.sort(Comparator.naturalOrder());
		
		for(int l: list) {
			System.out.println(l);
		}
	}

	static void DFS(int i, int j) {
		
		// 방문
		map[i][j]='2';
		num++; 
		
		for(int dir=0;dir<4;dir++) {
			int ni=i+di[dir];
			int nj=j+dj[dir];
			
			if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj]=='1') {
				DFS(ni, nj);
			}
		}
	}// end DFS
}
