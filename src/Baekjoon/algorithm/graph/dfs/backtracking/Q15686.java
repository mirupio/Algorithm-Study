package Baekjoon.algorithm.graph.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 틀린 답안 -> 치킨집 기준 거리
public class Q15686 {
    static int[][] arr;
    static List<int[]> arr_1,arr_2;
    static int M;
    static int[] mins;
    static boolean[] visited;
    static int finalmin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 치킨집 개수

        arr = new int[N+1][N+1];
        arr_1 = new ArrayList<>();
        arr_2 = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    arr_1.add(new int[]{i, j});
                }
                if (arr[i][j] == 2) {
                    arr_2.add(new int[]{i, j});
                }
            }
        }

        mins = new int[arr_2.size()];
        for (int i = 0; i < arr_2.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr_1.size(); j++) {
                int chicken = Math.abs(arr_2.get(i)[0] - arr_1.get(j)[0])
                        + Math.abs(arr_2.get(i)[1] - arr_1.get(j)[1]);
                min = Math.min(min, chicken);
                mins[i]= min;
            }
        }

        System.out.println("arr_1");
        for (int i = 0; i < arr_1.size(); i++) {
            System.out.print("["+arr_1.get(i)[0] + ","+arr_1.get(i)[1]+"] ");
        }
        System.out.println();
        System.out.println("arr_2");
        for (int i = 0; i < arr_2.size(); i++) {
            System.out.print("["+arr_2.get(i)[0] + ","+arr_2.get(i)[1]+"] ");
        }
        System.out.println();
        System.out.println("mins");
        for (int i = 0; i < mins.length; i++) {
            System.out.print(mins[i] + " ");
        }
        System.out.println();

        visited = new boolean[mins.length];
        finalmin = Integer.MAX_VALUE;
        visited[0] = true;
        dfs(0, 1, mins[0]);

        System.out.println(finalmin);
    }

    static void dfs(int index, int depth, int output) {
        System.out.println("index = " + index + ", depth = " + depth + ", output = " + output);
        if (depth == M) {
            finalmin = Math.min(finalmin, output);
            return;
        }

        for (int i = index +1; i < mins.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int nextoutput = output + mins[i];
                dfs(i, depth + 1, nextoutput);
                visited[i] = false;
            }
        }

    }
}
