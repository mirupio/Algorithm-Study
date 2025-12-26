package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 틀린 답안 -> 시간 초과
public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str;
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if(arr[j].equals(str)) {
                    list.add(str);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (String str : list) {
            System.out.println(str);
        }
    }
}
