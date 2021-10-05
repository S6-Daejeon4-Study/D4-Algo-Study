package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_15828 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<Integer> ansQ = new LinkedList<Integer>();
		Queue<Integer> cmdQ = new LinkedList<Integer>();

		int N = sc.nextInt();
		int userInput = 0;

		do {
			userInput = sc.nextInt();
			cmdQ.add(userInput);
		} while (userInput != -1);

		while (!cmdQ.isEmpty()) {
			int val = cmdQ.poll();

			if(val == -1)
				break;
			if (val == 0) {
				ansQ.poll();
			} 
			else {
				if (ansQ.size() < N) {
					ansQ.add(val);
				}
			}
		}

		if (ansQ.isEmpty()) {
			System.out.println("empty");
		} 
		else {
			while (!ansQ.isEmpty()) {
				System.out.print(ansQ.poll()+" ");
			}
		}
	}
}
