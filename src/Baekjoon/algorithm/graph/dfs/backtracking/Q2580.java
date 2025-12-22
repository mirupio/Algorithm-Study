package Baekjoon.algorithm.graph.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2580 {
    static int[][] arr;
    static boolean[][] rowVisited = new boolean[9][9];
    static boolean[][] colVisited = new boolean[9][9];
    static boolean[][] boxVisited = new boolean[9][9];
    static List<int[]> empties;
    static boolean solved;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[9][9];
        empties = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 빈 칸 수집
                if (arr[i][j] == 0) {
                    empties.add(new int[]{i, j});
                }
                else{
                    rowVisited[i][arr[i][j]-1] = true;
                    colVisited[j][arr[i][j]-1] = true;
                    boxVisited[(i/3)*3+j/3][arr[i][j]-1] = true;
                }
            }
        }

        dfs(0);

        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void dfs(int index) {
        if (solved) { // 답 한번 찾으면 멈춤
            return;
        }
        if(index == empties.size()) {
            solved = true;
            return;
        }

        int row = empties.get(index)[0];
        int col = empties.get(index)[1];
        int box = (row/3)*3 + col/3;
        for(int i = 0; i < 9; i++) {
            if(!rowVisited[row][i] && !colVisited[col][i] && !boxVisited[box][i]){
                rowVisited[row][i] = true;
                colVisited[col][i] = true;
                boxVisited[box][i] = true;
                arr[row][col] = i+1;
                dfs(index+1);

                if(solved) return;

                rowVisited[row][i] = false;
                colVisited[col][i] = false;
                boxVisited[box][i] = false;
                arr[row][col] = 0;
            }
        }
    }

}
