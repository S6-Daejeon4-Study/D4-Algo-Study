import java.util.*;
import java.io.*;

public class B21611_마법사상어와블리자드_김응철 {
	static int N, M;// N은 배열의 크기, M은 마법 사용 횟수
	static int dis, s;// 블리자드 마법의 방향과 거리
	static int[][] map;
	static int[] bubble = new int[4];// 터진 버블 cnt세는 애들. index 0은 버리고 1~3 센다.

	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { -1, 0, 1, 0 };

	static LinkedList<Integer> list = new LinkedList<>();
	static LinkedList<Integer> nlist = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());

			dis = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			list.clear();
			nlist.clear();

			list.add(0);
			nlist.add(0);

			copyList();// 배열을 가운데부터 달팽이 모양으로 리스트에 copy하는 함수
			//System.out.println(list);

			blizzard(dis, s);// 마법사 상어의 블리자드 마법으로 dis방향으로 s만큼 배열의 값을 -1로 만듬

			check();// 배열을 가운데부터 달팽이 모양으로 돌면서 -1인 곳의 list index를 계산해 그 리스트 값을 remove해주는 함수
			//System.out.println(list);

			bubblePop();// 리스트를 탐색하며 같은 숫자가 연속해서 4개 이상이면 remove해주는 함수
			//System.out.println(list);

			copyNlist();// list에서 새로운 list로 복사하는 함수
			//System.out.println(nlist);

			copyMap();// nlist를 map에 다시 copy하는 함수
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++)
//					System.out.print(map[i][j] + " ");
//				System.out.println();
//			}
		}

		System.out.println(1 * bubble[1] + 2 * bubble[2] + 3 * bubble[3]);
	}

	private static void copyMap() {
		int ni, nj, n = 0, x = 1, flag = 0;
		int nowi = (N + 1) / 2;
		int nowj = (N + 1) / 2;

		while (true) {
			for (int d = 0; d < 4; d++) {
				ni = nowi;
				nj = nowj;

				int K = 0;
				if (d == 0 || d == 1)
					K = 1 + 2 * n;
				else
					K = 2 + 2 * n;

				for (int k = 0; k < K; k++) {
					ni += di[d];
					nj += dj[d];
					if (ni == 1 && nj == 0) {
						flag = 1;
						break;
					}
					if (x < nlist.size()) {
						map[ni][nj] = nlist.get(x);
						x++;
					} else {
						map[ni][nj] = 0;
					}
				}
				
				if (flag == 1)
					break;

				nowi = ni;
				nowj = nj;
			}

			if (flag == 1)
				break;
			n++;
		}

	}

	private static void copyNlist() {
		int cnt = 1;

		for (int i = 1; i < list.size(); i++) {
			if (i == list.size() - 1) {
				nlist.add(cnt);
				nlist.add(list.get(i));
				break;
			}
			if (list.get(i) == list.get(i + 1))
				cnt++;
			else {
				nlist.add(cnt);
				nlist.add(list.get(i));
				cnt = 1;
			}

		}

	}

	private static void bubblePop() {
		int cnt = 1, flag = 1;
		while (true) {
			cnt = 1;
			if (flag == 0)
				break;
			flag = 0;

			for (int i = 1; i < list.size() - 1; i++) {

				if (list.get(i) == list.get(i + 1))
					cnt++;
				else if (list.get(i) != list.get(i + 1) && cnt < 4)
					cnt = 1;

				else if (list.get(i) != list.get(i + 1) && cnt >= 4) {
					if (list.get(i) == 1)
						bubble[1] += cnt;
					else if (list.get(i) == 2)
						bubble[2] += cnt;
					else if (list.get(i) == 3)
						bubble[3] += cnt;

					for (int k = 0; k < cnt; k++) {
						list.remove(i - k);
						flag++;
					}
					i -= cnt;
					cnt = 1;
				}
			}

		}

	}

	private static void check() {

		int nowi = (N + 1) / 2;
		int nowj = (N + 1) / 2;
		int ni, nj, n = 0, flag = 0, cnt = 0;
		while (flag == 0) {
			for (int d = 0; d < 4; d++) {
				ni = nowi;
				nj = nowj;

				int K = 0;
				if (d == 0 || d == 1)
					K = 1 + 2 * n;
				else
					K = 2 + 2 * n;

				for (int k = 0; k < K; k++) {
					ni += di[d];
					nj += dj[d];
					if (ni == 1 && nj == 0 || map[ni][nj] == 0) {
						flag = 1;
						break;
					}
					cnt++;
					if (map[ni][nj] == -1) {
						list.remove(cnt);
						cnt--;
					}
				}
				if(flag==1)
					break;
				nowi = ni;
				nowj = nj;
			}
			n++;
		}

	}

	static void blizzard(int d, int s) {
		if (d == 1) {
			for (int i = 1; i <= s; i++) {
				map[(N + 1) / 2 - i][(N + 1) / 2] = -1;
			}
		} else if (d == 2) {
			for (int i = 1; i <= s; i++) {
				map[(N + 1) / 2 + i][(N + 1) / 2] = -1;
			}
		} else if (d == 3) {
			for (int i = 1; i <= s; i++) {
				map[(N + 1) / 2][(N + 1) / 2 - i] = -1;
			}
		} else if (d == 4) {
			for (int i = 1; i <= s; i++) {
				map[(N + 1) / 2][(N + 1) / 2 + i] = -1;
			}
		}
	}

	static void copyList() {

		int nowi = (N + 1) / 2;
		int nowj = (N + 1) / 2;
		int ni, nj, n = 0, flag = 0;
		while (flag == 0) {
			for (int d = 0; d < 4; d++) {
				ni = nowi;
				nj = nowj;

				int K = 0;
				if (d == 0 || d == 1)
					K = 1 + 2 * n;
				else
					K = 2 + 2 * n;

				for (int k = 0; k < K; k++) {
					ni += di[d];
					nj += dj[d];
					if (ni == 1 && nj == 0 || map[ni][nj] == 0) {
						flag = 1;
						break;
					}
					list.add(map[ni][nj]);
				}
				if(flag==1)
					break;
				
				nowi = ni;
				nowj = nj;
			}
			n++;
		}
	}

}
