import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방배정_13300 {
	static int N, K, ans;
	static int[][] room;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		room = new int[7][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());

			room[grade][gender]++;
		}
		ans = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				if (room[i][j] > 0)
					ans += (room[i][j] / K) + ((room[i][j] % K) == 0 ? 0 : 1);
			}
		}
		System.out.println(ans);
	}
}
