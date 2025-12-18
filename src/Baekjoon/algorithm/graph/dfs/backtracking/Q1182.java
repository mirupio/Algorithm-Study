package Baekjoon.algorithm.graph.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1182 {
    static int N,S;
    static int count;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        dfs(0, 0);

        // 양수인 부분수열만 해당
        // -> S가 0일 경우, 공집합인 경우도 하나 카운트 됨.
        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    static void dfs(int index,int sum) {
        // System.out.println("index = " + index+" sum = " + sum);
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        // 현재 원소 선택
        dfs(index + 1, sum + arr[index]);

        // 현재 원소 선택 X
        dfs(index + 1, sum);
    }
}
