package algo;

import java.io.*;
import java.util.*;

public class BJ2605 {
    // 1초: 계산 1억 미만
    // 메모리: 128mb -> int 3300만개
    // 빅오=5050 아무렇게나 코딩해도 ㄱㅊ
    static ArrayList<Integer> students = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        students.add(1);
        int number = sc.nextInt();
        for (int i = 2; i <= N; i++) {
            int temp = sc.nextInt();
            int size = students.size();
            students.add(size - temp, i);
        }
        for (int i = 0; i < N; i++) {
            System.out.println(students.get(i));
        }
    }
}
