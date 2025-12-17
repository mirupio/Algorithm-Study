package Baekjoon.algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889_2 {
    static int[][] arr;
    static int N;
    static boolean[] visited;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;

        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1, 1);
        System.out.println(min);
    }

    static void dfs(int index,int depth) {
        if (depth == N/2) {
            int team1 = 0;
            int team2 = 0;

            for (int i = 1; i <= N; i++) {
                for(int j = i+1; j <= N; j++) {
                    if(visited[i] && visited[j]) {
                        team1 += arr[i][j] + arr[j][i];
                    }
                    else if (!visited[i] && !visited[j]) {
                        team2 += arr[i][j] + arr[j][i];
                    }
                }
            }

            int diff = Math.abs(team1 - team2);
            min = Math.min(diff, min);
            return;
        }

        for(int i = index; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i,depth + 1);
                visited[i] = false;
            }
        }
    }
}
