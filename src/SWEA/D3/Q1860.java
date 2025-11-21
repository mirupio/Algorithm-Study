package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1860 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            int max = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                int sec = Integer.parseInt(st.nextToken());
                arr[i] = sec;
                max = Math.max(max, arr[i]);
            }

            Arrays.sort(arr);

            int[] fish = new int[max+1];
            fish[0] = 0;
            boolean ok = true;
            // 초마다 붕어빵 개수 초기화
            for(int i=1;i<max+1;i++) {
                // M의 배수마다 붕어빵 업데이트
                if (i % M == 0) {
                    /*System.out.println("i = " + i);
                    System.out.println("fish[i] = " + fish[i]);*/
                    fish[i] = fish[i-1]+ K; // 해당 초에 가지고 있는 붕어빵
                }
                else{
                    /*System.out.println("i = " + i);
                    System.out.println("fish[i-1] = " + fish[i-1]);
                    System.out.println("fish[i] = " + fish[i]);*/
                    fish[i] = fish[i-1];
                }
            }

            /*System.out.println("초기화된 붕어빵 개수");
            for(int i=0;i<max+1;i++) {
                System.out.print(fish[i]+" ");
            }
            System.out.println();*/
            outer:
            for(int i=0;i<max+1;i++) {
                for (int sec : arr) {
                    if (i == sec) {
                        // System.out.println("sec = " + sec);
                        if(fish[i]-1 >= 0){
                            // System.out.println("팔기");
                            // 현재~끝까지 붕어빵 수 1씩 감소
                            for (int j = i; j < max + 1; j++) {
                                fish[j]--;
                            }
                        }
                        else{
                            // System.out.println("못팜");
                            ok = false;
                            System.out.println("#"+t+" Impossible");
                            break outer;
                        }
                    }
                }
            }
            if (ok) {
                System.out.println("#"+t+" Possible");
            }

            /*System.out.println("남은 붕어빵 개수");
            for(int i=0;i<max+1;i++) {
                System.out.print(fish[i]+" ");
            }*/
        }
    }
}
