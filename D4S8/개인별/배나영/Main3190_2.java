package com.study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀 문제 다시 시도
public class Main3190_2 {

	static int[][] map; // 지도
	static int[] dx= {0, 1, 0, -1}; // x좌표 방향 
	static int[] dy= {1, 0, -1, 0}; // y좌표 방향
	static int dir; // 현재 방향
	static int cnt; // 초 수
	static int headX; // 뱀의 머리 x좌표
	static int headY; // 뱀의 머리 y좌표
	static int tailX; // 뱀의 꼬리 x좌표
	static int tailY; // 뱀의 꼬리 y좌표
	static int commandIdx; // 방향 전환 명령 인덱스
	static int[] commandNum; // 방향 전환 명령 초
	static char[] commandChar; // 방향 전환 명령을 나타내는 문자형
	static Queue<Integer> moveRecord; // 현재까지 이동한 경로 저장 - tail 이동시킬 때 쓰려고
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입력 시작
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
		commandNum=new int[numDir];
		commandChar=new char[numDir];
		
		for(int i=0;i<numDir;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			commandNum[i]=Integer.parseInt(st.nextToken());
			commandChar[i]=st.nextToken().charAt(0);
		}
		// 입력 끝
		
		cnt=1;
		headX=1;
		headY=1;
		tailX=1;
		tailY=1;
		dir=0;
		commandIdx=0;
		moveRecord=new LinkedList<>();
		map[headX][headY]=1;
		moveRecord.offer(dir);
		
		while(true) {
			headX+=dx[dir];
			headY+=dy[dir];
			
			if(headX<=0||headX>=map.length||headY<=0||headY>=map[0].length) {
				break; // 머리가 지도를 벗어난 경우
			}
			
			if(map[headX][headY]==1) { // 머리가 뱀의 몸을 만난 경우
				break;
			}
			
			if(map[headX][headY]==0) { // 사과가 없는 경우 tail을 이동시켜야 함 
				map[tailX][tailY]=0;				
				int move=moveRecord.poll();
				tailX+=dx[move];
				tailY+=dy[move];
			} 
			else if(map[headX][headY]==2) { // 사과를 만난 경우 tail 이동시킬 필요 없음
			
			}
			
			if(commandIdx<numDir && cnt==commandNum[commandIdx]) { // 방향 전환 명령
				
				// commandChar에 따라서 dir 변경
				switch(commandChar[commandIdx]) {
				case 'L':
					dir-=1;
					if(dir==-1) dir=3; 
					// 배나영: 4개의 방향이라 별 생각 없이 dir=4로 설정했는데 인덱스가 0~3이기 때문에 dir=3이었다는 점을 선규님이 잡아주셨다  
					break;
				case 'D':
					dir=(dir+1)%4;
					break;
				}
				commandIdx++;
			}
			
			// 종료 조건이 아니기 때문에 머리 방문 처리
			map[headX][headY]=1;
			
			// 방문 기록 moveRecord에 저장하기
			moveRecord.offer(dir);
			cnt++; // 초 수 증가
		}
		
		System.out.println(cnt);
	}
}
