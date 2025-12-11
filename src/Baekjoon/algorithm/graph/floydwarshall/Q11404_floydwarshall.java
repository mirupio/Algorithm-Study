package Baekjoon.algorithm.graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11404_floydwarshall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        final int INF = 100000000; // 1e8
        int[][] distance = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for(int j=1; j <= n; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                }
                else{
                    distance[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            distance[a][b] = Math.min(distance[a][b], c); // 중복 간선일 경우 더 작은거
        }

        // floydwarshall
        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n; i++) { // 출발
                for(int j = 1; j <= n; j++) { // 도착
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(distance[i][j] == INF) {
                    System.out.print("0 ");
                }
                else{
                    System.out.print(distance[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
