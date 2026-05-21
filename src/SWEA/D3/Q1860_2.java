package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q1860_2 {

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
            int max = Integer.MIN_VALUE;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<N;i++) {
                int p = Integer.parseInt(st.nextToken());
                map.put(p, map.getOrDefault(p, 0)+1);
                max=Math.max(max, p);
            }

            String answer = "Possible";
            // max초까지 표 만들기
            int[] time = new int[max+1];
            for(int i=0;i<=max;i++) {
                if(i==0) {
                    time[i]=0;
                }
                else {
                    time[i] = time[i-1];
                    if(i%M == 0) {
                        time[i] += K;
                    }
                }
                int p = map.getOrDefault(i,0);
                while(p-->0) {
                    time[i] -= 1;
                    //System.out.println("after="+time[i]);
                    if(time[i]<0) {
                        answer = "Impossible";
                        break;
                    }
                }
                // System.out.println("after="+time[i]);
                if(answer == "Impossible") {
                    break;
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }

}
