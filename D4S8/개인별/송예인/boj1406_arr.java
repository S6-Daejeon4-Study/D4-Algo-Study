package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1406_arr {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st_arr = br.readLine().split("");
		String[] arr = new String[600000];
		for(int i=0;i<st_arr.length;i++) {
			arr[i] = st_arr[i];
		}
		int cnt = st_arr.length;//커서 위치
		int end = st_arr.length;//배열의 끝
		
		int N = Integer.parseInt(br.readLine());
		for(int n=0;n<N;n++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			String s = stn.nextToken();
			switch(s) {
			case "L":
				if(cnt>0) cnt--; 
				break;
			case "D":
				if(cnt!=end) cnt++;
				break;
			case "B":
				if(cnt>0) {
					if(cnt==end) {
						arr[cnt-1] = null;
					}else {
						for(int i=cnt-1;i<end-1;i++) {
							arr[i] = arr[i+1];
						}
						arr[end-1] = null;
					}
					//arr[cnt-1]삭제
					cnt--;
					end--;
				}
				break;
			case "P":
				if(end==cnt) {
					arr[cnt] = stn.nextToken();
				}else {
					for(int i=end;i>cnt;i--) {
						arr[i] = arr[i-1];
					}					
					arr[cnt] = stn.nextToken();
				}
				cnt++;
				end++;
				break;
			}
			
		}
		//arr 배열에 있는것 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<end;i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb.toString());

	}

}
