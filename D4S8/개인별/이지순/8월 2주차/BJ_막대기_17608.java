import java.util.Scanner;
import java.util.Stack;

public class BJ_막대기_17608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<N;i++) {
			stack.push(sc.nextInt());
		}
		
		int max = stack.pop();
		int count = 1; // 맨 처음 값
		while(stack.size()>0) {
			int temp = stack.pop();
			if(temp>max) {
				max = temp;
				count++;
			}
		}
		
		System.out.println(count);
	}

}
