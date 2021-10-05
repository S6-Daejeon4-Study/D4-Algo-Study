package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Baekjoon_10799 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		String str = br.readLine();
		char[] arr = str.toCharArray();

		int cnt = 0;
		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			char current = arr[i];

			if (current == '(')
				stack.push(current);
			
			if (current == ')') { // )인 경우, 그 앞전의 값을 비교하여 지금 )이 파이프인지 레이저인지 판단해야함
				char before = arr[i - 1];
				stack.pop();
				
				if (before == ')') { // 그 앞전에 레이저였음. 지금은 파이프가 닫힌것
					cnt++; // 막대기 하나가 끝나서 끝 부분만 남은 상태이므로 +1 필수
				} else { // 그 앞 (이었으며 현재 )인 상태
					cnt += stack.size(); // 스택사이즈만큼 현재 쇠막대기 수를 카운트 해줌
				}
			}
		}
		System.out.println(cnt);
	}
}
