package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Q20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() >= M) {
                freq.put(s,freq.getOrDefault(s,0) + 1);
            }
        }

        List<String> words = new ArrayList<>(freq.keySet());
        words.sort((a, b) -> {
            // 1. 빈도 내림차순
            int cmp = freq.get(b) - freq.get(a);
            if(cmp != 0) return cmp;

            // 2. 길이 내림차순
            cmp = b.length() - a.length();
            if(cmp != 0) return cmp;

            // 3. 사전순 오름차순
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append('\n');
        }
        System.out.print(sb.toString());
    }
}
