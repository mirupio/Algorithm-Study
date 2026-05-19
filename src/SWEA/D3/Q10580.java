package SWEA.D3;

import java.util.*;
import java.io.*;

public class Q10580 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int count=0;
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0]= Integer.parseInt(st.nextToken());
                arr[i][1]= Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<N;i++) {
                for(int j=i+1;j<N;j++) {
                    // 기울기
                    int a1=arr[i][1]-arr[i][0];
                    int a2=arr[j][1]-arr[j][0];

                    // y절편
                    int b1 = arr[i][0];
                    int b2 = arr[j][0];

                    // 교점의 x좌표
                    if((a1-a2)!=0) {
                        double x = (double)(b2-b1)/(a1-a2);

                        // System.out.println(x);


                        if(x > 0 && x<1) {
                            double y = (double)(a1*x+b1);
                            // System.out.println(y);
                            if(y > 0) {
                                count++;
                            }
                        }

                    }
                }
            }

            System.out.println("#"+test_case+" "+count);
        }
    }
}
