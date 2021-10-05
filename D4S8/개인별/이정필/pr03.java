package problem;

import java.io.*;
import java.util.*;

public class pr03 {
    // 걍 문제에서 말하는거 따라가면 끝나겠네 출력만 조심하면 될 듯
    // static: 딱히 없다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> cards = new LinkedList<Integer>();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            cards.offer(i);
        }

        while (true) {// 뒤에 공백 붙이면 틀린거로 인식하네 앞으로 이거 조심해야겠다
            sb.append(cards.poll() + " ");
            if (cards.size() == 0) {// 일단 뽑으니까 사이즈 0되는걸 생각을 못했다 설계를 좀 더 구체화 해야할 필요
                sb.setLength(sb.length() - 1);
                break;
            }
            if (cards.size() == 1) {
                sb.append(cards.poll());
                break;
            }
            int card = cards.poll();
            cards.offer(card);
        }
        System.out.println(sb.toString());
    }
}
