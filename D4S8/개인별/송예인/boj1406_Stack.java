package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj1406_Stack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		Stack<String> st_l = new Stack<>();
		Stack<String> st_r = new Stack<>();
		//왼쪽 스택에 입력받은 문자열을 넣는다.
		
		for(int i=0;i<str.length();i++) {
			st_l.push(str.substring(i,i+1));
		}
		
		//커서를 기준으로 왼쪽과 오른쪽 스택을 나눌 예정
		//l = abc , r = d
		for(int m=0;m<M;m++) {
			StringTokenizer stn_action = new StringTokenizer(br.readLine());
			String s = stn_action.nextToken();
			switch(s) {
			case "L":
				if(st_l.isEmpty()) continue;
				st_r.push(st_l.pop());
				break;
			case "D":
				if(st_r.isEmpty()) continue;
				st_l.push(st_r.pop());
				break;
			case "B":
				if(st_l.isEmpty()) continue;
				st_l.pop();
				break;
			case "P":
				st_l.push(stn_action.nextToken());
				break;
			}
			
		}
		//왼쪽 스택에 있는 내용을 모두 오른쪽에 옮긴다음 
		//오른쪽 스택을 출력함
		while(!st_l.isEmpty()) {
			st_r.add(st_l.pop());
		}
		
		// <출력하는 방식1>
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		while(!st_r.isEmpty()) {
//			bw.write(st_r.pop());
//		}
		
		//<출력하는 방식2>
		//런타임 에러 -> 출력량이 입력량 급으로 혹은 더 이상 많기 때문에 stirngbulder를 쓰는게 효과적!
//		while(!st_r.isEmpty()) {
//			System.out.print(st_r.pop());
//		}
//		bw.flush();
//		bw.close();
		
		//<출력하는 방식3>
		StringBuilder sb = new StringBuilder();
		while(!st_r.isEmpty()) {
			sb.append(st_r.pop());
		}
		System.out.println(sb.toString());
		
		
		

	}

}
