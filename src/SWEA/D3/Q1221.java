package SWEA.D3;

import java.io.*;
import java.util.*;

public class Q1221 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken().substring(1));
            int total = Integer.parseInt(st.nextToken());

            Map<String,Integer> map = new HashMap<>();
            String[] tokens = br.readLine().split(" ");
            for(int i=0;i<total;i++) {
                map.put(tokens[i],map.getOrDefault(tokens[i],0)+1);
            }

            System.out.println("#"+N);

            prnt(map.getOrDefault("ZRO", 0),"ZRO");
            prnt(map.getOrDefault("ONE", 0),"ONE");
            prnt(map.getOrDefault("TWO", 0),"TWO");
            prnt(map.getOrDefault("THR", 0),"THR");
            prnt(map.getOrDefault("FOR", 0),"FOR");
            prnt(map.getOrDefault("FIV", 0),"FIV");
            prnt(map.getOrDefault("SIX", 0),"SIX");
            prnt(map.getOrDefault("SVN", 0),"SVN");
            prnt(map.getOrDefault("EGT", 0),"EGT");
            prnt(map.getOrDefault("NIN", 0),"NIN");

        }
    }

    static private void prnt(int count, String str) {
        StringBuilder sb = new StringBuilder();
        while(count-- > 0) {
            //System.out.println(str);
            sb.append(str).append(" ");
        }
        System.out.println(sb);
    }

}
