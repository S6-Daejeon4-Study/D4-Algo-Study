import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_Router_15828 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int buffer_size = sc.nextInt();

		Queue<Integer> queue = new LinkedList<Integer>();
		while (true) {
			int next = sc.nextInt();
			if (next == -1)
				break;
			if (next == 0) {
				queue.poll();
			} else {
				if (queue.size() < buffer_size)
					queue.add(next);
				else
					continue;
			}
		}
		if (queue.isEmpty())
			System.out.println("empty");
		else {
			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
		}
	}

}
