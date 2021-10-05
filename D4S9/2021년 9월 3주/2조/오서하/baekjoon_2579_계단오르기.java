import java.util.Scanner;

public class baekjoon_2579_계단오르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] stair = new int[N];
		int[][] d = new int[2][N];

		for (int i = 0; i < N; i++) {
			stair[i] = sc.nextInt();
		}
		
		if(N < 2) { //  1이라면
			System.out.println(stair[N-1]);
		}
		else if(N >= 2) {			
			d[0][0] = stair[0];
			d[0][1] = stair[1];
			d[1][1] = d[0][0] +  stair[1];
			
			for(int i = 2 ; i < N ; i++) {
				d[1][i] = d[0][i-1] + stair[i];
				d[0][i] = Math.max(d[0][i-2], d[1][i-2]) + stair[i];
			}
			System.out.println(Math.max(d[0][N-1], d[1][N-1]));
		}
	}
}
