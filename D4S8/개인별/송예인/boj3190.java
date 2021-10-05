package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj3190 {
	static int[] dx = {0,1,0,-1};//우하좌상 순
	static int[] dy = {1,0,-1,0};
	static class Tail{
		int x;
		int y;
		Tail(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//보드의 크기
		int apple_num = sc.nextInt();
		boolean[][] apple = new boolean[N+1][N+1];
		for(int a=0;a<apple_num;a++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			apple[x][y] = true;
		}
		int L = sc.nextInt();//방향변환 횟수
		char[] change_dir = new char[100];//인덱스==초
		for(int l=0;l<L;l++) {
			int second = sc.nextInt();
			char LorR = sc.next().charAt(0);
			change_dir[second] = LorR;  
		}// =========> input end
		
		boolean[][] map = new boolean[N+1][N+1];//본인 몸 위치 표시하는 배열
		map[1][1] = true;//처음 뱀의 위치
		
		int dir = 0;// 오른쪽 방향 디폴트
		int ans = 0;// 빵초 시작!
		Queue<Tail> q = new LinkedList<>();//꼬리
		q.add(new Tail(1,1));
		int c_x = 1;
		int c_y = 1;
		while(true) {
			//0. 방향이 돌아가는 경우
			if(change_dir[ans]=='D') {
				dir = (dir+1)%4;
			}else if(change_dir[ans]=='L') {
				if(dir==0) dir = 3;
				else dir = dir-1;
			}
			int n_x = c_x+dx[dir];
			int n_y = c_y+dy[dir];
			
			//1. 죽는경우 체크: 범위 벗어낫거나 or 몸이랑 부딛힘
			if(n_x<1 || n_x>N || n_y<1 || n_y>N || map[n_x][n_y]) 
				break;
			//2. 사과 발견하는 경우
			if(!apple[n_x][n_y]) { //사과 없는 경우 가장 마지막 꼬리 삭제
				Tail tail = q.poll();
				map[tail.x][tail.y] = false;
			}else{ //사과 발견하는 경우
				apple[n_x][n_y] = false;//해당 사과 없어짐
			}
			q.add(new Tail(n_x,n_y));
			map[n_x][n_y] = true;
			c_x = n_x;
			c_y = n_y;
			ans++;
		}
		System.out.println(ans+1);
	}

}
