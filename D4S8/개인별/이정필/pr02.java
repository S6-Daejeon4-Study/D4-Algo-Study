package problem;

import java.io.*;
import java.util.*;

public class pr02 {
    // 나보다 큰에 만나면 무조건 푸쉬, 그 외에는 싹다 팝 이렇게 설게하면 될 듯
    // 1.비어있으면 푸쉬
    // 2. 안비어있으면 비교
    // 3. 나보다 크면 푸쉬
    // 4. 나보다 크지 않으면 큰거 만날 때 까지 팝
    // 5. 사이즈 출력
    // static: 딱히 없다

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> macdaekis = new Stack<Integer>();

        for (int i = 0; i < N; i++) {
            int macdaeki = Integer.parseInt(br.readLine());
            if (macdaekis.isEmpty()) {
                macdaekis.push(macdaeki);
            }

            if (macdaekis.peek() > macdaeki) {
                macdaekis.push(macdaeki);
            } else {
                while (true) {
                    macdaekis.pop();
                    if (macdaekis.isEmpty()) {
                        macdaekis.push(macdaeki);
                        break;
                    }
                    if (macdaekis.peek() > macdaeki) {
                        macdaekis.push(macdaeki);
                        break;
                    }
                }
            }
        }

        System.out.println(macdaekis.size());
    }
}
