package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Q4613 {
    public static void main(String[] args)throws IOException {
        //System.setIn(new FileInputStream("src/ssafy/sample_input (3).txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char [][] arr = new char[N][M];
            for(int i=0;i<N;i++) {
                arr[i] = br.readLine().toCharArray();
            }

            int min = Integer.MAX_VALUE;
            for(int w=1;w<N;w++) {
                for(int b=w+1;b<N;b++) {
                    int count=0;
                    //System.out.println("w="+w+"b="+b);
                    for(int y=0;y<w;y++) {
                        for(int x=0;x<M;x++) {
                            if(arr[y][x]!= 'W') {
                                count++;
                            }
                        }
                    }
                    for(int y=w;y<b;y++) {
                        for(int x=0;x<M;x++) {
                            if(arr[y][x]!= 'B') {
                                count++;
                            }
                        }
                    }
                    for(int y=b;y<N;y++) {
                        for(int x=0;x<M;x++) {
                            if(arr[y][x]!= 'R') {
                                count++;
                            }
                        }
                    }
                    min = Math.min(min, count);

                }
            }

            System.out.println("#"+test_case+" "+min);

        }

    }
}
