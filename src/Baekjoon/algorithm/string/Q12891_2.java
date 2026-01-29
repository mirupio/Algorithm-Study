package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q12891_2 {
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

        Map<Character,Integer> freq = new TreeMap<>();
        freq.put('A', 0);
        freq.put('C', 0);
        freq.put('G', 0);
        freq.put('T', 0);

        int count = 0;

        // 처음 윈도우
        for (int i = 0; i < P; i++) {
            freq.put(str.charAt(i), freq.get(str.charAt(i)) + 1);
        }
        if (check(freq, A, C, G, T)) {
            // System.out.println("check1");
            count++;
        }

        for (int i = 0; i < S - P; i++) {
            char out = str.charAt(i);
            char in = str.charAt(i + P);
            // System.out.println("out = " + out);
            // System.out.println("in = " + in);

            freq.put(out, freq.get(out) - 1);
            freq.put(in, freq.get(in) + 1);

            if (check(freq, A, C, G, T)) {
                // System.out.println("check2");
                count++;
            }
        }

        System.out.println(count);


    }
    static boolean check(Map<Character,Integer>freq,int A,int C,int G,int T) {
        if (freq.get('A') < A) {
            return false;
        }
        if (freq.get('C') < C) {
            return false;
        }
        if (freq.get('G') < G) {
            return false;
        }
        if (freq.get('T') < T) {
            return false;
        }
        return true;
    }

}
