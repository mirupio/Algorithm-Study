package Baekjoon.solvedac.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[n] = m : "m번째 연주에서 볼륨 n으로 연주할 수 있음"
        int[] dp = new int[M+1];

        // 기본값 설정
        for(int i=0;i<=M;i++){
            dp[i] = -1;
        }
        dp[S] = 0; // 0번째 연주는 볼륨 5 (=시작 볼륨이 5)

        for(int i = 1; i <= N; i++){ // 1~N 번째 연주
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j <= M; j++){ // 0~M 사이의 볼륨
                if(dp[j] == i-1){ // i-1번째 연주(0~N-1 사이)의 볼륨에다가
                    int plus = j + arr[i]; // 더하거나
                    int minus = j - arr[i]; // 빼기가

                    // 가능한 경우 리스트에 추가
                    if(0 <= plus && plus <= M){
                        list.add(plus);
                    }
                    if(0 <= minus && minus <= M){
                        list.add(minus);
                    }
                }
            }

            for(int n : list){
                dp[n] = i;
            }
        }

        int max = -1;
        for(int i = 0; i <= M; i++){
            if(dp[i] == N){
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }
}
