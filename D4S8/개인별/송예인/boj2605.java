package algo;

import java.util.LinkedList;
import java.util.Scanner;

public class boj2605 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		for(int n=0;n<N;n++) {
			int jump = sc.nextInt();
			if(n==0) {
				list.add(1);
				continue;
			}
			list.add(list.size()-jump, n+1);// 현재 링크드 리스틔 길이의 뒤에서 jump번째에 값을 삽입
		}
		
		//출력
		for(int i=0;i<N;i++) {
			System.out.print(list.get(i)+" ");
		}

	}

}
