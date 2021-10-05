package day0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17827 {
	static int[] snail = new int[200001];
	static int N, M, V;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 노드 개수  
		M = Integer.parseInt(st.nextToken()); // 질문의 횟수
		V = Integer.parseInt(st.nextToken()); // 마지막 노드가 가리키는 노드의 번호 
		
		
		
		// 달팽이 입력 
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			snail[i] = Integer.parseInt(st.nextToken());	
		}
		
		int l = N - V + 1;
		for(int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp < N) {
				sb.append(snail[tmp] + "\n");
//				System.out.println(snail.get(tmp));
			}else {
				sb.append(snail[(tmp-V+1) % l + V - 1] + "\n");
//				System.out.println(snail.get((tmp-N)%(N-V+1) + V-1));
			}
		}
		System.out.println(sb.toString());
	}

}