package week2;

import java.util.Scanner;

public class P42584_주식가격 {

	public static int[] solution(int[] prices) { 
		// answer: 가격이 떨어지지 않은 기간 저장
		// prices의 인덱스=초로 생각
		int[] answer=new int[prices.length]; 
		
		for(int index=0; index<prices.length;index++) { // prices 각 인덱스마다 자기보다 작은 게 언제 처음으로 나오는지 저장
			int check=index; // check: 자기보다 작은 게 언제 처음으로 나오는지 저장
			
			while(true) { // 자기보다 작은 값을 찾을 때까지
				if(check==prices.length-1) break; // 끝날 때까지 자기보다 작은 게 없는 경우 while 탈출
				if(prices[check]<prices[index]) break; // 자기보다 작은 값을 찾은 경우 while 탈출
				check++; // 자기보다 작은 것 찾지 못했으면 다음 위치 탐색
			}
			
			answer[index]=check-index; // 자기보다 작은 게 처음 나오는 초-현재=가격이 떨어지지 않은 기간
		}
		
		return answer;
	}

	public static void main(String[] args) {
		
		int[] prices= {1,2,3,2,3};
		int[] answer=solution(prices);
		
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
	}
}
