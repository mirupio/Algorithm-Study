package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1983 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String[] grade = {"D0","C-","C0","C+","B-","B0","B+","A-", "A0", "A+" };

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            double[] arr = new double[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int mid = Integer.parseInt(st.nextToken());
                int fin = Integer.parseInt(st.nextToken());
                int hw = Integer.parseInt(st.nextToken());

                double tot = mid*0.35 + fin*0.45 + hw*0.2;
                arr[i] = tot;
            }
            double[] arr_sorted = arr.clone();
            Arrays.sort(arr_sorted);

            int rank = 0;
            for(int i = 0; i < N; i++) {
                if(arr[K-1] == arr_sorted[i]) {
                    rank = i;
                    break;
                }
            }

            System.out.println("#"+t+" "+ grade[rank/(N/10)]);

        }
    }
}
