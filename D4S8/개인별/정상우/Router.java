package study02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Router {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		
		
		int N=sc.nextInt();
		int res=0;
		Queue<Integer> q=new LinkedList<Integer>();
		
		while(res!=-1) {
			
			res=sc.nextInt();//입력받기			
			if(res==0) {
				q.poll();
			}
			
			else {
				
				if(res>0&&q.size()<N) {
					q.offer(res);
				}
				
			}
		}
			
			
			if(q.isEmpty()) { //큐가 비었있을때 empty 출력
				System.out.println("empty");
			}
			
			else { //그렇지 않다면 큐 순서대로출력
				while(!q.isEmpty()) {
					System.out.print(q.poll()+" ");
			}
			
		}
		
		
		
	}

}
