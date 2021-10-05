package silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 17827. 달팽이 리스트
public class Test17827 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 노드의 개수
		int M = Integer.parseInt(st.nextToken()); // 질문의 횟수
		int V = Integer.parseInt(st.nextToken()); // N번 노드가 가리키는 노드의 번호

		List<Integer> snail = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			snail.add(Integer.parseInt(st.nextToken()));
		}
		int cycle = N - (V - 1);
		for (int m = 0; m < M; m++) {
			int K = Integer.parseInt(br.readLine());
			int answer = (K - (V - 1)) % cycle + (V - 1);
			if (K < N) {
				answer = K;
			} else if (V == N) {
				answer = N - 1;
			}
			System.out.println(snail.get(answer));
		}
	}

}
