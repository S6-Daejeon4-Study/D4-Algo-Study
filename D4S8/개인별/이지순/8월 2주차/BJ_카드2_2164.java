import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_카드2_2164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1;i<=N;i++) {
			queue.offer(i);
		}
		
		while(queue.size()>1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.println(queue.poll());
	}

}
