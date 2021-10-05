package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Baekjoon_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str = br.readLine().toCharArray();
		int TC = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<>();

		for (int i = 0; i < str.length; i++) {
			list.add(str[i]);
		}

		int cursorIdx = list.size();
		for (int i = 0; i < TC; i++) {
			char[] cmd = br.readLine().toCharArray();

			if (cmd[0] == 'L') { //  L이 입력되면 
				if (cursorIdx == 0)
					continue;
				cursorIdx = cursorIdx - 1;//커서를 왼쪽으로 이동시킨다.
			} else if (cmd[0] == 'D') { // D가 입력되면
				if (cursorIdx == list.size())
					continue;
				cursorIdx = cursorIdx + 1; // 커서를 오른쪽으로 이동시킨다.
			} else if (cmd[0] == 'B') { // B가 입력되면
				if (cursorIdx == 0)
					continue;
				int moveIdx = cursorIdx - 1; // 현재 커서의 위치의 왼쪽 값을 삭제한다.
				list.remove(moveIdx);
				cursorIdx = cursorIdx - 1;
			}
			else if(cmd[0] == 'P'){  // p가 입력되면 
				list.add(cursorIdx,cmd[2]);
				cursorIdx = cursorIdx+1; // 값을 삽입시킨다.
			}
		}
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.print(list.get(i)); // 값 출력
		}
	}
}
