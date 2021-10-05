package silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2564. 경비원
public class Test2564 {
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int W, H, N;
	static Node[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		input = new Node[N + 1];
		for (int i = 0; i < input.length; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Node node = null;
			switch (x) {
			case 1:
				node = new Node(0, y);
				break;
			case 2:
				node = new Node(H, y);
				break;
			case 3:
				node = new Node(y, 0);
				break;
			case 4:
				node = new Node(y, W);
			}
			input[i] = node;
		}
		int x = input[N].x;
		int y = input[N].y;

		int answer = 0;
		for (int i = 0; i < input.length - 1; i++) {
			int storeX = input[i].x;
			int storeY = input[i].y;
//			System.out.println(storeX + " " + storeY);
			int min = 0;
			if (Math.abs(storeX - x) == H) { // 북남
				min = Math.min(y + storeY, W * 2 - (y + storeY)) + H;
			} else if (Math.abs(storeY - y) == W) { // 동서
				min = Math.min(x + storeX, H * 2 - (x + storeX)) + W;
			} else {
				min = Math.abs(x - storeX) + Math.abs(y - storeY);
			}
			answer += min;
		}
		System.out.println(answer);
	}

}
