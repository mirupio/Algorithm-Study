package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            String[] tokens = br.readLine().split(" ");
            int[] arr = new int[10];
            for(int i=0;i<10;i++){
                arr[i] = Integer.parseInt(tokens[i]);
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for(int i=0;i<10;i++){
                sum += arr[i];
                if(arr[i]>max){
                    max = arr[i];
                }
                if(arr[i]<min){
                    min = arr[i];
                }
            }
            sum -= max;
            sum -= min;

            double avg = sum / 8.0;
            int result = (int) Math.round(avg);

            System.out.println("#"+t+" "+result);
        }
    }
}
