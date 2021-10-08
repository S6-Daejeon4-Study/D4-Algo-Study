import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2531 { 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();

		int[] arr = new int[N];
		int[] num = new int[N]; // 해당 인덱스로부터 k개 먹었을 때, 얼마나 다양하게 먹을 수 있는지 카운트 저장

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = Integer.MIN_VALUE;
		Queue<Integer> queue = new LinkedList<Integer>();
		int i = 0;
		while (num[N - 1] == 0) { // 마지막 초밥까지 고려했을 때까지
			if (i == N)
				i = 0;
			if (queue.size() == k) {
				int idx = i - k;
				if (idx < 0)
					idx = N + idx;

				boolean[] visit = new boolean[d + 1];

				Iterator it = queue.iterator();
				while (it.hasNext()) {
					visit[(int) it.next()] = true;
				}
				int cnt = getCnt(visit);

				if (!visit[c])
					cnt = cnt + 1;
				num[idx] = cnt;
				ans = Math.max(ans, cnt);
				queue.poll();
			}
			queue.add(arr[i]);
			i++;
		}
		System.out.println(ans);
	}

	static int getCnt(boolean[] visit) {
		int cnt = 0;
		for (int i = 0; i < visit.length; i++) {
			if (visit[i])
				cnt = cnt + 1;
		}
		return cnt;
	}

}
