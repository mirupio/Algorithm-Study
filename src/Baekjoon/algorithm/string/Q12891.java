package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 틀린 답안 -> 시간 초과
public class Q12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 0~S-P
        int count = 0;
        for (int i = 0; i < S - P + 1; i++) {
            Map<Character,Integer> freq = new TreeMap<>();
            freq.put('A', 0);
            freq.put('C', 0);
            freq.put('G', 0);
            freq.put('T', 0);
            String s = str.substring(i, i + P);
            // System.out.println("s = " + s);
            for(int j=0;j<P;j++){
                freq.put(s.charAt(j), freq.get(s.charAt(j)) + 1);
            }
            if (freq.get('A') < A) {
                continue;
            }
            if (freq.get('C') < C) {
                continue;
            }
            if (freq.get('G') < G) {
                continue;
            }
            if (freq.get('T') < T) {
                continue;
            }
            count++;
        }

        System.out.println(count);

    }
}
