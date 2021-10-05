package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj15828 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//버퍼사이즈
		Queue<Integer> q = new LinkedList<>();
		while(true) {
			int n = sc.nextInt();
			if(n==-1) break;
			if(q.isEmpty()) {
				if(n!=0) {
					q.add(n);
				}
			}else {
				if(n==0) q.poll();
				if(q.size()<N && n!=0) {
					q.add(n);
				}
			}
		}
		
		//남아있는 것들 출력
		if(q.isEmpty()) {
			System.out.print("empty");
		}else {
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}			
		}

	}

}
