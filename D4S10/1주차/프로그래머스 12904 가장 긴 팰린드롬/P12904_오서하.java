
public class P12904_오서하 {
	class Solution // 이 풀이는 좀 더 진행되어야 함 -> 반례 존재
	{
	    public int solution(String s)
	    {
	        int answer = 0;
	        char[] arr = new char[s.length()];
	        for(int i = 0 ; i < s.length(); i++){

	            arr[i] = s.charAt(i);
	            int tmp = decision(arr, i+1);
	            answer = Math.max(answer, tmp);
	        }
	        return answer;
	    }
	    
	    public int decision(char[] arr, int arr_len){
	        if(arr_len == 1){
	            return 1;
	        }
	        
	        int half = arr_len/2;
	        int cnt = 0, back = 0;
	        
	        for(int front = 0 ; front < half ; front++){
	            back =  (arr_len-1) - front;
	            if(arr[front] != arr[back])  return 0;
	        }
	        return arr_len;
	    }
	}
}
