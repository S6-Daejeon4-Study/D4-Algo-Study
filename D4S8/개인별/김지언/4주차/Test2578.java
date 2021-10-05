package silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2578. 빙고
public class Test2578 {
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] board;
	static Node[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[5][5];
		input = new Node[26];
		StringTokenizer st;
		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				input[board[i][j]] = new Node(i, j);
			}
		}

		int cnt = 1;
		loop: for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board[i].length; j++, cnt++) {
				int num = Integer.parseInt(st.nextToken());
				board[input[num].x][input[num].y] = 0;
				if (findBingo()) {
					System.out.println(cnt);
					break loop;
				}
			}
		}
	}

	private static boolean findBingo() {
		int bingo = 0;
		int[] dx = { 0, 1, 1, 1 };
		int[] dy = { 1, 1, 0, -1 };

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((i != 0 && j != 0) || board[i][j] != 0) {
					continue;
				}
				for (int d = 0; d < dx.length; d++) {
					int cnt = 0;
					int ni = i;
					int nj = j;
					while (ni >= 0 && ni < 5 && nj >= 0 && nj < 5 && board[ni][nj] == 0) {
						ni += dx[d];
						nj += dy[d];
						cnt++;
					}
					if (cnt == 5) {
						bingo++;
					}
				}
			}
		}
		if (bingo >= 3) {
			return true;
		} else {
			return false;
		}
	}

}
