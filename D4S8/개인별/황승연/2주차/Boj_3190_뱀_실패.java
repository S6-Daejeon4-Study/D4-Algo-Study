package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3190_뱀_실패 {
	
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		//사과 있는 곳은 4로 셋팅
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 4;
		}
		
		int L = Integer.parseInt(br.readLine());
		ChangeDirection[] arr = new ChangeDirection[L];
		for(int i=0;i<L;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			arr[i] = new ChangeDirection(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		//입력 끝
		
		int nowi=0;
		int nowj=0;
		int time=0;
		int index=0;
		int d=2;
		while(true) {
			time++;
			
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			if(nexti>=N || nexti<0 || nextj<0 || nextj>=N) {
				break;
			}
			
			nowi = nexti;
			nowj = nextj;
			
			if(time == arr[index].x) {
				if(arr[index].c.equals("D")){
					d +=1;
				}else if(arr[index].c.equals("L")) {
					d -=1;
				}
			}
		}
			System.out.println(time);	
	}

	
	static class ChangeDirection {
		int x;
		String c;
		
		public ChangeDirection(int x, String c) {
			super();
			this.x = x;
			this.c = c;
		}
		
		
	}
}
