import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ7490_0만들기 {
	static int TC, N;
	static ArrayList<String> result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TC = Integer.parseInt(in.readLine());	
		for(int i = 0 ; i < TC ; i++) {								// TC만큼 반복
			N = Integer.parseInt(in.readLine());					// N을 입력받음
			result = new ArrayList<String>();						// 결과 String을 저장할 ArrayList
			makeZero(1, 2, 1, "1");									// 1 ~ 2 사이의 연산자부터 시작하도록(처음엔 1만 포함)
			
			Collections.sort(result);								// 결과 String을 sort함
			for(String s : result) {								// 모든 결과를 sb에 더함
				sb.append(s + "\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);										// TC만큼 끝난 후 출력
	}
	
	// 0이 되는 경우, 해당 문자열을 결과 ArrayList에 추가해줌
	// 매개변수 - 이전값, 현재값, 현재까지의 합, 현재까지의 수식 
	static void makeZero(int last, int now, int sum, String s) {
		// System.out.println(now + " " + sum + " " + s);
		// 끝에서 처리하기 귀찮아서 sum과 s를 계속 계산해줌
		if(now > N) {												// 모든 값에 대해 연산을 했고,
			if(sum == 0) result.add(s);								// 결과가 0이면 추가해줌
			return;													// 반환
		}
		makeZero(now, now + 1, sum + now, s + '+' + now);			// +연산 진행
		makeZero(-now, now + 1, sum - now, s + '-' + now);			// -연산 진행(이전값을 -로 설정)
		makeZero(Integer.parseInt(last + "" + now), now + 1, 		// 이전 수에 이어붙임 - 이전 값으로 숫자 이어붙여서 설정, sum을 갱신 
				sum + Integer.parseInt(last + "" + now) - last, s + ' ' + now);
	}
}