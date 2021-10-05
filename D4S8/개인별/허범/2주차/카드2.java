package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//카드의 수 입력받음.
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		//큐에 카드 저장.
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		//카드가 한 장 남을때까지 반복.
		while(queue.size() > 1) {			
			queue.poll();
			queue.offer(queue.poll());
		}	
		//마지막 카드 출력.
		System.out.println(queue.poll());
	}
}