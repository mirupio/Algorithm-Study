package Baekjoon.algorithm.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1916 {
    static List<List<int[]>> graph;
    static PriorityQueue<int[]> pq;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발
            int v = Integer.parseInt(st.nextToken()); // 도착
            int w = Integer.parseInt(st.nextToken()); // 비용

            graph.get(u).add(new int[]{v, w});
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{A, 0});

        visited = new boolean[N+1];

        distance = new int[N+1];
        for(int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[A] = 0;

        dijkstra();

        System.out.println(distance[B]);
    }

    static void dijkstra() {
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int nowDis = cur[1];

            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            for (int[] nexts : graph.get(now)) {
                int next = nexts[0];
                int nextDis = nexts[1];

                int newDis = nowDis + nextDis;
                if(distance[next] > newDis) {
                    distance[next] = newDis;
                    pq.add(new int[]{next, newDis});
                }
            }

        }
    }
}
