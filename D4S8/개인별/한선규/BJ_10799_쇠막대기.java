package com.ssafy.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * @author comkkyu
 * @date 21. 8. 10
 * 
 * 백준 10799 - 쇠막대기 (스택 - 숙련자)
 * https://www.acmicpc.net/problem/10799
 *
 */
public class BJ_10799_쇠막대기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		int count = 0;
		
		for (int i = 0; i < input.length();	i++) {
			char ch = input.charAt(i);
			
			if (ch == '(') stack.push(ch);
			else {
				stack.pop();
				char preCh = input.charAt(i-1); // pop하게 됐을 때 이전 괄호의 종류
				// '(' : 레이저가 pop 된거고, ')' 라면 쇠막대기가 끝난 것
				// 레이저 pop 됐을때는 스택에 남아있는 쇠막대기의 수만큼 관통되므로 stack.size() 만큼 count 추가
				// 쇠막대기가 끝났을 경우에는 해당 쇠막대기 조각을 하나 count 에 추가
				count += (preCh == ')') ? 1 : stack.size();
			}
		}
		
		System.out.println(count);
		br.close();
	}

}
