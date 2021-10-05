
import java.util.Scanner;
//완전탐색
public class BOJ_1182 {
	static int N, S;
	static int[] arr;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		dfs(0, 0);
		//S가 0일 경우 0인 공집합은 빼줘야 하기 때문에 -1
		System.out.println(S == 0 ? ans - 1 : ans);

	}

	private static void dfs(int dep, int sum) {
		//깊이가 N일경우 계산
		if (dep == N) {
			//부분집합의 합이 S와 같을때
			if (sum == S)
				//1증가
				ans++;
			return;
		}
		//다음숫자 선택
		dfs(dep + 1, sum + arr[dep]);
		//다음숫자 선택안함
		dfs(dep + 1, sum);
	}
}