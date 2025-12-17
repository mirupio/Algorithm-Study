package Baekjoon.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15654 {
    static int N,M;
    static int[] arr;
    static boolean[] visited;
    static int[] output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        visited = new boolean[N];
        output = new int[M];

        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int x : output) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        // 배열 전체 중 이미 방문한 거 빼고 방문
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}
