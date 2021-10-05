import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ2579_계단오르기 {
	static int N;
	static int[] stair, memo;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		stair = new int[N + 1];				// 계단의 점수 저장
		memo = new int[N + 1];				// 해당 계단을 포함한(자기 자신을 포함한) 해당 계단까지의 최댓값 저장
		for(int i = 1 ; i <= N ; i++) {
			stair[i] = Integer.parseInt(in.readLine());
		}
		
		memo[1] = stair[1];					
		if(N >= 2) {						// 두번째 계단에서는 첫번째 계단의 점수를 더함
			memo[2] = stair[1] + stair[2];
		}
		if(N >= 3) {						// 세번째 계단에서부터 연속 3개 계단이 안되므로 2개씩 더해 비교(자기 자신을 포함)
			memo[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
		}
		for(int i = 4 ; i <= N ; i++) {		// 네번째 계단부터는 두 가지를 비교해 저장
			memo[i] = Math.max(memo[i - 2], memo[i - 3] + stair[i - 1]) + stair[i];
		}	
		System.out.println(memo[N]);		
	}
}
