package Baekjoon.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {
    static int F,S,G,U,D;
    static Queue<int[]> queue;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        visited = new boolean[F+1];
        queue.add(new int[]{S, 0});
        visited[S] = true;

        int result = bfs();
        if (result != -1) {
            System.out.print(result);
        }
        else {
            System.out.print("use the stairs");
        }
    }

    static int bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int floor = cur[0];
            int dis = cur[1];
            // System.out.println("floor = " + floor+", dis = " + dis);

            if (floor == G) {
                return dis;
            }

            int next1 = floor + U;
            if (next1 <= F && !visited[next1]) {
                queue.add(new int[]{next1, dis + 1});
                visited[next1] = true;
            }

            int next2 = floor - D;
            if (next2 >= 1 && !visited[next2]) {
                queue.add(new int[]{next2, dis + 1});
                visited[next2] = true;
            }
        }
        return -1;
    }
}
