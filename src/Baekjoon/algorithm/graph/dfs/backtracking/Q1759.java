package Baekjoon.algorithm.graph.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 부분 수열처럼 풀기
public class Q1759 {
    static int L, C;
    static char[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[] arr = new int[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        alpha = new char[C];
        for (int i = 0; i < C; i++) {
            alpha[i] = (char) arr[i];
        }

        /*for (int i = 0; i < C; i++) {
            System.out.print(alpha[i]+" ");
        }
        System.out.println();*/

        dfs(0, "");
    }

    static void dfs(int index, String output) {
        // System.out.println("index = " + index+", output = "+output);
        if (index >= C) {
            if (output.length() == L) {
                // 모음이 1개 이상, 자음이 2개 이상이면 출력
                int num = 0;
                for (char c : output.toCharArray()) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        num++;
                    }
                }
                if (num >= 1 && output.length() - num >= 2) {
                    System.out.println(output);
                }
            }
            return;
        }

        // 현재 원소 선택
        dfs(index + 1, output+alpha[index]);

        // 현재 원소 선택 X
        dfs(index + 1, output);
    }
}
