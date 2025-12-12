package Baekjoon.algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1389_bfs {
    static Queue<int[]> queue;
    static boolean[] visited;
    static int[] distance;
    static List<List<Integer>> graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        int[] total = new int[N+1];
        for (int i = 1; i <= N; i++) {
            queue = new LinkedList<>();
            queue.add(new int[]{i, 0});

            visited = new boolean[N+1];
            distance = new int[N+1];
            bfs();

            for (int j = 1; j <= N; j++) {
                total[i] += distance[j];
            }
        }

        /*for(int i = 1; i <= N; i++) {
            System.out.print(total[i]+" ");
        }*/

        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i = N; i >= 1; i--) {
            if (total[i] <= min) {
                min = total[i];
                min_index = i;
            }
        }
        System.out.println(min_index);
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0];
            int nowDis = cur[1];
            visited[now] = true;

            distance[now] = nowDis;

            for (int next : graph.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[] {next,nowDis+1});
                }
            }
        }
    }
}
