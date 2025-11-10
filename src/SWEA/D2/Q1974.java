package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q1974 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String[] tokens = br.readLine().split(" ");
                for(int j = 0; j < 9; j++){
                    arr[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            int result = 1;

            // 가로 검사
            for(int i=0;i<9;i++){
                HashSet<Integer> set = new HashSet<>();
                for(int j=0;j<9;j++){
                    if(!set.add(arr[i][j])) result = 0;
                }
            }

            // 세로 검사
            for(int i=0;i<9;i++){
                HashSet<Integer> set = new HashSet<>();
                for(int j=0;j<9;j++){
                    if(!set.add(arr[j][i])) result = 0;
                }
            }

            // 3x3 검사
            for(int r=0;r<9;r+=3){
                for(int c=0;c<9;c+=3){
                    HashSet<Integer> set = new HashSet<>();
                    for(int i=r;i<r+3;i++){
                        for(int j=c;j<c+3;j++){
                            if(!set.add(arr[i][j])) result = 0;
                        }
                    }
                }
            }

            System.out.println("#"+t+" "+result);

        }
    }
}
