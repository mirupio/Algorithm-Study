package Baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 틀린 답안
// -> 가중치 그래프에서 BFS는 절대 쓸 수 없음 !!!
// -> 가중치 그래프는 한 정점에 여러번 방문할 수 있어서 방문처리 어려움 !!
public class Q1753 {
    static Queue<int[]> queue;
    static List<List<int[]>> graph;
    static boolean[] visited;
    static int[] distance;
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

        queue = new LinkedList<>();
        queue.add(new int[]{K, 0});
        visited = new boolean[V];
        visited[K] = true;
        distance = new int[V+1];
        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
            if (i == K) {
                distance[i] = 0;
            }
        }
        bfs();

        for (int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else{
                System.out.println(distance[i]+" ");
            }
        }
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int dis = cur[1];
            System.out.println("num = " + num+" dis = " + dis);

            distance[num] = Math.min(dis,distance[num]);

            for (int[] next : graph.get(num)) {
                int nextNum = next[0];
                int nextDis = next[1];
                if(!visited[nextNum]) {
                    visited[nextNum] = true;
                    queue.add(new int[]{nextNum, dis+nextDis});
                }
            }
        }
    }
}
