package com.study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main17608 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty()&&num>=stack.peek()) {
				stack.pop();
			}
			
			stack.push(num);
		}// end N
		System.out.println(stack.size());
	}

}
