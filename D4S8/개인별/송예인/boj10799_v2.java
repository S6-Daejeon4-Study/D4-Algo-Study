package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj10799_v2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch_arr = br.readLine().toCharArray();
		int cnt = 0, ans = 0;
		Stack<Character> st = new Stack<>();
		for(char c: ch_arr) {
			if(c=='(') {
				cnt = 0;
				st.push(c);
				continue;
			}
			cnt++;
			st.pop();
			if(c==')') {// 빔이면
				if(cnt==1) ans+= st.size();//바로 직전에 (라는 소리
				else ans++;
			}
		}
		System.out.println(ans);


	}
}