package algo;

import java.io.*;
import java.util.*;

public class Baekjoon1406 {
    static String input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        int commandNum = Integer.parseInt(br.readLine());
        char command;
        StringTokenizer st;
        int cursor = input.length();
        for (int i = 0; i < commandNum; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken().charAt(0);
            switch (command) {
                case 'L':
                    if (cursor != 0) {
                        cursor -= 1;
                    }
                    break;
                case 'D':
                    if (cursor != input.length()) {
                        cursor += 1;
                    }
                    break;
                case 'B':
                    if (cursor == 0) {
                        break;
                    } else if (cursor == input.length()) {
                        input = input.substring(0, cursor - 1);
                        cursor -= 1;
                    } else {
                        String temp1 = input.substring(0, cursor - 1);
                        String temp2 = input.substring(cursor);
                        input = temp1 + temp2;
                        cursor -= 1;
                    }
                    break;
                case 'P':
                    if (cursor == 0) {
                        input = st.nextToken() + input;
                        cursor += 1;
                    } else if (cursor == input.length()) {
                        input = input + st.nextToken();
                        cursor += 1;
                    } else {
                        String temp1 = input.substring(0, cursor);
                        String temp2 = input.substring(cursor);
                        input = temp1 + st.nextToken() + temp2;
                        cursor += 1;
                    }
                    break;

                default:
                    break;
            }

        }
        System.out.println(input);
    }
}
