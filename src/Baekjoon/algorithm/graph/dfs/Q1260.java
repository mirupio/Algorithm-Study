package Baekjoon.algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 인접리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가(양방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        /*for (int i = 0; i < M; i++) {
            System.out.println(graph.get(i));
        }*/

        boolean[] visited = new boolean[N+1];
        dfsRecursive(V, visited, graph);
        System.out.println();

        visited = new boolean[N+1];
        dfsStack(V, visited, graph);
        System.out.println();

        visited = new boolean[N+1];
        bfsQueue(V, visited, graph);

    }

    static void dfsRecursive(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        System.out.print(node +" ");

        for(int next: graph.get(node)) {
            if (!visited[next]) {
                dfsRecursive(next, visited, graph);
            }
        }
    }

    static void dfsStack(int start, boolean[] visited, List<List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()) {
            int node = stack.pop();

            if(!visited[node]){
                visited[node] = true;
                System.out.print(node +" ");

                /*List<Integer> list = graph.get(node);
                for(int i=0;i<list.size();i++) {
                    int next = list.get(i);
                    if(!visited[next]) {
                        visited[next] = true;
                        stack.push(next);
                    }
                }*/

                // 역순으로
                List<Integer> list = graph.get(node);
                for(int i=list.size()-1;i>=0;i--) {
                    int next = list.get(i);
                    if(!visited[next]) {
                        stack.push(next);
                    }
                }
            }


        }

    }

    static void bfsQueue(int start, boolean[] visited, List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node+" ");
            for(int next: graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
