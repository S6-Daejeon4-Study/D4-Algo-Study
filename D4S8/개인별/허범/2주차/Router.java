package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Router {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//버퍼의 크기 입력받음
		int N = Integer.parseInt(br.readLine());
		
		//패킷을 저장할 큐 생성.
		Queue<Integer> queue = new LinkedList<>();
		
		//패킷을 저장할 변수.
		int packet = 0;
		
		//-1이 들어오기 전까지 반복.
		while(packet!=-1) {
			//패킷 입력 받음.
			packet = Integer.parseInt(br.readLine());
			//입력값이 0이면 큐에서 제거.
			if(packet==0) {
				queue.poll();
				//아니면 큐에 저장.
			}else {
				if(packet > 0 && queue.size()<N) {
					queue.offer(packet);
				}
			}
		}
		//큐가 비어있으면 empty 출력.
		if(queue.isEmpty())
			System.out.println("empty");
		//아니면 큐에 있는 값 출력.
		else {
			while(queue.size()>0)
				System.out.print(queue.poll() + " ");
		}
	}
}
