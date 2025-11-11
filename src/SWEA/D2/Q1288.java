package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q1288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            int count = 0;
            Set<Integer> set = new HashSet<>();

            while(set.size()!=10){ // 집합 크기가 10이 될 때까지 = 0~9 다 모았을 때
                count++;
                int temp = N*count;

                // temp의 각 자리수 기록
                while(temp > 0){
                    set.add(temp%10); // 1의 자리 추출해서 집합에 넣기
                    temp/=10; // 자리 이동
                }
            }

            System.out.println("#"+t+" "+ count*N);
        }
    }
}
