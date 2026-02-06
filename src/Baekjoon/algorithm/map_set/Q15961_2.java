package Baekjoon.algorithm.map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15961_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]); // 접시 수 = 8
        int d = Integer.parseInt(tokens[1]); // 가짓 수 = 30
        int k = Integer.parseInt(tokens[2]); // 연속해서 먹는 접시 수 = 4
        int c = Integer.parseInt(tokens[3]); // 쿠폰 번호 = 30

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 연속해서 먹는데,
        // 가짓 수 다양할수록, 쿠폰 번호 안 포함 할수록 이득

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int max = map.size() + (map.containsKey(c)? 0:1);

        // 슬라이딩
        for(int i=0;i<N;i++){
            int out = arr[i];
            map.put(out, map.get(out) - 1);
            if(map.get(out) == 0){
                map.remove(out);
            }

            int in = arr[(i+k)%N]; // 원형 배열
            map.put(in, map.getOrDefault(in, 0) + 1);

            int cur = map.size() + (map.containsKey(c)? 0:1);
            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}
