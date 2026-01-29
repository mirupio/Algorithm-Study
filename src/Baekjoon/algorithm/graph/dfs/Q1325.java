package Baekjoon.algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1325 {
    static int count;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a가 b를 신뢰 = b를 해킹하면 a도 해킹 가능 = b에 a가 연결
            graph.get(b).add(a);
        }

        int[] num = new int[N+1];
        for (int i = 1; i <= N; i++) {
            count = 0;
            visited = new boolean[N+1];
            dfs(graph, i,visited);
            num[i] = count;
        }

        /*for(int i = 1; i <= N; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();*/
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        for (int i = 1; i <= N; i++) {
            if (max == num[i]) {
                System.out.print(i+" ");
            }
        }
    }

    static void dfs(List<List<Integer>> graph, int start,boolean[] visited) {
        count++;
        visited[start] = true;

        for(int next:graph.get(start)) {
            if(!visited[next]) {
                dfs(graph, next,visited);
            }
        }
    }
}
