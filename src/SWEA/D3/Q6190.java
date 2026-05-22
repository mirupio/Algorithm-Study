package SWEA.D3;

import java.io.*;

public class Q6190 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            String[] tokens = br.readLine().split(" ");
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }
            int max = Integer.MIN_VALUE;
            for(int i=0;i<N;i++) {
                for(int j=i+1;j<N;j++) {
                    int num = arr[i] * arr[j];

                    if(isInc(num)) {
                        max = Math.max(max,num);
                    }
                }
            }

            if(max == Integer.MIN_VALUE) {
                max = -1;
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
    static boolean isInc(int num) {
        String str = String.valueOf(num);
        for(int i=0;i<str.length()-1;i++) {
            if(str.charAt(i)>str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}
