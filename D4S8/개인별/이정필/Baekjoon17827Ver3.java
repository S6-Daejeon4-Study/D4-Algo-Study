package algo;

import java.io.*;
import java.util.*;

public class Baekjoon17827Ver3 {
    static int N, M, V;
    static int[] snailList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        snailList = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snailList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int question = Integer.parseInt(br.readLine());

            if (question < N) {
                System.out.println(snailList[question]);
            } else {
                int realIdx = ((question - (V - 1)) % (N - (V - 1)) + (V - 1));
                System.out.println(snailList[realIdx]);
            }
        }
    }
}
