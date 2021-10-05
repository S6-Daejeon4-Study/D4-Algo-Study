package bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 17608. 막대기
public class Test17608 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < cnt; i++) {
			int h = Integer.parseInt(br.readLine());
			while (!stack.isEmpty() && stack.peek() <= h) {
				stack.pop();
			}
			stack.add(h);
		}
		System.out.println(stack.size());
	}

}
