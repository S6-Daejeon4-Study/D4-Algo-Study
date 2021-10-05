import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_쇠막대기_10799 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		int result = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '(') // 괄호 시작
				stack.push(str.charAt(i));
			else { // 닫는 괄호이면
				stack.pop();
				if(i>0 && str.charAt(i-1) == '(') {
					result += stack.size();
				} else {
					result += 1;
				}
			}
		}
		System.out.println(result);
	}
}
