package com.study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10799 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		Stack<Character> stack=new Stack<>();
		
		int result = 0;
		
		for(int i=0;i<input.length();i++) {
			
			if(input.charAt(i)=='(') {
				stack.push('(');
			}
			else if(input.charAt(i)==')') { // 닫히는 괄호의 경우: (1)레이저가 뚫고 나가는 경우 (2)막대가 끝나는 경우
				
				if(!stack.isEmpty()) { 
					stack.pop();
				}
				
				if(input.charAt(i-1)=='(') { // 레이저가 뚫고 나가는 경우
					result+=stack.size(); 
				} else { // 막대가 끝나는 경우
					result++;
				}
			}
		} // end for i
		System.out.println(result);
	}

}
