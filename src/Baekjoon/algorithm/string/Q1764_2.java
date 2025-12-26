package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1764_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            set.add(str);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(set.contains(str)) {
                list.add(str);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (String str : list) {
            System.out.println(str);
        }
    }
}
