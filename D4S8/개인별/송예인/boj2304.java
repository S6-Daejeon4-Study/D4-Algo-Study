package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class boj2304 {
	static class Pillar implements Comparable<Pillar>{
		int idx;
		int h;
		Pillar(int idx, int h){
			this.idx = idx;
			this.h = h;
		}
		@Override
		public int compareTo(Pillar o) {
			return idx-o.idx;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pillar[] pillar = new Pillar[N];
		for(int n=0;n<N;n++) {
			pillar[n] = new Pillar(sc.nextInt(),sc.nextInt());
		}//--> input 완료
		
		Arrays.sort(pillar); // 기둥 인덱스로 정렬
		
		//tallest 구하기
	    int tallest = 0, tallest_idx_r = 0, tallest_idx_l = 0; // 높이랑 인덱스
	    for(int n=0;n<N;n++) {
	    	tallest = tallest>pillar[n].h?tallest:pillar[n].h;
	    	if(tallest==pillar[n].h) {
	    		if(tallest_idx_l==0) {// 맨 처음 들어온거 왼쪽 인덱스로 저장
	    			tallest_idx_l = pillar[n].idx; 	    			
	    		}
	    		tallest_idx_r = pillar[n].idx;// 가장 오른쪽 인덱스 저장
	    	}
	    }
	   
	    //기둥 스택에 저장하기
	    //첫번째 기둥과 마지막 기둥은 무조건 저장
	    Stack<Pillar> st = new Stack<>();
	    st.add(pillar[0]);// 첫번째 기둥은 무조건 저
		for(int n=1;n<N-1;n++) {
			if(pillar[n].idx<tallest_idx_l) {
				System.out.println("??");
				if(pillar[n].h>st.peek().h) {
					if(st.peek().idx!=pillar[0].idx) st.pop();
					st.push(pillar[n]);
					System.out.println(pillar[n].idx);
				}
			}else {
				if(st.peek().h<pillar[n].h) {
					st.pop();
					st.push(pillar[n]);
				}
			}
		}
		//마지막 기둥 포함 안되어있으면 넣어주기
		if(st.peek().idx!=pillar[pillar.length-1].idx) st.push(pillar[pillar.length-1]);
		
		
		
		//높이 관계에 따라 넓이 저장
		int area = 0;
		Pillar last_p = pillar[0];
		while(!st.isEmpty()) {
			Pillar p = st.pop();
			System.out.println(p.idx);
			//오른쪽
			if(p.idx>tallest_idx_r) {
				area+= (p.idx - st.peek().idx)*p.h;
			}
			
			//왼쪽
			if(p.idx<tallest_idx_l) {
				area+= (last_p.idx-p.idx)*p.h;
			}
			
			last_p = p;
			//System.out.println(p.idx +" "+area);
		}
		
		area += tallest*(tallest_idx_r-tallest_idx_l);
		
		System.out.println(area);

	}

}
