package Baekjoon.algorithm.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q11404_dijkstra {
    static PriorityQueue<int[]> pq;
    static int[] distance;
    static boolean[] visited;
    static List<List<int[]>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
        }

        int[][] result = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
            pq.add(new int[]{i, 0});

            visited = new boolean[n+1];
            distance = new int[n+1];
            for (int j = 1; j <= n; j++) {
                distance[j] = Integer.MAX_VALUE;
            }
            distance[i] = 0;
            dijkstra();
            for (int j = 1; j <= n; j++) {
                result[i][j] = distance[j];
                if(result[i][j] == Integer.MAX_VALUE){
                    result[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
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
                if(distance[next]>newDis) {
                    distance[next] = newDis;
                    pq.add(new int[]{next,newDis});
                }
            }
        }
    }
}
