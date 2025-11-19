package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2814 {
    static int answer;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 인접 리스트 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            // 간선 추가(무방향 그래프)
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            boolean[] visited = new boolean[N+1];
            answer = 0;

            for(int i=1;i<=N;i++) {
                visited[i] = true;
                dfs(i,1,visited,graph);
                visited[i] = false;
            }

            System.out.println("#"+t+" "+answer);
        }

    }

    static void dfs(int node, int depth, boolean[] visited, List<List<Integer>> graph) {
        answer = Math.max(answer, depth);

        for(int next : graph.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth+1,visited, graph);
                visited[next] = false;
            }
        }
    }
}
