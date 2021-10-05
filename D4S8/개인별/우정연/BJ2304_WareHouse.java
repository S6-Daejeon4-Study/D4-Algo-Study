package day0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2304_WareHouse {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Pole[] poles = new Pole[N];		// 기둥을 저장할 배열
		StringTokenizer st;
		int l, max = -1, leftMaxIdx = 0, rightMaxIdx = N - 1;	
		for(int i = 0 ; i < N ; i++) {		// 기둥을 입력받음
			st = new StringTokenizer(in.readLine());
			poles[i] = new Pole(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(poles);	// poles를 인덱스 기준으로 정렬함	
		for(int i = 0 ; i < N ; i++) {		// 왼쪽 가장 높은 기둥의 인덱스(기둥 배열에서의 인덱스)를 저장
			if(poles[i].height == max) {
				leftMaxIdx = i;
				break;
			}
		}
		for(int i = N - 1 ; i >= 0 ; i--) {	
			if(poles[i].height == max) {	// 오른쪽 가장 높은 기둥의 인덱스를 저장
				rightMaxIdx = i;
				break;
			}
		}
		int area = 0;			// 다각형 면적
		int lastIdx = 0;		// 이전 인덱스
		for(int i = 1 ; i <= leftMaxIdx ; i++) {		// 왼쪽부터 왼쪽 가장 높은 기둥까지, poles 배열의 인덱스
			if(poles[lastIdx].height <= poles[i].height) {		// 더 높은 기둥을 찾으면
				area += poles[lastIdx].height * (poles[i].idx - poles[lastIdx].idx); // 전 기둥부터 지금 바로 전 기둥까지의 다각형 면적 더함
				lastIdx = i;	// 이번 기둥 인덱스를 이전으로 저장
			}
		}
		lastIdx = N - 1;
		int a = 0;
		for(int i = N - 2 ; i >= rightMaxIdx ; i--) {	// 오른쪽부터 오른쪽 가장 높은 기둥까지
			if(poles[lastIdx].height <= poles[i].height) {		// 더 높은 기둥을 찾으면
				area += poles[lastIdx].height * (poles[lastIdx].idx - poles[i].idx); // 전 기둥부터 지금 바로 전 기둥까지의 다각형 면적 더함
				lastIdx = i;	// 이번 기둥 인덱스를 이전으로 저장
			}
		}
		area += poles[leftMaxIdx].height;	// 가장 높은 기둥을 더함
		if(leftMaxIdx != rightMaxIdx) {		// 가장 높은 기둥이 여러개이면
			area += poles[leftMaxIdx].height * (poles[rightMaxIdx].idx - poles[leftMaxIdx].idx);	// 그 사이 면적 더함
		}
		System.out.println(area);	// 결과를 출력
	}
	static class Pole implements Comparable<Pole>{		// 기둥 클래스
		int idx;	// 인덱스
		int height;	// 높이
		public Pole(int idx, int height) {	
			this.idx = idx;
			this.height = height;
		}
		@Override
		public int compareTo(Pole o) {	// 인덱스로 정렬하기 위해 compareTo 메소드 구현
			int sub = this.idx - o.idx;
			if(sub > 0) return 1;
			else if(sub < 0) return -1;
			else return 0;
		}
	}
}
