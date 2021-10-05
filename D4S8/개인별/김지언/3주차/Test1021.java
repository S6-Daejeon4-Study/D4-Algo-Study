package silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 1021. 회전하는 큐
public class Test1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		List<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int idx = queue.indexOf(num);
			if (idx > queue.size() / 2) {
				// 오른쪽으로 이동
				while (queue.get(0) != num) {
					queue.add(0, queue.remove(queue.size() - 1));
					answer++;
				}
			} else {
				// 왼쪽으로 이동
				while (queue.get(0) != num) {
					queue.add(queue.remove(0));
					answer++;
				}
			}
			queue.remove(0);
		}
		System.out.println(answer);
	}

}
