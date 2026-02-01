package Baekjoon.algorithm.string;

import java.io.*;
import java.util.*;

public class Q1302 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new TreeMap<>();
        for(int i=0;i<N;i++){
            String s = br.readLine();
            map.put(s,map.getOrDefault(s,0)+1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        // 개수 내림차순 -> 사전순
        list.sort((a,b) -> {
            int cmp = map.get(b) - map.get(a);
            if(cmp!=0) return cmp;

            return a.compareTo(b);
        });

        System.out.println(list.get(0));
    }
}
