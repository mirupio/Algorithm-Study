package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Q4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> freq = new TreeMap<>();
        String s;
        while((s = br.readLine()) != null && !s.isEmpty()) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        int sum = 0;
        for(String str : freq.keySet()){
            sum += freq.get(str);
        }
        for(String str : freq.keySet()){
            System.out.println(str+" "+ String.format("%.4f",(double) freq.get(str)/sum*100));
        }
    }
}
