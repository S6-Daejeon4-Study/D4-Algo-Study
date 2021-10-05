
package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj3985_롤케이크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int L = Integer.parseInt(br.readLine()); // L미터 롤 케이크 
		int N = Integer.parseInt(br.readLine()); // 방청객 
		
		int[] slice = new int[L+1];
		for(int i = 0; i < slice.length; i++) {
			slice[i] = 0;
		}
		int sum = 0;
		int person1 = 0;
		int[] ck = new int[N];
		int person2 = 0;
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			if(K-P > sum) {
				sum = K-P;
				person1 = i;
			}
			int cnt = 0;
			for(int j = P; j <= K; j++) {
				if(slice[j] == 0) {
					slice[j] = i;
					cnt++;
				}
			}
			ck[i-1] = cnt;
		}
		
		int temp = 0;
		int temp2 = 0;
		for(int i = 0; i < N; i++) {
			if(ck[i] > temp) {
				temp = ck[i];
				temp2 = i;
			}else if(ck[i] == temp) {
				if(i < temp2) {
					temp2 = i;
				}
			}
		}
		
		
		System.out.println(person1);
		System.out.println(temp2+1);
		
		
	}
}




/*

김상근 : L미터의 롤 케이크 만들어서 N명에게 나눠준다. 
L미터의 롤 케이크를 1미터 단위로 잘랐다. 
가장 왼쪽 조각이 1번, 가장 오른쪽 조각이 L번 조각이다. 


방청객은 1번부터 N번까지 있음.
방청객은 자신이 원하는 조각을 적어서 낸다. -> P번 조각부터 K번 조각을 원한다고 적어서 냄. 


고창영 : 1번 방청객의 종이부터 순서대로 펼쳐서 해당하는 조각에 그 사람의 번호를 적을 것이다. 
이미 적혀있는 번호는 적지 못함. 

가장 많은 케이크 조각을 받을 것으로 기대한 방청객의 번호 : P와 K 사이 최대  
실제로 가장 많은 케이크 조각을 받은 방청객의 번호 : 

*/