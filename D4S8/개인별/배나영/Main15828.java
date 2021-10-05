package com.study.week02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main15828 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();

		while (true) {
			int num = sc.nextInt();

			if (num == -1)
				break;

			if (num == 0) {
				if(!queue.isEmpty()) {
					queue.poll();
				}
			} else {
				if(!(queue.size()>=N)) {
					queue.offer(num);
				}
			}
		} // end while

		if (queue.isEmpty()) {
			System.out.println("empty");
		} else {
			
			while(!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			
		}
	}
}
