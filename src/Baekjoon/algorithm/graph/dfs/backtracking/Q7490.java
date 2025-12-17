package Baekjoon.algorithm.graph.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7490 {
    static int N;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N+1];
            for (int i = 1; i <= N; i++) {
                arr[i] = i;
            }

            sb = new StringBuilder();
            dfs(2, "1");
            System.out.print(sb.toString());
            System.out.println();
        }
    }

    static void dfs(int index, String s) {
        if (index == N+1) {
            String[] nums = s.replace(" ","").split("[+-]");
            int sum = Integer.parseInt(nums[0]);
            int idx = 1;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '+') {
                    sum += Integer.parseInt(nums[idx++]);
                }

                else if (c == '-') {
                    sum -= Integer.parseInt(nums[idx++]);
                }
            }

            if (sum == 0) {
                sb.append(s).append('\n');
            }
            return;
        }

        String s1 = s + " "+arr[index];
        dfs(index + 1, s1);

        String s2 = s + "+"+arr[index];
        dfs(index + 1, s2);

        String s3 = s + "-"+ arr[index];
        dfs(index + 1, s3);
    }

}
