package Baekjoon.codingdodo.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prefixsum1D_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배열 길이

        int[] arr = new int[n+1]; // 입력 배열
        int[] prefix = new int[n+1]; // 누적합 배열

        // 배열 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 계산
        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        // 구간합 구하기 start ~ end
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int sum = prefix[end]-prefix[start-1];
        System.out.println(sum);
    }
}
