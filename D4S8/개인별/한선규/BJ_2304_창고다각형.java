package com.ssafy.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 
 * @author comkkyu
 * @date 21. 7. 29
 * 
 * 백준 2304 - 창고 다각형
 * https://www.acmicpc.net/problem/2304
 *
 */
public class BJ_2304_창고다각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 기둥 개수
		ArrayList<Pillar> pillars = new ArrayList<>();
		
		// N 개의 기둥 정보를 list에 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); // 기둥 왼쪽 면의 위치
			int H = Integer.parseInt(st.nextToken()); // 기둥 높이
			
			pillars.add(new Pillar(L, H));
		}
		
		Collections.sort(pillars);
		
		int maxHeight = 0; // 가장 높은 기둥의 높이
		int maxPos = 0; // 가장 높은 기둥의 위치
		
		// 가장 높은 기둥의 높이와 왼쪽 좌표 탐색
		for (int i = 0; i < N; i++) {
			int height = pillars.get(i).height;
			
			if (maxHeight < height) {
				maxHeight = height;
				maxPos = i;
			}
		}
		
		int area = maxHeight; // 창고 다각형 면적
		
		// 가장 높은 기둥을 기준으로 왼쪽 방향 탐색
		int leftPos = maxPos;
		while (leftPos > 0) {
			Pillar now = pillars.get(leftPos);
			Pillar next = null;
			
			int leftMaxHeight = 0;
			
			for (int i = leftPos - 1; i >= 0; i--) {
				int height = pillars.get(i).height;
				
				if (height > leftMaxHeight) { // 지금 탐색하는 기둥의 높이 중에서 최대 높이의 기둥의 정보를 탐색
					leftMaxHeight = height;
					leftPos = i;
					next = pillars.get(i);
				}
			}
			
			area += (now.left - next.left) * leftMaxHeight;
		}
		
		// 가장 높은 기둥을 기준으로 오른쪽 방향 탐색
		int rightPos = maxPos;
		while (rightPos < N - 1) {
			Pillar now = pillars.get(rightPos);
			Pillar next = null;
			
			int rightMaxHeight = 0;
			
			for (int i = rightPos + 1; i < N; i++) {
				int height = pillars.get(i).height;
				
				if (height > rightMaxHeight) { // 지금 탐색하는 기둥의 높이 중에서 최대 높이의 기둥의 정보를 탐색
					rightMaxHeight = height;
					rightPos = i;
					next = pillars.get(i);
				}
			}
			
			area += (next.right - now.right) * rightMaxHeight;
		}
		
		System.out.println(area);
	}

}

// 기둥 정보를 가지고 있는 클래스
class Pillar implements Comparable<Pillar> {
	int left;
	int right;
	int height;
	
	public Pillar(int left, int height) { // 기둥의 좌표와 높이를 가지는 생성자
		this.left = left;
		this.right = left + 1;
		this.height = height;
	}

	@Override
	public int compareTo(Pillar o) { // 동일한 위치에 대한 기둥정보가 들어오진 않으므로 크고 작은지만 비교
		return this.left < o.left ? -1 : 1;
	}
}
