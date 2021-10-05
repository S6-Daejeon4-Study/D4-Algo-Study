package bfs;
import java.io.*;
import java.util.*;

public class Main_숨바꼭질_1697 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[201000];

		queue.offer(N);
		visit[N] = true;

		int cnt = 0,flag = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();//poll 하면 사이즈 작아져서 미리 int 변수에 담아 둠.
			
			for (int s = 0; s <size; s++) {
				int num = queue.poll();

				if (num < 0 || num > 100000)
					continue;
				
				if (num == K) {//break 두번해야 하기 때문에 체크해줌
					flag = 1;
					break;
				}
				
				if (!visit[num * 2]) {
					queue.offer(num * 2);
					visit[num * 2] = true;
				}

				if (num!=0 && !visit[num - 1]) {
					queue.offer(num - 1);
					visit[num - 1] = true;
				}

				if (!visit[num + 1]) {
					queue.offer(num + 1);
					visit[num + 1] = true;
				}
			}
			if(flag == 1)//break해서 나왔다면 while문도 바로 탈출하기.
				break;
			cnt++;
		}

		System.out.println(cnt);
	}

}
