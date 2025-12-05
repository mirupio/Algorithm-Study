package Baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2606 {
    static int count = 0;
    static int count_bfs = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        /*boolean[] visited = new boolean[vertex+1];
        dfs(1, visited, graph);

        System.out.println(count);*/

        boolean[] visited = new boolean[vertex+1];
        bfs(1, visited, graph);

        System.out.println(count_bfs);

    }

    static void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;

        for (int next : graph.get(node)) {
            if(!visited[next]) {
                dfs(next, visited, graph);
                count++;
            }
        }
    }

    static void bfs(int start, boolean[] visited, List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int next : graph.get(node)) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count_bfs++;
                }
            }
        }
    }
}
