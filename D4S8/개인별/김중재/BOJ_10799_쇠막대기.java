package d4s8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10799_쇠막대기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();			// 입력
		List<Node> stack = new ArrayList<>();	// 입력의 괄호를 하나씩 넣을 스택
		int sum = 0;	// 자른 쇠막대기 갯수
		
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			if(ch == '(') {
				stack.add(new Node(i, ch));
			}
			else{	// ch == ')'
				int lastIdx = stack.size()-1;	// 레이저로 잘린 왼쪽 막대기 수	
				Node peek = stack.get(lastIdx);	
				if(peek.c == '(') {	// 쌍이 맞는지 검사하기 위해
					Node pop = stack.remove(lastIdx);	// 무조건 '(' 와 해당 문자의 위치
					/* '()((()))' 의 경우처럼 맨처음은 아무것도 자르지 않는 경우 때문에 */
					if(stack.isEmpty()) {
						// 쇠막대기 닫는 괄호와 레이저 닫는 괄호를 구분하기 위해서.
						if(pop.idx != i-1)	sum++;
						continue;
					}
					if(pop.c == '(' && pop.idx == i-1)	// 레이저의 닫는 괄호 만난 경우. 
						sum += lastIdx;
					else	// 쇠막대기 닫는 괄호 만난 경우.
						sum++;
				}
			}
		}
		sum += stack.size();	// 스택에 남은 것들을 다 더해줌.
		System.out.println(sum);
		
	}
	
	static class Node{
		int idx;
		char c;
		
		public Node(int idx, char c) {
			super();
			this.idx = idx;
			this.c = c;
		}
	}
}
