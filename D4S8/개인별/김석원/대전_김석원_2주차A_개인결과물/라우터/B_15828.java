package 라우터;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 첫 줄에는 라우터 내부에 존재하는 버퍼의 크기를 나타내는 자연수 N이 주어진다.

둘째 줄부터 한 줄에 하나씩 라우터가 처리해야 할 정보가 주어진다. 모든 정보는 발생한 시간순으로 주어졌다고 가정한다. 
양의 정수는 해당하는 번호의 패킷이 입력으로 들어왔다는 것을 의미하고, 0은 라우터가 패킷 하나를 처리했다는 것을 의미한다. 
이때, 버퍼가 비어있을때는 0이 입력으로 들어오지 않는다. -1은 입력의 끝을 나타낸다.
 */
public class B_15828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> buf = new LinkedList<Integer>();
		StringBuilder st = new StringBuilder();
		//버퍼 갯수 N을 입력받는다.
		int N = sc.nextInt();
		//-1 을 입력받으면 종료하고, 0을 입력받으면 라우터로 전송해 큐를 하니 비운다.
		while(true) {
			int n = sc.nextInt();
			if( n == -1) break;
			if( n == 0) { buf.poll();
			continue;
			}
			if(buf.size() < N ) {
				buf.offer(n);
			}
		}
		//-1입력받았을때 큐가 비지않았다면 전부 출력
		if(buf.isEmpty()) System.out.println("empty");
		
		else {
			while(!buf.isEmpty()) {
				st.append(buf.poll() + " ");
			}
			System.out.println(st);
		}
	}
}
