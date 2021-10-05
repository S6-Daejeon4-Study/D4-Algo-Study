package silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 1406. 에디터
public class Test1406 {
	static int M, idx;
	static List<Character> pre, next;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		pre = new LinkedList<>(); // 커서 왼쪽 문장
		next = new LinkedList<>(); // 커서 오른쪽 문장
		for (int i = 0; i < chars.length; i++) {
			pre.add(chars[i]);
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			switch (key) {
			case "L": // 커서를 왼쪽으로 한 칸 옮김
				if (!pre.isEmpty())
					next.add(0, pre.remove(pre.size() - 1));
				break;
			case "D": // 커서를 오른쪽으로 한 칸 옮김
				if (!next.isEmpty()) {
					pre.add(next.remove(0));
				}
				break;
			case "B": // 커서 왼쪽에 있는 문자를 삭제함
				if (!pre.isEmpty()) {
					pre.remove(pre.size() - 1);
				}
				break;
			case "P": // 커서 왼쪽에 문자 추가함
				pre.add(st.nextToken().charAt(0));
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : pre) {
			sb.append(c);
		}
		for (char c : next) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}

}
