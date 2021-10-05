package study02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Warehouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> st = new Stack<>();

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		pillar[] p = new pillar[t];

		for (int i = 0; i < t; i++) {
			p[i] = new pillar();

			p[i].pos = sc.nextInt();
			p[i].h = sc.nextInt();

		}
		for (int i = 0; i < p.length; i++) {
			Arrays.sort(p); // 위치로 객체 정렬
		}

		int idx = 0;
		int sum = 0;
		int dir = 0;

		int max = 0;
		
		// 최대 높이 찾기
		for (int i = 0; i < p.length; i++) {
			max = Math.max(p[i].h, max);
		}
		

		while (true) {

			if ((idx+1 ) == t) {
				break;
			}
			

			if (dir == 0) { // 올라가는 방향
				if (p[idx + 1].h > p[idx].h) {//오른쪽 기둥이 왼쪽보다 크면
					sum += p[idx].h * (p[idx + 1].pos - p[idx].pos); //넓이를 계산후 추가
				} else {// 그렇지 않다면 
					p[idx + 1].pos = p[idx].pos; //넓이 계산을 위해 왼쪽 기둥의 위치를 오른쪽기둥의 위치로 변환
					p[idx+1].h=p[idx].h;
				}

			}

			if (p[idx].h == max) {// 기둥의 높이가 최대일 때 
				
				dir = 1;
				st.push(p[idx].pos);
				int width=0;
				if(st.size()>1) {
					width=st.pop()-st.peek();
				}
				sum+=max+max*(width);
				
			}

			
//			if (dir == 1) {// 내려가는 방향
//				if (p[idx + 1].h < p[idx].h) {
//					sum += p[idx + 1].h * (p[idx + 1].pos - p[idx].pos);
//				}
//				else {// 그렇지 않다면 
//					p[idx + 1].pos = p[idx].pos; //넓이 계산을 위해 왼쪽 기둥의 위치를 오른쪽기둥의 위치로 변환
//				}
//				
//			}

			System.out.println(idx+" "+sum);

			idx++;
			

		}

//		System.out.println(sum);

	}

}

class pillar implements Comparable<pillar> { // 정렬을 위해 compareto 구현

	int pos;
	int h;

	@Override
	public int compareTo(pillar o) {
		// TODO Auto-generated method stub

		if (o.pos < this.pos) {

			return 1;
		} else if (o.pos > this.pos) {

			return -1;
		}

		return 0;
	}

}