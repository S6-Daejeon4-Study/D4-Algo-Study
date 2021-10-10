package programmers;

public class Solution_가장긴팰린드롬 {
    public int solution(String s)
    {
        int max = 1;
        for(int c=0; c<s.length()-1;c++){
            if(s.charAt(c)==s.charAt(c+1)) max = Math.max(check(c,c+1, s),max);
            if(c>0 &&s.charAt(c-1)==s.charAt(c+1)) max = Math.max(check(c-1,c+1, s),max);
        }
        return max;
    }

    public int check(int i,int j, String s){
        int p=j-i-1;

        while(true){
            if(i<0 || j>= s.length()) break;
            if(s.charAt(i)==s.charAt(j)){
                p+=2;
                i--;
                j++;
            } else break;
        }
        return p;
    }
}
  문제 풀이 컨셉
  1. 재귀로 접근
  2. 가운데 기준으로 하는거(길이가 홀수인 팰린드롬)랑 아닌거(길이가 짝수인 팰린드롬)랑 나누기.
  3. 0번쨰 인덱스부터 크기(size)-1 까지 돌면서 홀수인 경우 짝수인 경우 중 큰거로 answer 업데이트
  4. answer 출력


  맨 처음 "abba" 의 경우를 생각 못하고
  테스트케이스 처럼 가운데 기준으로 앞뒤가 같은것만 갯수 세고 있었음
 *
 * */
/**
