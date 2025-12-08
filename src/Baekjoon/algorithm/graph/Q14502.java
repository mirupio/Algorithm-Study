package Baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502 {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int N,M;
    static int[][] graph;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        LinkedList<int[]> list_0 = new LinkedList<>();
        LinkedList<int[]> list_2 = new LinkedList<>();
        LinkedList<Integer> counts = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 2) {
                    list_2.add(new int[]{i, j});
                }

                if (graph[i][j] == 0) { // 0 모아두기
                    list_0.add(new int[]{i, j});
                }
            }
        }

        int[][] graph_copy = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                graph_copy[i][j] = graph[i][j];
            }
        }

        // 0 중 3개 골라서 1로 바꾸기
        for(int i = 0; i< list_0.size(); i++) {
            for(int j = i+1; j< list_0.size(); j++) {
                for(int k = j+1; k< list_0.size(); k++) {
                    // 초기화
                    for (int n = 0; n < N; n++) {
                        for(int m = 0; m < M; m++) {
                            graph[n][m] = graph_copy[n][m];
                        }
                    }

                    graph[list_0.get(i)[0]][list_0.get(i)[1]] = 1;
                    graph[list_0.get(j)[0]][list_0.get(j)[1]] = 1;
                    graph[list_0.get(k)[0]][list_0.get(k)[1]] = 1;

                    // 2랑 인접한 것 중 0인 것은 2로 변환, queue에 넣기 (bfs로 탐색)
                    queue = new LinkedList<>();
                    for(int l=0;l<list_2.size();l++) {
                        queue.add(new int[]{list_2.get(l)[0], list_2.get(l)[1]});
                    }
                    bfs();

                    // 0의 개수 구하기
                    int count = 0;
                    for (int n = 0; n < N; n++) {
                        for(int m = 0; m < M; m++) {
                            if(graph[n][m] == 0) {
                                count++;
                            }
                        }
                    }
                    counts.add(count);
                }
            }
        }

        int max = 0;
        for(int i = 0; i< counts.size(); i++) {
            if(counts.get(i) > max) {
                max = counts.get(i);
            }
        }

        System.out.println(max);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for(int i=0;i<4;i++) {
                int nextRow = curRow + dRow[i];
                int nextCol = curCol + dCol[i];

                if(nextRow>=0 && nextRow<N && nextCol>=0 && nextCol<M
                && graph[nextRow][nextCol] == 0) {
                    graph[nextRow][nextCol] = 2;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}
