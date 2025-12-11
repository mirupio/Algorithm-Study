package Baekjoon.algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q18352_bfs {
    static Queue<int[]> queue;
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

        queue = new LinkedList<>();
        queue.add(new int[]{X,0});

        visited = new boolean[N+1];
        visited[X] = true;

        distance = new int[N+1];
        bfs();

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

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int dis = cur[1];

            distance[num] = dis;

            for(int next: graph.get(num)){
                if(!visited[next]){
                    queue.add(new int[]{next,dis+1});
                    visited[next] = true;
                }
            }
        }
    }
}
