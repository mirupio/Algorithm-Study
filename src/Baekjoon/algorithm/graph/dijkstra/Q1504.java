package Baekjoon.algorithm.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1504 {
    static List<List<int[]>> graph;
    static PriorityQueue<int[]> pq;
    static boolean[] visited;
    static int[] distance;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        // 1 -> v1
        int a1 = travel(1, v1);
        // v1 -> v2
        int a2 = travel(v1, v2);
        // v2 -> N
        int a3 = travel(v2, N);
        long total1 = (long) a1+a2+a3;

        // 1 -> v2 -> v1 -> N
        // 1 -> v2
        int b1 = travel(1, v2);
        // v2 -> v1
        int b2 = travel(v2, v1);
        // v1 -> N
        int b3 = travel(v1, N);
        long total2 = (long) b1+b2+b3;

        long result = Math.min(total1, total2);

        if(a1>=Integer.MAX_VALUE || a2>=Integer.MAX_VALUE || a3>=Integer.MAX_VALUE
        || b1>=Integer.MAX_VALUE || b2>=Integer.MAX_VALUE || b3>=Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
    }

    static void dijkstra() {
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int nowDis = cur[1];

            if(visited[now]) {
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

    static int travel(int start, int end) {
        pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start, 0});
        visited = new boolean[N+1];
        distance = new int[N+1];
        for(int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        dijkstra();
        return distance[end];
    }
}
