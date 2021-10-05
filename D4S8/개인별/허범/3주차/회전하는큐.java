package week_03;

import java.util.LinkedList;
import java.util.Scanner;

public class 회전하는큐 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int cnt = 0;
      int N = sc.nextInt();// 큐의 크기
      int M = sc.nextInt();// 뽑아낼 숫자 갯수
      int[] index = new int[M];// 뽑아내고 싶은 숫자의 인덱스 저장

      // 1 = removeFirst() 한개
      // 2 = pollFirst()하고 addLast()
      // 3 = pollLast()하고 addFirst()

      LinkedList<Integer> deque = new LinkedList<>();// deque 구현 = indexof를 사용하기 위해 LinkedList로 선언

      for (int n = 1; n <= N; n++) {
         deque.addLast(n);// deque에 숫자를 순서대로 채움. 인덱스와 일치시키기 위함.
      }

      for (int m = 0; m < M; m++) {
         index[m] = sc.nextInt();// 뽑아낼 숫자의 인덱스를 index 배열에 저장.
      }//입력

      int m = 0;
      while (m < M) {// m개의 숫자를 뽑을 때까지 while문으로 반복
         if (deque.peekFirst() == index[m]) {//만약 제일 앞의 숫자가 뽑을 숫자와 일치하면 숫자를 뽑는다.
            deque.removeFirst();
            m++;// 숫자를 뽑앗을 시 m++. 숫자는 제일 앞에서 밖에 뽑지 않기 때문.
         } else {//제일 앞의 숫자가 뽑을 숫자와 일치하지 않으면 2번이나 3번 실시.

            if (deque.size() / 2 < deque.indexOf(index[m])) {//뽑을 숫자의 현재 위치가 뒤쪽인지 앞쪽인지 판단하는 if문.
               //뽑을 숫자의 현재 인덱스가 deque의 현재 사이즈의 반쪽보다 크면 뒤쪽, 작으면 앞쪽임.
               while (!(deque.peekFirst() == index[m])) {//deque의 제일 앞쪽 숫자를 체크하여 뽑을 숫자와 같을때 까지 while문 돌기
                  deque.addFirst(deque.pollLast());// 만약 뽑을 숫자의 인덱스가 더 크면 3번실행
                  cnt++;//2번 실행했으니 count 세주기
               }
            } else {//뽑을 숫자의 현재 위치가가 현재 deque의 정중앙보다 앞쪽일때.
               while (!(deque.peekFirst() == index[m])) {//deque의 제일 앞쪽 숫자를 체크하여 뽑을 숫자와 같을때 까지 while문 돌기
                  deque.addLast(deque.pollFirst());// 만약 뽑을 숫자의 인덱스가 더 작으면 2번실행
                  cnt++;//3번 실행했으니 count 세주기.
               }
            }
         }
      }//while문 반복하면서 cnt를 계속 더해주기
      System.out.println(cnt);//cnt 정답 출력.
   }
}