package Baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 틀린 답안 -> 최단 거리는 dfs로 풀 수 없음
public class Q16953 {
    static int A,B;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[B + 1];
        dfs(A, visited);
        System.out.println("count: "+count);

    }

    static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node+" ");

        List<Integer> nexts = new ArrayList<>();
        if (mul2(node) <= B) {
            nexts.add(mul2(node));
        }
        if (add1(node) <= B) {
            nexts.add(add1(node));
        }
        for(int next : nexts) {
            if(!visited[next]) {
                dfs(next, visited);
                count++;
            }
        }
    }

    static int mul2(int before) {
        return before * 2;
    }

    static int add1(int before) {
        String num = before + "1";
        return Integer.parseInt(num);
    }
}
