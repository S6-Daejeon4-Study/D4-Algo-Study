package 뱀;

import java.util.LinkedList;
import java.util.Scanner;

public class B_0000 {
	static LinkedList<Point> snake = new LinkedList<>();
	static Point[] apples;
	static Point[] dirs;
	static int N;
	static int K;
	static int L;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//보드의 크기 N, 사과의 갯수 K, 방향변환 횟수 L
		N = sc.nextInt();
		K = sc.nextInt();
		apples = new Point[K];
		for(int i = 0; i < K; i++) {
			apples[i] = new Point(sc.nextInt(),sc.nextInt());
		}
		L = sc.nextInt();
		dirs = new Point[L];
		//방향변환 인풋
		for(int i = 0; i < L; i++) {
			dirs[i] = new Point(sc.nextInt(), sc.next());
		}
		move();
	}
	
	static void move() {
		//시간초
		int count = 0;
		int index = 0;
		//0 우 1 하 2 좌 3 상
		int dir = 0;
		//뱀의 초기위치 
		snake.offer(new Point(0,0));
		while(true) {
			
			//방향전환
			if( index < L && dirs[index].x == count ) {
				dir = Math.abs(calcdir(dirs[index].y) + dir) % 4;
				index++;
			}
			
			
			int nx = dx[dir] + snake.getLast().x;
			int ny = dy[dir] + snake.getLast().y;
			++count;
			//벽에 박았을때 
			if(nx < 0 || nx >= N || ny <0 || ny >= N ) {
				break;
			}
			//자기 꼬리에 박았을때 
			int flag = 0;
			for(int i = 0; i < snake.size(); i++) {
				if (snake.get(i).x == nx && snake.get(i).y == ny ) {
					flag = 1;
					break;
				}
			}
			if(flag == 1) break;
			//이제 큐에 넣고 사과의 유무에따라 팝의 유무가 결정됨
			snake.offer(new Point(nx, ny));
			//사과가 있는지 없는지 확인 있으면 컨티뉴 없으면 큐의 head를 팝
			for(Point a : apples) {
				if (a.x == nx + 1 && a.y == ny + 1 ) {
					a.x =-1;
					a.y =-1;
					flag = 1;
					break;
				}
			}
			if(flag == 1) continue;
				snake.poll();

			
			
			
		}//end while
		System.out.println(count);
	}
	
	static int calcdir(int dir) {
		return dir == 'D' ? 1 : 3;
	}
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
		public Point(int x, String y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y.charAt(0);
		}
	}
	
}


