package day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	static int N;//숫자 개수.
	static int[] arr;//숫자를 넣을 배열.
	static int[] oper;//연산자를 넣을 배열.

	static int MAX = Integer.MIN_VALUE;//최대값 비교를 위해.
	static int MIN = Integer.MAX_VALUE;//최솟값 비교를 위해.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());//숫자 개수 입력 받음.
		arr = new int[N];

		//숫자를 배열에 입력.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		//연산자를 배열에 입력.
		oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			oper[i] = Integer.parseInt(st.nextToken());

		DFS(arr[0], 1);

		System.out.println(MAX);
		System.out.println(MIN);
	}

	public static void DFS(int num, int index) {
		if (index == N) {
			MAX = Math.max(MAX, num);//최대값을 MAX에 저장.
			MIN = Math.min(MIN, num);//최솟값을 MIN에 저장.
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (oper[i] > 0) {
				oper[i]--;//연산자 사용.

				if (i == 0)
					DFS(num + arr[index], index + 1);
				else if (i == 1)
					DFS(num - arr[index], index + 1);
				else if (i == 2)
					DFS(num * arr[index], index + 1);
				else if (i == 3)
					DFS(num / arr[index], index + 1);
				
				oper[i]++;//다음 dfs계산을 위해 다시 연산자 넣어줌.
			}
		}
	}
}
