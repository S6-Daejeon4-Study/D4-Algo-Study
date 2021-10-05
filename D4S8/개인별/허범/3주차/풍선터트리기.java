package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 풍선터트리기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Queue<balloon> queue = new LinkedList<>();//풍선을 저장할 큐 생성.
		
		int N = Integer.parseInt(br.readLine());//풍선의 개수 입력받기.
		
		st = new StringTokenizer(br.readLine());//풍선안에 적힌 수 받기위해 자름.
		
		for(int i = 1; i <= N; i++) {
			queue.offer(new balloon(i, Integer.parseInt(st.nextToken())));//하나씩 큐에 저장.
		}
		int num = queue.poll().val;//맨 앞 값을 빼고 값을 변수에 저장.
		sb.append(1 + " ");//빌더에 1과 공백을 더해줌.
				
		while (!queue.isEmpty()) {//큐가 빌때까지 반복.
			if(num > 1) {//앞에서 받은 풍선의 값이 양수이면
				num = (num-1)%queue.size();//이미 풍선을 뺏으니 -1.
				while(num-->0)//값이 0이 될때까지 큐에서 빼서 다시 넣어줌.
					queue.offer(queue.poll());
			}else if(num<0){//값이 음수일 경우.
				num %= queue.size();
				num += queue.size();
				while(num-->0)//값이 0이 될때까지 큐에서 빼서 다시 넣어줌.
					queue.offer(queue.poll());
			}
			num = queue.peek().val;//다음 터뜨릴 풍선의 값을 변수에 저장하고.
			sb.append(queue.poll().index + " ");//빌더에 위치를 붙이고 풍선 제거
		}
		System.out.println(sb);//빌더를 출력.
	}
	
	static class balloon{
		int index, val;//풍선 클래스에 위치와 풍선에 넣어있는 값을 저장.
		
		balloon(int index, int val){
			this.index = index;
			this.val = val;
		}
	}
}