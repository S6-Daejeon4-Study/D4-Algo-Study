package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 고무오리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력을 처리하기 위한 String 스택 생성.
		Stack<String> stack = new Stack<>();

		//종료 문장이 들어오기 전까지 반복할 while문.
		while (true) {
			//한 줄씩 str에 저장.
			String str = br.readLine();

			
			if (str.equals("고무오리")) {
				//고무오리를 받았는데 스택이 비어있으면 문제 추가.
				if (stack.size() == 0) {
					stack.push("문제");
					stack.push("문제");
				} else {
					//아니면 스택에서 문제 하나 제거.
					stack.pop();
				}
				//문제를 입력받으면 스택에 저장.
			} else if (str.equals("문제")) {
				stack.push(str);
				//해당 문자열을 입력 받으면 while문 종료
			} else if (str.equals("고무오리 디버깅 끝"))
				break;
		}
		//스택이 비어있으면 출력.
		if (stack.isEmpty())
			System.out.println("고무오리야 사랑해");
		else
			System.out.println("힝구");
	}
}
