package Baekjoon.algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 틀린 답안 -> 시간 초과
public class Q14889 {
    static int[][] arr;
    static int N;
    static boolean[] visited;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;

        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1, 1);
        System.out.println(min);
    }

    static void dfs(int index,int depth) {
        //System.out.println("index = " + index+", depth = " + depth);
        if (depth == N/2) {
            List<Integer> list1 = new ArrayList<>();
            for(int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    list1.add(i);
                }
            }
            /*System.out.print("방문 안한 index들 ");
            for(int i = 0; i < list1.size(); i++) {
                System.out.print(list1.get(i)+" ");
            }
            System.out.println();*/
            int output1 =0;
            for (int i = 0; i < list1.size(); i++) {
                for(int j = i; j < list1.size(); j++) {
                    output1 += arr[list1.get(i)][list1.get(j)] + arr[list1.get(j)][list1.get(i)];
                }
            }

            List<Integer> list2 = new ArrayList<>();
            for(int i = 1; i <= N; i++) {
                if (visited[i]) {
                    list2.add(i);
                }
            }
            /*System.out.print("방문 한 index들 ");
            for(int i = 0; i < list2.size(); i++) {
                System.out.print(list2.get(i)+" ");
            }
            System.out.println();*/
            int output2 =0;
            for (int i = 0; i < list2.size(); i++) {
                for(int j = i; j < list2.size(); j++) {
                    output2 += arr[list2.get(i)][list2.get(j)] + arr[list2.get(j)][list2.get(i)];
                }
            }

            int diff = Math.abs(output1 -output2);
            /*System.out.println("output1 = " + output1);
            System.out.println("output2 = " + output2);
            System.out.println("diff = " + diff);*/
            min = Math.min(diff, min);
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i,depth + 1);
                visited[i] = false;
            }
        }
    }
}
