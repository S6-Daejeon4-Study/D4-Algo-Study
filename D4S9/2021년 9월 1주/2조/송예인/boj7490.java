package day0909;

import java.util.Scanner;

public class boj7490 {
	static int N;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=0;tc<TC;tc++) {
			N = sc.nextInt();//3
			
			dfs(1,1,'+',"1");
			dfs(1,1,'-',"1");
			dfs(1,1,' ',"1");
			
			
		}

	}
	
	// 1 2 3 -> 3^2 
	// 1 2 3 4... 7 -> 3^6
	
	

	private static void dfs(int idx, int total, char c,String s) {
		//탈출조건
		if(idx==N) {
			count +=1;
			if(total==0 && count ==1) {
				System.out.println(s);
			}
			if(count == 3) {
				count = 0;
			}
			return;
		}
		
		
		if(c=='+') {
			dfs(idx+1,total+idx+1,'+',s+"+"+Integer.toString(idx+1));
			dfs(idx+1,total+idx+1,'-',s+"+"+Integer.toString(idx+1));
			dfs(idx+1,total+idx+1,' ',s+"+"+Integer.toString(idx+1));
		}else if(c=='-') {
			dfs(idx+1,total-(idx+1),'+',s+"-"+Integer.toString(idx+1));
			dfs(idx+1,total-(idx+1),'-',s+"-"+Integer.toString(idx+1));
			dfs(idx+1,total-(idx+1),' ',s+"-"+Integer.toString(idx+1));
		}else {
			dfs(idx+1,total*10+(idx+1),'+',s+" "+Integer.toString(idx+1));
			dfs(idx+1,total*10+(idx+1),'-',s+" "+Integer.toString(idx+1));
			dfs(idx+1,total*10+(idx+1),' ',s+" "+Integer.toString(idx+1));
		}
		
	}

}
