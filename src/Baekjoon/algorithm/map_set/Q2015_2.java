package Baekjoon.algorithm.map_set;

import java.io.*;

// 틀립 답안 -> 시간 초과
public class Q2015_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);

        tokens = br.readLine().split(" ");
        int[] arr = new int[N];
        arr[0] = Integer.parseInt(tokens[0]);
        for(int i=1;i<N;i++){
            arr[i] = arr[i-1] + Integer.parseInt(tokens[i]);
        }

        /*for(int i=0;i<N;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();*/

        int count = 0;
        // i~j 까지의 합 = 0~j - 0~i-1
        // 0~1, 0~2, 0~N-1 -> 그냥 arr[j]
        for(int j=0;j<N;j++){
            int num = arr[j];
            if(num==K){
                count++;
            }
        }
        // 1~2, 1~3, ...
        for(int i=1;i<N;i++){
            for(int j=i;j<N;j++){
                int num = arr[j]- arr[i-1];
                if(num == K){
                    count++;
                }
            }
        }

        /*for(int n:map.keySet()){
            System.out.println(n+": "+map.get(n));
        }
        System.out.println();*/
        System.out.println(count);

    }
}
