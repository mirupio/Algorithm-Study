package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1220_print {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 1; t++) {
            br.readLine();
            // 배열 입력
            int[][] arr = new int[7][7];
            for(int i = 0; i < 7; i++) {
                String[] tokens = br.readLine().split(" ");
                for(int j = 0; j < 7; j++) {
                    arr[i][j] = tokens[j].charAt(0)-'0';
                }
            }

            /*for(int i = 0; i < 7; i++) {
                for(int j = 0; j < 7; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }*/

            int count=0;
            for(int i = 0; i < 7; i++) {
                for(int j = 0; j < 7; j++) {
                    System.out.println("j : "+j);
                    if(arr[j][i] == 1){
                        System.out.println("1만남");
                        for (int k = j+1; k < 7; k++) {
                            if(arr[k][i] == 2){
                                System.out.println("교착 "+k+"행"+i+"열");
                                count++;
                                j = k; // 2 등장 이후부터 다시 시작
                                System.out.println("j 바뀐 후 : "+j);
                                break;
                            }
                        }
                    }

                }
            }

            System.out.println(count);
        }
    }
}
