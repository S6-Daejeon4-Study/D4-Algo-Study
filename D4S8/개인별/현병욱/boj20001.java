package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj20001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		System.out.println("고무오리 디버깅 시작");
		
		Stack<String> duck = new Stack<String>();
		String input ="";
		
		while(true) {
			input = br.readLine();
			if(input.equals("고무오리")) {
				if(duck.isEmpty()) {
					duck.push("고무오리");
					duck.push("고무오리");
				}else {
					duck.pop();
				}
			}else if(input.equals("문제")) {
				duck.push(input);
			}else if(input.equals("고무오리 디버깅 끝")) {
				break;
			}
		}
		
		if(duck.isEmpty()) {
			System.out.println("고무오리야 사랑해");
		}else {
			System.out.println("힝구");
		}
	}
}
		
	

