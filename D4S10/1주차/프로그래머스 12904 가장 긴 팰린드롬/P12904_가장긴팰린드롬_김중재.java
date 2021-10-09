package month10.study.week1;

/*
 * "abcdcba"	7
	"abacde"	3
 * */

/**
 * 문제 풀이 컨셉
 * 1. 재귀로 접근
 * 2. 가운데 기준으로 하는거(길이가 홀수인 팰린드롬)랑 아닌거(길이가 짝수인 팰린드롬)랑 나누기.
 * 3. 0번쨰 인덱스부터 크기(size)-1 까지 돌면서 홀수인 경우 짝수인 경우 중 큰거로 answer 업데이트
 * 4. answer 출력
 * 
 * 
 * 맨 처음 "abba" 의 경우를 생각 못하고 
 * 테스트케이스 처럼 가운데 기준으로 앞뒤가 같은것만 갯수 세고 있었음
 * 
 * */

public class Programmers_가장긴팰린드롬 {
	static char[] str;
	static int cnt;
	
	public static void main(String[] args) {
		System.out.println(solution("abba"));
	}

	public static int solution(String s)
    {
        int answer = Integer.MIN_VALUE;
        if(s.length() == 1) {
        	return 1;
        }
        str = s.toCharArray();

        for(int i=0;i<str.length-1;i++) {
        	cnt = 0;
        	answer = Math.max(answer, check(i-1,i+1) * 2 +1);
        	cnt = 0;
        	answer = Math.max(answer, check(i,i+1) * 2);
        }

        return answer;
    }

	private static int check(int bNum, int nNum) {
		if(bNum == -1 || nNum == str.length || str[bNum] != str[nNum])
			return cnt;
		cnt++;
		check(bNum-1,nNum+1);
		return cnt;
	}
}