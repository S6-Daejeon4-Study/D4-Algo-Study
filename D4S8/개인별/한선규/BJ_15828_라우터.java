package com.ssafy.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author comkkyu
 * @date 21. 8. 10
 * 
 * 백준 15825 - 라우터 (큐 - 숙련자)
 * https://www.acmicpc.net/problem/15828
 *
 */
public class BJ_15828_라우터 {
	
	static int bufferSize; // 현재 버퍼 사이즈

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> buffer = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		while (true) {
			String input = br.readLine();
			
			if (input.equals("-1")) break; // 종료조건 -1
			if (bufferSize >= N && !input.equals("0")) continue; // 버퍼처리 입력(0)이 아니고 이미 버퍼가 다 차있을 때 들어오는 입력은 모두 버린다.
			if (!input.equals("0")) { // 양의 정수는 해당 번호로 버퍼에 추가
				buffer.add(input);
				bufferSize++;
			} else {
				if (!buffer.isEmpty()) { // 0이 입력되었다면 가장 먼저 버퍼에 들어온 패킷에 대한 작업을 처리
					buffer.poll();
					bufferSize--;
				}
			}
		}
		
		String result = buffer.isEmpty() ? "empty" : String.join(" ", buffer);
		
		System.out.println(result);
	}

}
