package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//카드의 수 입력받음.
		int N = Integer.parseInt(br.readLine());
		//입력받을 카드를 저장할 큐 생성
		Queue<Integer> queue = new LinkedList<>();
		
		//큐에 카드 입력
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		//큐에 한 장이 남을때까지 반복
		while(queue.size() > 1) {
			//제일 위에 카드를 빼서 출력값에 저장.
			sb.append(queue.poll()+ " ");
			//제일 위에 카드를 큐에 다시 집어넣음.
			queue.offer(queue.poll());
		}
		//마지막 카드 출력값에 저장.
		sb.append(queue.poll());
		
		System.out.println(sb);
	}
}
