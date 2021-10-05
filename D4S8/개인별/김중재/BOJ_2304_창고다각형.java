package d4s8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 막대 기둥의 수
		List<Node> list = new ArrayList<Node>();	// 막대의 입력과 x기준으로 정렬하기 위해 만든 리스트
		Stack<Node> stack = new Stack<>();			// 스택
		int Area = 0;	// 총 창고 넓이(출력값)
		
		// 막대 입력
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			list.add(new Node(x,h));
		}
		
		Collections.sort(list); // 정렬
		/* 입력 받고 x를 기준으로 정렬까지 완료.*/
		
		/**로직 시작*/
		// 먼저 스택에 넣고 빼면서 창고 넓이를 일부 구함.
		for (Node cur : list) {
			if(stack.isEmpty())	// 비어 있다면
				stack.push(cur);
			else {				// 스택이 비어 있지 않다면
				Node pop = null;
				while(!stack.isEmpty()) {	
					if(stack.peek().height < cur.height)	// 더 큰 높이가 들어온다면
						pop = stack.pop();
					else	// 스택에 있는것보다 더 낮은 크기가 들어온다면 반복문을 나가서 그냥 push만 해줌.
						break;
				}
				if(stack.isEmpty()) {
					int localArea = pop.height * (cur.x - pop.x);
					Area += localArea;
				}
				stack.push(cur);
			}
		}
		
		// 스택에 남아있는 것들을 이용해 남은 창고 넓이를 구함. => 최대 높이 이후의 부분.
		while(stack.size() > 1) {
			Node pop = stack.pop();
			int localArea = pop.height * (pop.x - stack.peek().x);
			Area += localArea;
		}
		
		// 가장 큰 부분이 남기 때문에 마지막으로 더해줌.
		Area += stack.pop().height;
		
		// 결과 출력
		System.out.println(Area);
	}
}

class Node implements Comparable<Node>{
	int x;
	int height;
	
	public Node(int x, int height) {
		super();
		this.x = x;
		this.height = height;
	}

	@Override
	public int compareTo(Node other) {
		// TODO Auto-generated method stub
		if(this.x < other.x)
			return -1;
		else if(this.x > other.x)
			return 1;
		return 0;
	}
}
