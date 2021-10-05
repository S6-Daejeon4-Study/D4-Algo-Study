package im_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nan = new int[9];//난쟁이를 넣을 배열
		int sum = 0;//난쟁이 키의 합
		
		for(int i = 0; i < 9; i++) {//난쟁이 키 저장
			nan[i] = Integer.parseInt(br.readLine());
			
			sum += nan[i];//난쟁이 키의 합.
		}
		
		Arrays.sort(nan);//오름차순 정렬.
		
		for(int i = 0; i < 8; i++) {//난쟁이 9명중 2명의 키의 합을 다 확인.
			for(int j = i+1; j < 9; j++) {
				if(sum - (nan[i]+nan[j])==100){//전체 합에서 두 명의 합을 뺀게 100이면.
					for(int k = 0; k < nan.length; k++) {
						if(nan[i] != nan[k] && nan[j] != nan[k])//나머지 난쟁이의 키를 출력
							System.out.println(nan[k]);
					}
					return;
				}
			}
		}
	}
}
