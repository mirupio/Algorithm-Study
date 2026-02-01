package Baekjoon.algorithm.string;

import java.io.*;
import java.util.*;

public class Q2002 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 차량번호, 인덱스
        Map<String,Integer> map_in = new HashMap<>();
        for(int i=0;i<N;i++){
            String s = br.readLine();
            map_in.put(s,i);
        }

        int[] out = new int[N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            out[i] = map_in.get(str);
        }

        // 0 1 2 3 4
        // 1 4 3 0 2
        // 1 > 0
        // 4 > 1
        // 3 > 2
        // 0 < 3
        // 2 < 4

        // 순서대로 점검
        // 자기보다 앞에 있던 애들이 뒤에 있으면 count++
        int count = 0;
        for(int i=0;i<N;i++){
            int now = out[i]; // 현재 원소=4, index는 i=1
            // 0~3 이 뒤에 있는지 -> 있으면 count++
            outer:
            for(int j=0;j<now;j++){
                for(int k=i+1;k<N;k++){
                    if(out[k]==j){
                        count++;
                        break outer;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
