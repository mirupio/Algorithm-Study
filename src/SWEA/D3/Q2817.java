package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2817 {
    static int N,K;
    static int[] arr;
    static int count;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int n=0;n<N;n++) {
                arr[n] = Integer.parseInt(st.nextToken());
            }

            count = 0;
            dfs(0, 0);

            System.out.println("#"+t+" " + count);
        }

    }

    static void dfs(int num, int sum){
        // sum이 K가 되면 경우의 수 증가 후, 종료
        if(sum == K){
            count++;
            return;
        }
        // sum이 K 넘어가면 종료
        if (sum > K) {
            return;
        }
        // N개 (0~N-1) 전부 검사 후 종료
        if(num == N){
            return;
        }

        // 이 숫자 포함 o
        dfs(num +1,sum+arr[num]);

        // 이 숫자 포함 x
        dfs(num + 1, sum);
    }
}
