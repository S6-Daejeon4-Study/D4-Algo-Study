package algo;

import java.util.Scanner;

public class boj2564 {
	static class Point{
		int x;
		int y;
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();//가로 
		int H = sc.nextInt();//세로
		int N = sc.nextInt();
		Point[] point = new Point[N];
		for(int n=0;n<N;n++) {
			int cnt = sc.nextInt();//방향
			int dis = sc.nextInt();
			if(cnt==1) {
				point[n] = new Point(0,dis);
			}else if(cnt==2) {
				point[n] = new Point(H,dis);
			}else if(cnt==3) {
				point[n] = new Point(dis,0);
			}else {
				point[n] = new Point(dis,W);
			}
		}
		int x = sc.nextInt();
		int y = sc.nextInt();
		if(x==1) {
			x = 0;
		}else if(x==2) {
			x = H;
		}else if(x==3) {
			x = y;
			y = 0;
		}else {
			x = y;
			y = W;
		}
		
		
		//input end
		
		int result = 0;
		for(int n=0;n<N;n++) {
			if(x==point[n].x) {
				result += Math.abs(y-point[n].y);
			}else if(Math.abs(x-point[n].x)==H) {
				result += (H + Math.min(y+point[n].y, W-y + W-point[n].y)); 
			}else if(y==point[n].y) {
				result += Math.abs(x-point[n].x);
			}else if(Math.abs(y-point[n].y)==W){
				result += (W + Math.min(x+point[n].x,H-x+H-point[n].x));
			}else {
				result += Math.abs(x-point[n].x)+Math.abs(y-point[n].y);
			}
			
		}
		System.out.println(result);

	}

}
