package Baekjoon.algorithm.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1238 {
    static List<List<int[]>> graph;
    static int[] distance;
    static int[] total;
    static PriorityQueue<int[]> pq;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        // 1~N -> X + X -> 1~N 의 시간
        // 1) 1~N에서 dijkstra 출발 -> distance[X]
        // 2) X에서 출발 -> distance[N]

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[] {v, w});
        }

        total = new int[N+1];

        // 1) 1~N에서 dijkstra 출발 -> distance[X]
        pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (int i = 1; i <= N; i++) {
            pq.add(new int[]{i, 0});
            visited = new boolean[N+1];

            distance = new int[N+1];
            for (int j = 1; j <= N; j++) {
                distance[j] = Integer.MAX_VALUE;
            }
            distance[i] = 0;
            dijkstra();

            total[i] += distance[X];
        }

        // 2) X에서 출발 -> distance[N]
        pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{X, 0});

        visited = new boolean[N+1];

        distance = new int[N+1];
        for(int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[X] = 0;

        dijkstra();

        for(int i = 1; i <= N; i++) {
            total[i] += distance[i];
        }

        /*for(int i=1;i<=N;i++) {
            System.out.print(total[i]+" ");
        }*/

        int max = 0;
        for(int i = 1; i <= N; i++) {
            if(total[i] > max) {
                max = total[i];
            }
        }
        System.out.println(max);
    }

    static void dijkstra() {
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int nowDis = cur[1];

            if(visited[now]) continue;
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
