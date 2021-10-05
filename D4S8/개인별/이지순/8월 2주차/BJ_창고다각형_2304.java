import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_창고다각형_2304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Point> list = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list.add(new Point(idx, height));
		}

		Collections.sort(list);// 인덱스 정렬을 위해 comparable interface

		int result = 0;
		Stack<Point> leftStack = new Stack<>();

		int maxHeight = 0;
		for (int i = 0; i < list.size(); i++) { // 좌측 값 stack에 넣어주기
			if (maxHeight < list.get(i).height) {
				maxHeight = list.get(i).height;
				leftStack.push(list.get(i));
			}
		}

		maxHeight = 0;
		Stack<Point> rightStack = new Stack<>();
		for (int i = list.size() - 1; i >= 0; i--) { // 우측 값 stack에 넣어주기
			if (maxHeight < list.get(i).height) {
				maxHeight = list.get(i).height;
				rightStack.push(list.get(i));
			}
		}
		
		for (int i = 0; i < leftStack.size() - 1; i++) {
			result += leftStack.get(i).height * (leftStack.get(i + 1).idx - leftStack.get(i).idx);
		}

		result += leftStack.peek().height;
		result += rightStack.peek().height * (rightStack.peek().idx - leftStack.peek().idx);
		for (int i = 0; i < rightStack.size() - 1; i++) {
			result += rightStack.get(i).height * (rightStack.get(i).idx - rightStack.get(i + 1).idx);
		}
		System.out.println(result);
	}

	static class Point implements Comparable<Point> {
		int idx;
		int height;

		Point(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if (this.idx > o.idx)
				return 1;
			else if (this.idx < o.idx)
				return -1;
			return 0;
		}
	}
}
