package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj200001 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();
		Stack<Integer> st = new Stack<>();
		while(true) {
			String str = br.readLine();
			if(str.equals("문제")) st.push(1);
			if(str.equals("고무오리")) {
				if(!st.isEmpty()) st.pop();
				else {
					st.push(1);
					st.push(1);
				}
			}
			if(str.equals("고무오리 디버깅 끝")) break;
		}
		
		if(!st.isEmpty()) {
			System.out.println("힝구");
		}else {
			System.out.println("고무오리야 사랑해");
		}

	}

}
