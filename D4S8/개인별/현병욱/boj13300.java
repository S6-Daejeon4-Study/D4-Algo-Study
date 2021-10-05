package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수 
		int K = Integer.parseInt(st.nextToken()); // 최대 인원 수 
		
		int[] boy = new int[6];
		int[] girls = new int[6];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			if(S == 0) {
				girls[Y-1]++;
			}else {
				boy[Y-1]++;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 6; i++) {
			if(boy[i]%K == 0) {
				cnt += boy[i]/K;
			}else {
				cnt += boy[i]/K + 1;
			}
		}
		
		for(int i = 0; i < 6; i++) {
			if(girls[i]%K == 0) {
				cnt += girls[i]/K;
			}else {
				cnt += girls[i]/K + 1;
			}
		}
		
		System.out.println(cnt);
	}
}
