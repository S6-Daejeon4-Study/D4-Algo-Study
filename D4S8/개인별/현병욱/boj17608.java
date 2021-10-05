package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj17608 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] stick = new int[N+1];
		
		for(int i = 0; i < N; i++) {
			stick[i] = Integer.parseInt(br.readLine());
		}
		
		int maxHeight = 0;
		int cnt = 0;
		
		for(int i = N-1; i >= 0; i--) {
			if(stick[i] > maxHeight) {
				cnt++;
				maxHeight = stick[i];
			}
		}
		
		System.out.println(cnt);
		
	}
}
