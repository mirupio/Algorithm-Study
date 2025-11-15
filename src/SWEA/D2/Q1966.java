package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1966 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T  = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            String[] tokens = br.readLine().split(" ");
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(tokens[i]);
            }

            Arrays.sort(arr);

            System.out.print("#"+t+" ");
            for(int i=0;i<N;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
