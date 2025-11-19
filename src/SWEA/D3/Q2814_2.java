package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2814_2 {
    static int[][] map;
    static boolean[] visited;
    static int N;
    static int max;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
                map[y][x] = 1;
            }

            visited = new boolean[N+1];
            max = 0;

            for(int i=1;i<=N;i++) {
                dfs(1, i);
                visited[i] = false;
            }

            System.out.println("#"+t+" "+max);
        }

    }

    static void dfs(int count,int node){
        visited[node] = true;

        for (int i = 0; i < N + 1; i++) {
            if(map[node][i] == 1 && visited[i] == false) {
                dfs(count + 1, i);
                visited[i] = false;
            }
        }

        max = Math.max(count, max);
    }

}
