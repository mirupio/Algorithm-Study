package Baekjoon.algorithm.map_set;

import java.io.*;
import java.util.*;

// 틀린 답안 -> 시간 초과
public class Q15961 {
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
        // -> 기존 접시+쿠폰 번호 Set에 넣었을 때 개수 차이 안 날수록 이득
        // 0~N-k (0~4)
        int max = 0;
        for(int i=0;i<=N-k;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<i+k;j++){
                set.add(arr[j]);
                set.add(c);
            }
            // System.out.println("i: "+ i+", "+set.size());
            if(set.size()>max){
                max = set.size();
            }
        }

        System.out.println(max);
    }
}
