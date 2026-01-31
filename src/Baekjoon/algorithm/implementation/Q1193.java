package Baekjoon.algorithm.implementation;

import java.io.*;

public class Q1193 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        // 1      2      3     4       5       6     7      8      9      10      11
        // 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> 1/3 -> 1/4 -> 2/3 -> 3/2 -> 4/1 -> 5/1
        // 1 /1 2/ 3 2 1/ 1 2 3 4
        // 1 /2 1/ 1 2 3/ 4 3 2 1
        // X = 10 -> 4의 구간 4/1
        // X = 11 -> num=1 5의 구간 5/1
        // X = 12 -> num=2 4/2
        // 13 -> num=3 3/3
        // 15 -> 5의 구간 1/5
        // 16 -> num=1 6의 구간 1/6
        // 17 -> num=2 6의 구간 2/5
        int sum = 0;
        for(int i=0;i<=X;i++){
            sum += i;
            if(sum == X){
                // 짝수
                if(i%2 == 0){
                    System.out.print(i);
                    System.out.print("/");
                    System.out.print(1);
                }
                // 홀수
                else{
                    System.out.print(1);
                    System.out.print("/");
                    System.out.print(i);
                }
                break;
            }
            if(sum > X){
                sum -= i;
                int num = X - sum;
                // 짝수
                if(i%2 == 0){
                    System.out.print(num);
                    System.out.print("/");
                    System.out.print(i+1-num);
                }
                // 홀수
                else{
                    System.out.print(i+1-num);
                    System.out.print("/");
                    System.out.print(num);
                }
                break;
            }
        }
    }
}
