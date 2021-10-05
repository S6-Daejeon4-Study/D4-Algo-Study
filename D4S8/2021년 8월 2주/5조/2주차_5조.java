import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

/* 
1. 선정 주제 : BOJ_2304, 창고 다각형.
2. 선정 이유 : 
- 초급자 문제에서는 특별한 알고리즘이나 설계 요소가 없어서 숙련자 문제로 선정.
- 숙련자 문제 중에서 "창고 다각형" 문제가 설계 단계에서 비교적으로 많은 고민이 필요했기에 선정함.
3. 풀이 방식 : 
- 황승연님
(1) maxHeight를 구하고 이에 대한 인덱스를 찾는다.
(2) maxHeight까지 좌측 값 계산
(3) maxHeight까지 우측 값 계산
- 이지순님
(1) 좌측 범위: (왼쪽부터 시작) 현재 인덱스보다 크면 stack에 넣어준다.
(2) 우측 범위: (오른쪽부터 시작) 현재 인덱스보다 크면 stack에 넣어준다.
(3) 스택에 넣은 값을 계산, 좌, 우의 max값이 다르다면 그 범위를 계산

4. 논의 대상 : 
구현부에서 방식의 차이는 있었으나, 기본적인 설계의 틀은 동일하여 추가적인 논의가 필요 없었음.
*/
public class BJ_창고다각형_2304_STUDY {

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

		Collections.sort(list);//인덱스 정렬을 위해 comparable interface
		
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
