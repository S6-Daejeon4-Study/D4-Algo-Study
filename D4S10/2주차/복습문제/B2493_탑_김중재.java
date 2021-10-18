package month10.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	static int N;				// 탑의 갯수
	static Top[] top;			// 입력받는 top의 정보 저장하는 배열
	static long[] H;			// 수신하는 탑 인덱스 기록용 -> 출력
	static Stack<Top> stack;	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		top = new Top[N+1];
		H = new long[N+1];
		stack = new Stack<>();
		
		top[0] = new Top(0, 0);	// top의 높이가 1 이상 이므로 무조건 탑보다 작은 높이인 0을 넣음.
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			top[i] = new Top(Integer.parseInt(st.nextToken()), i);
		}
		// 입력 완료
		
		/*로직 시작*/
		// 왼쪽을 바라보면서 레이저를 쏘니까 뒤에서 부터 스택에 넣으면서 검사.
		for(int i=N;i>0;i--) {
			while(true) {
				// 스택이 비었거나 스택의 탑의 높이가 새로 들어올 탑의 높이보다 큰 경우 => push
				if(stack.isEmpty() || stack.peek().height >= top[i].height) {
					stack.push(top[i]);
					break;
				}
				// 위의 상황이 아닌 경우
				Top cur = stack.pop();	// 스택에서 pop해주기.
				H[(int)cur.idx] = i;		// 수신한 탑의 인덱스 기록
			}
		}
		
		/*결과 출력*/
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			sb.append(H[i] + " ");
		}
		System.out.println(sb);
	}
	
	private static class Top{
		int height;
		long idx;
		
		public Top(int height, int idx) {
			super();
			this.height = height;
			this.idx = idx;
		}
	}
}
