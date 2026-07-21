package programmers.algorithm.dfsbfs;

import java.util.*;

class Q154540_dfs {
    static int[] dRow = {-1,1,0,0};
    static int[] dCol = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] arr;
    static int sum;
    public int[] solution(String[] maps) {

        arr = new int[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                char c = maps[i].charAt(j);
                if(c == 'X'){
                    arr[i][j] = -1;
                }
                else{
                    arr[i][j] = c-'0';
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        visited = new boolean[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(!visited[i][j] && arr[i][j] != -1){
                    sum = 0;
                    dfs(i,j);
                    list.add(sum);
                }
            }
        }

        int[] answer;
        if(list.size() <= 0){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            answer = new int[list.size()];
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
    static void dfs(int row, int col){
        visited[row][col] = true;
        sum += arr[row][col];

        for(int i=0;i<4;i++){
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if(nextRow>=0 && nextRow<arr.length
                    && nextCol>=0 && nextCol<arr[0].length
                    && !visited[nextRow][nextCol]
                    && arr[nextRow][nextCol] != -1){

                dfs(nextRow,nextCol);
            }
        }
    }
}