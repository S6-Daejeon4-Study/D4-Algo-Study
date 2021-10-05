package d4s8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_15828_Router {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		while(true) {
			int packet = sc.nextInt();
			if(packet == -1)
				break;
			if(packet == 0) {
				if(!queue.isEmpty())
					queue.poll();
				continue;
			}
			if(queue.size() < size)
				queue.add(packet);
		}
		
		if(queue.isEmpty()) {
			System.out.println("empty");
		}else {
			while(!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
		}
	}
}
