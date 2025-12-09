package Baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1753_2 {
    static PriorityQueue<int[]> pq;
    static List<List<int[]>> graph;
    static boolean[] visited; // pq에서 꺼낸 정점이 '최단거리 확정'되었음 표시
    static int[] distance; // 시작점에서 i까지의 최단거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수

        int K = Integer.parseInt(br.readLine()); // 시작 정점

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
        }

        distance = new int[V+1];
        // 초기화
        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[K] = 0;

        visited = new boolean[V+1];

        // PriorityQueue : 가장 비용이 적은 정점부터 꺼냄
        pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1])); // 두번째 원소인 '가중치'로 비교
        pq.add(new int[]{K, 0});
        dijkstra();

        for (int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else{
                System.out.println(distance[i]+" ");
            }
        }
    }

    static void dijkstra() {
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int nowVertex = cur[0];
            int nowCost = cur[1]; // 지금까지 온 비용
            // System.out.println("nowVertex = " + nowVertex +" nowCost = " + nowCost);

            // 한번 pq에서 나온 최단거리 노드는 다시 처리할 필요 없음
            if(visited[nowVertex]) {
                continue;
            }
            visited[nowVertex] = true;

            for (int[] next : graph.get(nowVertex)) {
                int nextVertex = next[0];
                int nextCost = next[1]; // next로 가는 비용

                // 새로운 비용 = 지금까지 온 비용 + next로 가는 비용
                int newDist = nowCost + nextCost;
                if(distance[nextVertex] > newDist) {
                    distance[nextVertex] = newDist;
                    pq.add(new int[]{nextVertex, newDist});
                }
            }

        }
    }
}
