package day0813;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2164 {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue<Integer> card = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			card.add(i);
		}
		
		while(!card.isEmpty()) {
			if(card.size() == 1) {
				System.out.println(card.poll());
				break;
			}else {
				card.poll();
				int tmp = card.poll();
				card.add(tmp);
			}
			
			
			
		}
		
	}
}
