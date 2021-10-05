package day0812;

import java.util.Scanner;
import java.util.Stack;

public class RubberDuck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> st = new Stack<>();

		String begin = sc.nextLine();
		while (true) {
			String order = sc.nextLine();
			if (order.equals("고무오리 디버깅 끝")) {
				break;
			}
			else if (order.equals("문제"))
				st.push(order);

			else if (order.equals("고무오리") && !st.isEmpty())
				st.pop();
			else if (order.equals("고무오리") && st.isEmpty()) {
				st.push("문제");
				st.push("문제");
			}

		}
		if (st.isEmpty())
			System.out.print("고무오리야 사랑해");
		else
			System.out.print("힝구");
	}
}