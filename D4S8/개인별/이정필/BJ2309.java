package algo;

import java.io.*;
import java.util.*;

public class BJ2309 {
    static int[] shorts = new int[9];
    static boolean[] isSelected = new boolean[9];
    static int[] sevenGGoma = new int[7];
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            shorts[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(shorts);

        combi(0, 0);
        flag = false;
    }

    private static void combi(int cnt, int start) {
        if (flag == true) {
            return;
        }
        if (cnt == 7) {
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += sevenGGoma[i];
            }
            if (sum == 100 && flag == false) {
                for (int b : sevenGGoma) {
                    System.out.println(b);
                }
                flag = true;
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            if (isSelected[i]) {
                continue;
            }

            isSelected[i] = true;
            sevenGGoma[cnt] = shorts[i];
            combi(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }
}