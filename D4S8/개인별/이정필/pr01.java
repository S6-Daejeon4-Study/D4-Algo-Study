package problem;

import java.io.*;
import java.util.*;

public class pr01 {
    // 문제와 고무오리가 어떤 순서대로 만나는지만 신경쓰면 될 듯
    // 1. 문제 라면 푸쉬
    // 2. 고무오리라면 top 가져와서 문제면 팝 문제아니면 문제 두개 풀
    // 3. 1~2 반복, 그 외에거 들어오면 종료
    // 4. 스택 사이즈 따라서 출력 결정
    // static 변수 : 딱히 없음
    // 걍 지역변수로 다 진행하면 될듯
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> gomuOri = new Stack<String>();
        gomuOri.push(br.readLine());

        while (true) {
            String input = br.readLine();
            String temp = gomuOri.peek();

            if (input.equals("문제")) {
                gomuOri.push(input);
            } else if (input.equals("고무오리")) {
                if (temp.equals("문제")) {
                    gomuOri.pop();
                } else {
                    gomuOri.push("문제");
                    gomuOri.push("문제");
                }
            } else {
                break;
            }
        }

        if (gomuOri.size() > 1) {
            System.out.println("힝구");
        } else {
            System.out.println("고무오리야 사랑해");
        }
    }
}