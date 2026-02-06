package Baekjoon.algorithm.map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q2015_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);

        long sum = 0;
        long answer = 0;

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L,1);

        tokens = br.readLine().split(" ");
        for (int i = 0; i < N; i++) { // 1 2 3 4 5 0 , K=5
            sum += Long.parseLong(tokens[i]); // 1 1+2 3+3 6+4 10+5 15+0
            answer += map.getOrDefault(sum-K, 0); // 0 0 1 1+0 1+1 2+1 -> K를 만들기 위해 필요한 값 = sum-K
            map.put(sum,map.getOrDefault(sum,0)+1); // 1:1 3:1 6:1 10:1 15:1 15:2
        }

        System.out.println(answer); // 3
    }
}
