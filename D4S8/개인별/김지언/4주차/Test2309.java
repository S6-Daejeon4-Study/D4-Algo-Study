package bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2309. 일곱 난쟁이
public class Test2309 {
	static int[] input, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = new int[9];
		answer = new int[7];
		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		} // input end
		combination(0, 0, 0);
		
		Arrays.sort(answer);
		for (int i : answer) {
			System.out.println(i);
		}
	} // main end

	private static boolean combination(int cnt, int start, int sum) {
		if (cnt == 7) {
			if (sum == 100) {
				return true;
			}
			return false;
		}
		for (int i = start; i < input.length; i++) {
			answer[cnt] = input[i];
			if (combination(cnt + 1, i + 1, sum + input[i])) {
				return true;
			}
		}
		return false;
	}
}
