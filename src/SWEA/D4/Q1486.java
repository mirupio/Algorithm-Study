package SWEA.D4;

import java.io.*;
import java.util.*;

public class Q1486 {
    static int[] arr;
    static int min;
    static boolean[] visited;
    static int N,B;
    public static void main(String[] args) throws IOException{
        // System.setIn(new FileInputStream("src/ssafy/input (19).txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;

            dfs(0,0);

            System.out.println("#"+test_case+" "+min);
        }
    }

    static void dfs(int idx, int sum) {

        if(sum >= B) {
            min = Math.min(min, sum-B);
            return;
        }

        if(idx == N) {
            return;
        }

        dfs(idx+1,sum+arr[idx]);

        dfs(idx+1,sum);
    }
}

