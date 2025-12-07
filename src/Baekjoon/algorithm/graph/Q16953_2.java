package Baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16953_2 {
    static long A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(bfs(A));
    }

    static int bfs(long start) {
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{start,1}); // 값, 연산 횟수

        while (!queue.isEmpty()) {
            long[] cur = queue.poll();
            long num = cur[0];
            long count = cur[1];

            if (num == B) {
                return (int) count;
            }

            long next1 = mul2(num);
            if (next1 <= B) {
                queue.add(new long[]{next1,count+1});
            }

            long next2 = add1(num);
            if (next2 <= B) {
                queue.add(new long[]{next2,count+1});
            }

        }
        return -1;
    }

    static long mul2(long before) {
        return before * 2;
    }

    static long add1(long before) {
        String num = before + "1";
        return Long.parseLong(num);
    }
}
