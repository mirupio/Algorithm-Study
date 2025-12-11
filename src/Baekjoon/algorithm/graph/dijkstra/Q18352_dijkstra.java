package Baekjoon.algorithm.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q18352_dijkstra {
    static PriorityQueue<int[]> pq;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
        }

        pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{X,0});

        visited = new boolean[N+1];

        distance = new int[N+1];
        for(int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[X] = 0;

        dijkstra();

        List<Integer> cities = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            if (distance[i] == K) {
                cities.add(i);
            }
        }
        Collections.sort(cities);

        if (cities.size() == 0) {
            System.out.println(-1);
        }
        else{
            for(int i=0;i<cities.size();i++){
                System.out.println(cities.get(i));
            }
        }

    }

    static void dijkstra() {
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int nowDis = cur[1];

            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            for(int next: graph.get(now)){
                int newDis = nowDis + 1;

                if(distance[next] > newDis){
                    distance[next] = newDis;
                    pq.add(new int[]{next,newDis});
                }
            }
        }
    }
}
