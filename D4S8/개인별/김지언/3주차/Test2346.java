package silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 2346. 풍선 터뜨리기
public class Test2346 {
	static int N, idx;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(new int[] { i, Integer.parseInt(st.nextToken()) });
		}

		while (!list.isEmpty()) {
			while (idx < 0) {
				idx += list.size();
			}
			idx %= list.size();
			int[] el = list.remove(idx);
			if (el[1] > 0) {
				idx--;
			}
			idx += el[1];
			System.out.print(el[0] + " ");
		}
	}

}
