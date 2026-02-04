package Baekjoon.algorithm.map_set;

import java.io.*;
import java.util.*;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> card = new HashMap<>();
        String[] cards = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(cards[i]);
            card.put(num,card.getOrDefault(num,0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(nums[i]);
            if(card.containsKey(num)){
                System.out.print(card.get(num)+" ");
            }
            else{
                System.out.print("0 ");
            }
        }
    }
}
