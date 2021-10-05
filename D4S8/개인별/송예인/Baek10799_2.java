package algo;

import java.util.Scanner;
import java.util.Stack;

public class Baek10799_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int ans = 0, cnt = 0;
			char[] data = sc.next().toCharArray();
			Stack<Character> s = new Stack<>();
			for (char c : data) {
				if (c == '(') {
					cnt = 0;
					s.push(c);
					continue;
				}
				s.pop();  // 현재의 닫는 괄호와 쌍이되는 여는괄호 꺼내기
				cnt++;
				if (cnt == 1) {  // 레이져
					ans += s.size();
				} else {  // 막대의 끝
					ans++;
				}
				// c 가 여는 괄호일 경우
				//	 - 카운트 0으로 
				//   - 스택에 넣는다.
				// c 가 닫는 괄호일 경우
				//   - 여는 괄호를 하나 스택에서 빼낸다.
				//   - 카운트를 1 증가
				//   - 카운트가 1이면 레이저
				//      기존 막대의 수 + 스택의 크기를 더한다. 
				//   - 카운트가 1이 아니면 막대의 끝
				//      기존 막대의 수 + 1
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}





