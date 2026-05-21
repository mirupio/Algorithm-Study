package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1860_sort_greedy {

    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("src/ssafy/input (18).txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // N명
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            String answer = "Possible";
            Arrays.sort(arr);
            for(int i=0;i<N;i++) {
                int produced = (arr[i]/M) * K;

                if(produced < i+1){
                    answer = "Impossible";
                }
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }

}
