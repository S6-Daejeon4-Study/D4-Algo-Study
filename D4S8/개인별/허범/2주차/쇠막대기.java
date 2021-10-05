package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String stick = br.readLine();
		int count = 0;

		//입력을 저장할 스택 생성.
		Stack<Character> stack = new Stack<>();

		
		//스택 길이 만큼 검사?
		for (int i = 0; i < stick.length(); i++) {
			//막대기를 스택에 저장
			if (stick.charAt(i) == '(')
				stack.push('(');
			else {
				//레이저인지 검사하고 현재까지 레이저로 나눈 막대 저장. 
				if (stick.charAt(i - 1) == '(') {
					stack.pop();
					count += stack.size();
				} 
				//마지막 막대기가 남아서 +1.
				else {
					stack.pop();
					count += 1;

				}
			}
		}
		System.out.println(count);
	}
}
