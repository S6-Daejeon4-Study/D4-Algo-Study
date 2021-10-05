package problem;

import java.io.*;
import java.util.*;

public class pr04 {
    // 걍 3번
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> cards = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            cards.offer(i);
        }
        int temp = 0;
        while (true) {
            temp = cards.poll();
            if (cards.size() == 0) {
                break;
            }
            if (cards.size() == 1) {
                temp = cards.poll();
                break;
            }
            int card = cards.poll();
            cards.offer(card);
        }
        System.out.println(temp);
    }
}