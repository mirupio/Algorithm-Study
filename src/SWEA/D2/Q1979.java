package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++){
                String[] tokens = br.readLine().split(" ");
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            // 가로 검사
            int total = 0;
            for(int i = 0; i < N; i++){
                int count = 0;
                for(int j = 0; j < N; j++){
                    if(arr[i][j] == 1){
                        count++;
                    }
                    else{
                        if(count == K){ // 0 1 1 1 0
                            total++;
                        }
                        count = 0;
                    }
                }
                if(count == K){ // 0 0 1 1 1
                    total++;
                }
            }

            // 세로 검사
            for(int i = 0; i < N; i++){
                int count = 0;
                for(int j = 0; j < N; j++){
                    if(arr[j][i] == 1){
                        count++;
                    }
                    else{
                        if(count == K){
                            total++;
                        }
                        count = 0;
                    }
                }
                if(count == K){
                    total++;
                }
            }

            System.out.println("#"+t+" "+ total);
        }


    }
}
