package Baekjoon.algorithm.graph.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q6603 {
    static int k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            /*for (int i = 0; i < k; i++) {
                System.out.print(arr[i]+" ");
            }*/

            dfs(0, new ArrayList<>());
            System.out.println();
        }

    }

    static void dfs(int index, List<Integer> output) {
        if (output.size() == 6) {
            for (int i = 0; i < output.size(); i++) {
                System.out.print(output.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < k; i++) {
            output.add(arr[i]);
            dfs(i + 1, output);
            output.remove(output.size() - 1); // 백트래킹
        }
    }
}
