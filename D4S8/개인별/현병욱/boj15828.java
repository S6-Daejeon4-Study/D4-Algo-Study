package day0814;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj15828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> buffer = new LinkedList<>();
		int size = sc.nextInt();
		int input = 0;
		
		while(true) {
			input = sc.nextInt();
			if(input == -1) {
				break;
			}
			if(buffer.isEmpty()) {
				buffer.add(input);
			}else {
				if(input == 0) {
					buffer.poll();
				}else {
					if(buffer.size() < size) {
						buffer.add(input);
					}
				}
			}
		}
		if(buffer.isEmpty()) {
			System.out.println("empty");
		}else {
			while(!buffer.isEmpty()) {
				System.out.print(buffer.poll() + " ");
			}
		}
		
	}
}
