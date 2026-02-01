package Baekjoon.algorithm.string;

import java.io.*;
import java.util.*;

public class Q2607 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        String first = br.readLine();
        for(int i=0;i<N-1;i++){
            String next = br.readLine();
            if(littleSame(first,next)){
                count++;
            }
        }

        System.out.println(count);
    }
    static boolean littleSame(String a, String b) {
        // 문자, 개수
        Map<Character,Integer> map = new HashMap<>();
        for(char c:a.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        // D:1 O:1 G:1

        for(char c:b.toCharArray()){
            map.put(c, map.getOrDefault(c,0)-1);
            // G:0 O:0 D:0
            // G:0 O:-1 D:0
            // D:0 O:0
        }

        int plus = 0;
        int minus = 0;
        for(char c: map.keySet()){
            if(map.get(c) < -1){
                return false;
            }
            if(map.get(c) > 1){
                return false;
            }
            // -1 or 1이 여러개
            if(map.get(c) == -1){
                minus++;
            }
            if(map.get(c) == 1){
                plus++;
            }
        }

        return plus<=1 && minus<=1;
    }
}
