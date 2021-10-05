package study02;

import java.util.Scanner;
import java.util.Stack;

public class IronStic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();

		for (int tc = 0; tc < N; tc++) {
			Stack<Character> stack = new Stack<>();
			String a = sc.nextLine();
			char[] arr = a.toCharArray();
			int idx = 0;
			int cnt = 0;

			while (idx < arr.length) {

			                           //열린 괄호가 나왔을 때
				if (arr[idx] == '(') { // 스택에 푸시

					stack.push(arr[idx]);

				}

				if (arr[idx] == ')') {          // 닫힌 괄호가 나왔을 때

					if (arr[idx - 1] == ')') {  // 이전에도 닫힌괄호라면?
						if (!stack.isEmpty()) { // 스택이 비었을땐 실행안됨
							stack.pop();        // 현재 스택 -짝이 맞는'('가 있을거임
							cnt++;              // 없애고 막대수 한개 추가

						}

					}

					else if (!stack.isEmpty()) {    // 스택이 비었을땐 실행 안됨
						if (stack.peek() == '(') {  // 레이져 발사!

							stack.pop();            // 현재스택 -짝이맞는 '('
							cnt += stack.size();    // 현재까지 쌓여있는 스택만큼 막대 생성

						}
					}

				}
				idx++;

			}
			System.out.println("#" + (tc + 1) + " " + cnt);
		}

	}

}
