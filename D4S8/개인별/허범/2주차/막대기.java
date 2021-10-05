package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 막대기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//막대를 담을 스택 생성
		Stack<Integer> stack = new Stack<>();
		
		//탑의 개수 입력받음
		int N = Integer.parseInt(br.readLine());
		//결과값
		int count = 0;
		//탑의 높이를 비교하기 위한 값
		int max = 0;
		
		//스택에 탑을 하나씩 넣음
		for(int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		//스택에서 하나씩 빼면서 탑의 높이를 비교
		for(int i = 0; i < N; i++) {
			//탑이 기준값보다 높으면 count 값 증가.
			if(max < stack.peek()) {
				max = stack.pop();
				count++;
			}else
				stack.pop();
		}
		
		System.out.println(count);
	}
}
