package day0812;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stick_Stack {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> st = new Stack<>();	
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			//스택이 비어있지 않고, 판별했을 때 들어갈 막대기보다 들어있는 막대기의 크기가 작으면 뺀다.
			while(!st.isEmpty()&&isVisible(st, num)) {
				st.pop();
			}
			//뺀 뒤에 다시 막대기 집어넣기(집어넣는 막대기보다 큰 막대기들만 스택에 남아있음)
			st.push(num);
		}
		System.out.println(st.size());
	}
	
	//지금 넣는 막대기보다 스택에 있는 막대기가 작으면 True 반환, 아니면 False
	static boolean isVisible(Stack st, int num) {
		int top = (int) st.peek();
		return num>=top;
		
	}
}
