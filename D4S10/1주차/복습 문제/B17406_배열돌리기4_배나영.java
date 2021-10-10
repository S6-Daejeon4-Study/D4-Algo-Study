package com.study.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {

	static int N, M, K; // 가로, 세로, 회전연산
	static int[][] map; // 주어진 배열
	static int result; // 결과값: 배열의 값의 최솟값
	
	// 델타: 아래, 오른쪽, 위, 왼쪽
	static int[] di= {1,0,-1,0};
	static int[] dj= {0,1,0,-1};

	static boolean[] visited; // 회전 연산 방문 여부 
	static Point[] op; // 주어진 회전 연산->순열로 풀기 
	
	public static void main(String[] args) throws IOException {
		
		// 입력 시작 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map=new int[N+1][M+1];
		op=new Point[K];
		visited=new boolean[K];
		result=Integer.MAX_VALUE;
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			
			for(int j=1;j<=M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			
			op[i]=new Point(r, c, s); // 연산에 넣어주기
		}
		// 입력 끝
		
		perm(0,0,map);
		System.out.println(result);
		
	}
	
	// 디버깅용 프린트
	private static void print() {
		
		System.out.println("");
		for(int i=1;i<map.length;i++) {
			for(int j=1;j<map[0].length;j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}

	// 순열 
	private static void perm(int cnt, int idx, int[][] map) {
		
		if(cnt==K) { // 순열 다 만듦
			
			// 배열값 계산하기 
			for(int i=1;i<=N;i++) {  
				int hap=0;
				for(int j=1;j<=M;j++) { // 매 행마다 합 계산 
					hap+=map[i][j];
				}
				result=Math.min(hap, result);
			}
		}
		
		if(idx>=K) return; // 순열 안 만들었는데 인덱스 벗어나면 리턴
		
		for(int i=0;i<K;i++) {
			if(!visited[i]) { // 방문하지 않았다면
				visited[i]=true;
				perm(cnt+1, idx+1, rotate(op[i].r, op[i].c, op[i].s, map));
				visited[i]=false;
				perm(cnt, idx+1, map); 
			}
		}
		
	}
	
	// 회전시키는 메소드
	private static int[][] rotate(int r, int c, int s, int[][] map) {
		
		// 시작하는 i,j와 끝나는 i,j 초기화
		int starti=r-s;
		int startj=c-s;
		int endi=r+s;
		int endj=c+s;
		
		while(s-->0) { // 회전 시작 
			
			int i=starti;
			int j=startj;
			int tmp=map[starti][startj]; 
			int dir=0; // 시작할 때에는 아래방향
			
			while(true) { // 바깥 하나만 돌리기
				int ni=i+di[dir];
				int nj=j+dj[dir];
				
				// ni와 nj가 배열 범위 안일 때
				if(ni>=starti && nj>=startj && ni<=endi && nj<=endj) {
					map[i][j]=map[ni][nj]; // 다음 배열 위치를 끌어옴
					i=ni;
					j=nj;
				}
				else {
					dir++; 
				}
				
				if(i==starti && j==startj+1) break;
			}
			map[starti][startj+1]=tmp;
			
			starti++;
			startj++;
			endi--;
			endj--; // 안쪽 rotate 돌아줘야 하기 때문에 
			
		}// end for starti
		
		return map;
	}
	
	static class Point {
		int r;
		int c;
		int s;
		
		public Point(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
