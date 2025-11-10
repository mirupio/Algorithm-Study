package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1204 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[101];
            for(int i=0;i<1000;i++){
                int score = Integer.parseInt(st.nextToken());
                arr[score] += 1;
            }

            int max = 0;
            int max_index = 0;
            for(int i=0;i<=100;i++){
                if(arr[i]>=max){
                    max = arr[i];
                    max_index = i;
                }
            }

            System.out.println("#"+t+" " + max_index);
        }
    }
}
