package day1015;

public class PRO_주식가격 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];//정답을 담을 배열.

		//for문 2개를 돌면서 앞뒤 값을 비교.
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				answer[i]++;//시간 추가.
				if (prices[i] > prices[j])//가격이 떨어지면
					break;//탈출.
			}
		}
		return answer;
	}
}
