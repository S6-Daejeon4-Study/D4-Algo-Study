package bronze.lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2161. 카드1
public class Test2161 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		while (true) {
			sb.append(queue.poll() + " "); // 제일 위에 있는 카드 버리기
			if (queue.isEmpty())
				break;
			queue.offer(queue.poll()); // 다음 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮기기
		}
		System.out.println(sb.toString());
	}

}
