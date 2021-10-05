package bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 20001. 고무오리 디버깅
public class Test20001 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		br.readLine(); // 고무오리 디버깅 시작
		String input = br.readLine();
		while (!input.equals("고무오리 디버깅 끝")) {
			if (input.equals("문제")) {
				stack.push(input);
			} else if (input.equals("고무오리")) {
				if (stack.isEmpty()) {
					stack.push("문제");
					stack.push("문제");
				} else {
					stack.pop();
				}
			}
			input = br.readLine();
		} // whlie end
		if (stack.isEmpty()) {
			System.out.println("고무오리야 사랑해");
		}else {
			System.out.println("힝구");
		}
	}

}
