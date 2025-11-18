package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q5215_dfs {
    static int N,L;
    static int[] score,cal;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            System.out.print("#"+t+" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            score = new int[N];
            cal = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            max = 0;
            dfs(0, 0, 0);

            System.out.println(max);
        }
    }
    static void dfs(int count, int sumScore, int sumCal){
        // 칼로리 초과 -> 멈춤
        if(sumCal > L) {
            return;
        }

        // 모든 재료 확인 후 -> 최대값 갱신
        if (count == N) {
            max = Math.max(max, sumScore);
            return;
        }

        // 해당 재료 선택 o
        dfs(count + 1, sumScore + score[count], sumCal + cal[count]);

        // 해당 재료 선택 x
        dfs(count + 1, sumScore, sumCal);
    }
}
