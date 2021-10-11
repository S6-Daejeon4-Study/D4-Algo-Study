import java.util.*;
import java.io.*;

public class B21611_��������ͺ��ڵ�_����ö {
	static int N, M;// N�� �迭�� ũ��, M�� ���� ��� Ƚ��
	static int dis, s;// ���ڵ� ������ ����� �Ÿ�
	static int[][] map;
	static int[] bubble = new int[4];// ���� ���� cnt���� �ֵ�. index 0�� ������ 1~3 ����.

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

			copyList();// �迭�� ������� ������ ������� ����Ʈ�� copy�ϴ� �Լ�
			//System.out.println(list);

			blizzard(dis, s);// ������ ����� ���ڵ� �������� dis�������� s��ŭ �迭�� ���� -1�� ����

			check();// �迭�� ������� ������ ������� ���鼭 -1�� ���� list index�� ����� �� ����Ʈ ���� remove���ִ� �Լ�
			//System.out.println(list);

			bubblePop();// ����Ʈ�� Ž���ϸ� ���� ���ڰ� �����ؼ� 4�� �̻��̸� remove���ִ� �Լ�
			//System.out.println(list);

			copyNlist();// list���� ���ο� list�� �����ϴ� �Լ�
			//System.out.println(nlist);

			copyMap();// nlist�� map�� �ٽ� copy�ϴ� �Լ�
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
