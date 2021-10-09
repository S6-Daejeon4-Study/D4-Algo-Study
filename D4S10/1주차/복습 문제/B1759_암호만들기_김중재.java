package month10.study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static int L,C;
	static char[] arr;
	static boolean[] check;
	static String str = "aeiou";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		check = new boolean[C];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		// 입력 완료
		
		Arrays.sort(arr);
		
		comb(0,0);
	}

	private static void comb(int target, int cnt) {
		if(cnt == L) {
			int count = 0;
			String ans = "";
			for(int i=0;i<C;i++) {
				if(check[i]) {
					ans += arr[i];
					if(str.contains(arr[i]+"")) {
						count++;
					}
				}
			}
			if(L-count >= 2 && count >= 1)
				System.out.println(ans);
			
			return;
		}
		if(target == C)
			return;
		
		check[target] = true;
		comb(target+1, cnt+1);
		check[target] = false;
		comb(target+1, cnt);
	}
}
