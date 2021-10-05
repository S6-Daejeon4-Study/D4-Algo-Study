package algo;

import java.util.LinkedList;
import java.util.Scanner;

public class boj2346 {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int n=0;n<N;n++) {
			list.add(sc.nextInt());
		}
		
		int idx = 0;
		
		while(list.size()!=0) {
			System.out.println(idx+1);
			int jump = list.get(idx);
			list.remove(idx);
			idx = (idx + jump)%list.size();
			if(idx<0) {
				idx = list.size()+idx;
			}
		}

	}

}
