
public class P42584_주식가격_오서하 {
	class Solution {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length]; 
	        
	        for(int i = 0 ; i < prices.length-1 ; i ++){
	            int price = prices[i];
	            int cnt = 0;
	            
	            for(int j = i +1 ; j < prices.length ; j ++){
	                cnt++;
	                if(price > prices[j]) 
	                    break;
	                // if(price <= prices[j]) cnt++;
	                // else{ 
	                //     // 현재 i에서 j를 비교할 때 j가 하락했다면, 현재 cnt만큼 유지된것  
	                //     // 예제로 나와있는 3초의 가격 3 입장에서 4초 가격이 2 임 => 1초가 유지 된 후 2로 하락한 것이므로
	                //     // 1초 동안은 가격이 떨어지지 않았다고 생각해야한다. 
	                //     cnt++; 
	                //     break;
	                // }
	            }
	            answer[i] = cnt;
	        }
	       
	        return answer;
	    }
	}
}
