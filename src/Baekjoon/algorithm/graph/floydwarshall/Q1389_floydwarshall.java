package Baekjoon.algorithm.graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1389_floydwarshall {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        final int INF = 100000000;
        int[][] distance = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                }
                else {
                    distance[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            distance[A][B] = 1;
            distance[B][A] = 1;
        }

        // floydwarshall
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(distance[i][j] > distance[i][k]+distance[k][j]) {
                        distance[i][j] = distance[i][k]+distance[k][j];
                    }
                }
            }
        }

        int[] total = new int[N + 1];
        int min = INF;
        int min_index = -1;
        for (int i = N; i >= 1; i--) {
            for(int j = 1; j <= N; j++) {
                total[i] += distance[i][j];
            }
            if (total[i] <= min) {
                min = total[i];
                min_index = i;
            }
        }

        /*for(int i = 1; i <= N; i++) {
            System.out.print(total[i]+" ");
        }
        System.out.println();*/
        System.out.println(min_index);
    }
}
