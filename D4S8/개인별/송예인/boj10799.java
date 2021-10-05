package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj10799 {
	static class Box {
		char ch;
		int idx;

		Box(char ch, int idx) {
			this.ch = ch;
			this.idx = idx;
		}
	}

	static boolean[] check_bim;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch_arr = br.readLine().toCharArray();
		Stack<Box> st = new Stack<>();
		check_bim = new boolean[ch_arr.length];
		st.push(new Box(ch_arr[0],0));
		for (int n = 0; n < ch_arr.length; n++) {
			
			// bim 일 조건, index 1차이나고 반대방향임
			
			// 방향만 반대일 조건
			if (st.peek().ch=='(' && ch_arr[n]==')') {
				if(st.peek().idx+1==n) {
					st.pop();
					check_bim[n] = true;
					continue;
				}
				
				Box box = st.pop();
				int seperate = 0;
				for (int i = box.idx; i < n; i++) {
					if (check_bim[i])
						seperate++;
				}
				System.out.println(seperate+1);
				ans += seperate + 1;
				continue;
			}
			
			st.push(new Box(ch_arr[n],n));

		}
		System.out.println(ans);

	}

}
