package Baekjoon.algorithm.map_set;

import java.io.*;
import java.util.*;

public class Q10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new TreeSet<>();

        String[] tokens = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(tokens[i]));
        }

        for(Integer i : set) {
            System.out.print(i + " ");
        }

    }
}
