import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1182_부분수열의합 {
	static int N, S;
	static int[] list;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		list = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < N ; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);				// 정렬
		
		subset(0, 0);					// 부분집합 구하기 시작
		System.out.println(result);
	}
	static void subset(int idx, int value) {
		if(idx == N) return;			// 끝까지 다 봤으면 리턴
		if(value + list[idx] == S) result++;	// 다음 값을 더했더니 S와 같아졌으면 결과 증가
		if(value + list[idx] > S && value + list[idx] >= 0) return;	// 다음 값을 더했더니 S보다 커지고, 그 값이 0보다 크다면 더이상 할 필요 없으므로 return
		subset(idx + 1, value + list[idx]);	// 현재 값 포함
		subset(idx + 1, value);			// 현재 값 미포함
	}
}
