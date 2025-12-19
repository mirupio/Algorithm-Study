package Baekjoon.algorithm.graph.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 조합으로 풀기
public class Q1759_2 {
    static int L, C;
    static char[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        /*for (int i = 0; i < C; i++) {
            System.out.print(alpha[i]+" ");
        }
        System.out.println();*/

        dfs(0, "");
    }

    static void dfs(int index, String output) {
        // System.out.println("index = " + index+", output = "+output);
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
            return;
        }

        for (int i = index; i < C; i++) {
            dfs(i + 1, output + alpha[i]);
        }

    }
}
