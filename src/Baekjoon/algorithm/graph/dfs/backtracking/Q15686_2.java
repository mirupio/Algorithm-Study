package Baekjoon.algorithm.graph.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15686_2 {
    static int[][] arr;
    static List<int[]> arr_1,arr_2;
    static int M;
    static boolean[] visited;
    static int minChicken;
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

        visited = new boolean[arr_2.size()];
        minChicken = Integer.MAX_VALUE;
        dfs(0, 0);

        System.out.println(minChicken);
    }

    static void dfs(int index, int depth) {
        // System.out.println("index = " + index + ", depth = " + depth);
        if (depth == M) {
            // 모든 집의 치킨 거리 합
            int sum = 0;
            for (int i = 0; i < arr_1.size(); i++) {
                int min = Integer.MAX_VALUE;
                // 치킨 거리 구하기 (치킨집과의 거리 중 최소)
                for(int j = 0; j < arr_2.size(); j++) {
                    if (visited[j] == true) { // 방문한 곳은 선택된 치킨집
                        int chicken = Math.abs(arr_1.get(i)[0] - arr_2.get(j)[0])
                                + Math.abs(arr_1.get(i)[1] - arr_2.get(j)[1]);
                        min = Math.min(min, chicken);
                    }
                }
                sum += min;
            }

            minChicken = Math.min(minChicken, sum);
            return;
        }

        for (int i = index; i < arr_2.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}
