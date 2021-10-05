package silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 2164. 카드2
public class Test2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		int card = 0;
		while (true) {
			card = queue.poll(); // 제일 위에 있는 카드 버리기
			if (queue.isEmpty())
				break;
			queue.offer(queue.poll()); // 다음 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮기기
		}
		System.out.println(card);
	}

}
