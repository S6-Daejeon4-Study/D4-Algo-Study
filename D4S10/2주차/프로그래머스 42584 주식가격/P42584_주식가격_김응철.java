import java.util.*;

import java.io.*;

public class Solution_주식가격 {

	// price[]로 인풋이 들어오면 같은 크기의 answer[]에서 초 적어주기.

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };

		int[] result = new int[5];

		result = solution(prices);

		for (int i = 0; i < 5; i++) {

			System.out.print(result[i] + " ");

		}

	}

	public static int[] solution(int[] prices) {

		int[] answer = {};

		answer = new int[prices.length];

		for (int i = 0; i < prices.length - 1; i++) {

			answer[i] = bf(prices, prices[i], i + 1, 0);

		}

		return answer;

	}

	private static int bf(int[] prices, int start, int i, int cnt) {

		if (prices[i] < start || i == prices.length - 1)

			return cnt + 1;

		return bf(prices, start, i + 1, cnt + 1);

	}

}