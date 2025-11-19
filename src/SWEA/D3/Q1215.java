package SWEA.D3;

import java.io.*;

class Q1215{
    static char[][] arr;
    static int count;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1;t<=10;t++){
            N = Integer.parseInt(br.readLine());
            arr = new char[8][8];
            for(int i=0;i<8;i++){
                String s = br.readLine();
                for(int j=0;j<8;j++){
                    arr[i][j] = s.charAt(j);
                }
            }

            count = 0;

            // 가로 검사
            for(int k=0;k<8;k++){ // row
                for(int i=0;i<=8-N;i++){ // col의 시작
                    if(isP_row(i,i+N-1,k) == true){
                        count++;
                    }
                }
            }

            // 세로 검사
            for(int k=0;k<8;k++){
                for(int i=0;i<=8-N;i++){
                    if(isP_col(i,i+N-1,k) == true){
                        count++;
                    }
                }
            }

            System.out.println("#"+t+" " +count);

        }
    }
    static boolean isP_row(int start, int end, int row) {
        while(start<=end){
            if(arr[row][start] != arr[row][end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static boolean isP_col(int start, int end, int col) {
        while(start<=end){
            if(arr[start][col] != arr[end][col]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

   
    