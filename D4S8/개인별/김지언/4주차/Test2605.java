package bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 2605. 줄 세우기
public class Test2605 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(i - Integer.parseInt(st.nextToken()), i + 1);
		}

		StringBuilder sb = new StringBuilder();
		for (Integer integer : list) {
			sb.append(integer).append(" ");
		}
		System.out.println(sb.toString());
	}

}
