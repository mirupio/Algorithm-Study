package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q3431 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            if(X>=L && X<=U) {
                System.out.println("#"+test_case+" "+0);
            }
            else {
                if(X<L) {
                    System.out.println("#"+test_case+" "+(L-X));
                }
                else {
                    System.out.println("#"+test_case+" "+"-1");
                }
            }
        }

    }

}
