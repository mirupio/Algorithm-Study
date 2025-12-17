package Baekjoon.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {
    static int[] arr, operator;
    static int N;
    static int min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4]; // +,-,x,/
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(1, arr[1]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int index, int output) {
        // System.out.println("index = " + index+", output = " + output);
        if (index == N) {
            max = Math.max(max, output);
            min = Math.min(min, output);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                int nextoutput = output;
                switch(i) {
                    case 0:
                        nextoutput = output + arr[index + 1];
                        break;
                    case 1:
                        nextoutput = output - arr[index + 1];
                        break;
                    case 2:
                        nextoutput = output * arr[index + 1];
                        break;
                    case 3:
                        /*if (output < 0) {
                            nextoutput = -(Math.abs(output) / arr[index + 1]);
                        }
                        else{
                            nextoutput = output / arr[index + 1];
                        }*/
                        nextoutput = output / arr[index + 1];
                }
                dfs(index+1,nextoutput);
                operator[i]++;
            }
        }
    }
}
