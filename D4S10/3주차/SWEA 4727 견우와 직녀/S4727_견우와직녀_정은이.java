package swea;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4727_견우와직녀_정은이 {
    static int min, N, M1, M2;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M1 = Integer.parseInt(st.nextToken());
            M2 = 0;
            //입력 받기
            map = new int[N][N];
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int a = Integer.parseInt(st.nextToken());
                    if (a > 1) {
                        M2 = a;
                    }
                    map[i][j] = a;
                    visited[i][j] = Integer.MAX_VALUE;
                }
            }

            // 교차로 체크
            int tx;
            int ty;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int direction = -1;
                    for (int d = 0; d < 4; d++) {
                        tx = i + dx[d];
                        ty = j + dy[d];
                        if (tx >= N || ty >= N || tx < 0 || ty < 0) continue;
                        if (map[i][j] == 0 && (map[tx][ty] == 0 || map[tx][ty] == -1)) {
                            if (direction == -1) direction = d;
                            else if ((d - direction) % 2 == 1) {
                                map[i][j] = -1;
                                break;
                            }
                        }
                    }
                }
            }


//            dfs(0,0,0);

            bw.write("#" + t + " " + bfs());
            if (t != T) bw.append('\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        visited[0][0] = 0;
        int time = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0}); // 좌표 x, y, 직전에 절벽을 건넜는지, ㅡ

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if (temp[0] == N - 1 && temp[1] == N - 1) return visited[N - 1][N - 1];
                int tx;
                int ty;
                int usedM = temp[3];
                for (int d = 0; d < 4; d++) {
                    tx = temp[0] + dx[d];
                    ty = temp[1] + dy[d];
                    if (tx >= N || ty >= N || tx < 0 || ty < 0) continue;
                    if (map[tx][ty] == -1) continue;

                    if (map[tx][ty] == 1) {
                        queue.add(new int[]{tx, ty, 0, usedM});
//                        visited[tx][ty] = time;
                        writeTime(tx, ty, time);
                    }
                    if (temp[2] == 1) continue; // 절벽을 한번 건넌 뒤에 곧바로 두 번 연속으로 건너는 일은 없다.

                    if (M2 != 0 && map[tx][ty] == M2 && time % M2 == 0) {
                        queue.add(new int[]{tx, ty, 1, usedM});
//                        visited[tx][ty] = time;
                        writeTime(tx, ty, time);
                    } else if (usedM == 0 && map[tx][ty] == 0) {
                        if (time % M1 == 0) {
                            queue.add(new int[]{tx, ty, 1, 1});
//                            visited[tx][ty] = time;
                            writeTime(tx, ty, time);
                        } else {
                            queue.add(new int[]{temp[0], temp[1], 0, 0});
                        }
                    }

                }
            }

            time++;
        }

        return time;
    }

    static void writeTime(int a, int b, int time) {
        if (a == N - 1 && b == N - 1) visited[a][b] = Math.min(visited[a][b], time);
    }
}
//    static void dfs(int i, int j , int time){
//        if(i==N-1&& j==N-1){
//            min= Math.min(time,min);
//            return;
//        }
//        if(time>min) return;
//        int tx;
//        int ty;
//
//        for(int d=0; d<4;d++){
//            tx=i+dx[d];
//            ty=j+dy[d];
//
//            if(tx>=N || ty>=N|| tx<0|| ty<0) continue;
//            if(!visted[tx][ty]){
//                visted[tx][ty]=true;
//                if(map[tx][ty]==1 ) {
//                    visted[tx][ty]=true;
//                    dfs(tx,ty,time+1);
//                }
//                if(map[tx][ty]==0){
//                    int t = time+1;
//                    while (true){
//                        if(t%M1==0){
//                            dfs(tx,ty,t);
//                            break;
//                        }
//                        if(M2!=0 &&t%M2==0){
//                            dfs(tx,ty,t);
//                            break;
//                        }
//                        t++;
//                    }
//                }
//            }
//            visted[tx][ty]=false;
//
//        }
//}
//}
