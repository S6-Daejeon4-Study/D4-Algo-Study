package com.study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀 문제
public class Main3190 {

	static int[][] map;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		int appleNum=Integer.parseInt(br.readLine());
		
		for(int i=0;i<appleNum;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int appleX=Integer.parseInt(st.nextToken());
			int appleY=Integer.parseInt(st.nextToken());
			
			map[appleX][appleY]=2;
		}
		
		int numDir=Integer.parseInt(br.readLine());
		Queue<Direction> queue=new LinkedList<Direction>();
		Queue<Integer> dirQueue=new LinkedList<>();
		
		for(int i=0;i<numDir;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int a=Integer.parseInt(st.nextToken());
			char b=st.nextToken().charAt(0);
			queue.offer(new Direction(a,b));
		}
		
		// 입력 끝
		
		// 뱀 머리와 꼬리의 위치
		int headX=1;
		int headY=1;
		int tailX=1;
		int tailY=1;
		int dir=0;
		
		map[headX][headY]=1;
		int cnt=1;
		
		while(true) {
			
			headX+=dx[dir];
			headY+=dy[dir];
			
			if(headX<=0||headY<=0||headX>N||headY>N) {
				break;
			} 
			else if(map[headX][headY]==1) {
				break;
			}
			else if(map[headX][headY]==2) {
				map[headX][headY]=1;
			} 
			else if(map[headX][headY]==0) {
				map[tailX][tailY]=0;
				int pastDir=0;
				
				if(!dirQueue.isEmpty()) 
					pastDir=dirQueue.poll();
				
				tailX+=dx[pastDir];
				tailY+=dy[pastDir];
			} 
			
			map[headX][headY]=1;
			dirQueue.offer(dir);
			
			if((!queue.isEmpty())&&cnt==queue.peek().count) {
				switch(queue.poll().direction) {
				case 'L':
					dir=dir-1;
					if(dir==-1) dir=3;
					break;
				case 'D':
					dir=(dir+1)%4;
					break;
				}
			} 
			
			cnt++;
		} // end while
		
		System.out.println(cnt);
	}
	
	static class Direction{
		int count;
		char direction;
		
		public Direction(int count, char direction) {
			this.count=count;
			this.direction=direction;
		}
	}
	
	static void print() {
		for(int i=1;i<map.length;i++) {
			for(int j=1;j<map[0].length;j++) {
				if(map[i][j]==2) System.out.print("* ");
				else System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
}
