package day0813;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2161 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue<Integer> card = new LinkedList<Integer>();
		int[] result = new int[N];
		
		for(int i = 1; i <= N; i++) {
			card.add(i);
		}
		
		int index = 0;
		while(!card.isEmpty()) {
			result[index] = card.poll();
			index++;
			if(!card.isEmpty()) {
				int tmp = card.poll();
				card.add(tmp);
			}else {
				break;
			}
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
		
	}
}
