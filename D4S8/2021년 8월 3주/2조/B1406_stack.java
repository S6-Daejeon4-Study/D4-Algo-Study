package com.ssafy.linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @author comkkyu
 * @date 21. 8. 17
 * 
 * 백준 1406 - 에디터
 * https://www.acmicpc.net/problem/1406
 *
 */
public class B1406_stack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str = br.readLine();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		int M = 0; // 명령어 개수

		for (int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i)); // 처음에는 커서가 맨 뒤이므로 모든 문자들이 커서 왼쪽에 위치함
		}

		M = Integer.parseInt(br.readLine());

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			char command = st.nextToken().charAt(0);

			switch (command) {
			case 'L': // 커서를 왼쪽으로 한 칸 옮김
				// 커서 왼쪽에 있던 내용이 오른쪽으로 옮겨져야 함
				// 커서가 문장의 맨 앞이면 무시됨
				if (!left.isEmpty()) right.push(left.pop());
				break;
			case 'D': // 커서를 오른쪽으로 한 칸 옮김
				// 커서 오른쪽에 있던 내용이 왼쪽으로 옮겨져야 함
				// 커서가 문장의 맨 뒤이면 무시됨
				if (!right.isEmpty()) left.push(right.pop());
				break;
			case 'B': // 커서 왼쪽에 있는 문자를 삭제함
				// 왼쪽 스택 top 에 있는 내용이 커서의 바로 왼쪽에 있는 내용이므로 pop
				// 커서가 문장의 맨 앞이면 무시됨
				if (!left.isEmpty()) left.pop();
				break;
			case 'P': // 다음에 오는 문자를 커서 왼쪽에 추가함
				// 커서 왼쪽 영역인 left 스택의 top에 해당 문자를 추가
				char c = st.nextToken().charAt(0);
				left.push(c);
				break;
			}
		}
		
		while (!left.isEmpty()) {
			right.push(left.pop());
		}
		
		while (!right.isEmpty()) {
			bw.write(right.pop());
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
