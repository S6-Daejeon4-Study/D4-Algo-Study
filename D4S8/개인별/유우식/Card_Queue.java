package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Scanner;

//백준 2161 카드1
public class Card_Queue {
	static int temp;
	static int idx=1;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> card = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			card.add(i);
		}
		
		while(card.size()!=1) {
			temp=0;
			if(idx%2==1 && !card.isEmpty()) {
				temp = card.poll();
				System.out.print(temp+" ");
				idx= idx+1;
			}
			else if(idx%2==0 && !card.isEmpty()) {
				temp = card.poll();
				card.add(temp);
				idx= idx+1;
			}
			
		}
		System.out.print(card.peek());
		
		
	}
}
