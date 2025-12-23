package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1316 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean[] visited = new boolean[26];
            char before = str.charAt(0);
            visited[str.charAt(0)-'a'] = true;
            boolean group = true;
            for(int j = 1; j < str.length(); j++) {
                if(before == str.charAt(j)) {
                    continue;
                }
                else {
                    if (!visited[str.charAt(j)-'a']) {
                        visited[str.charAt(j)-'a'] = true;
                        before = str.charAt(j);
                    }
                    else{
                        group = false;
                    }
                }
            }
            if(group) {
                sum += 1;
            }
        }

        System.out.println(sum);
    }
}
