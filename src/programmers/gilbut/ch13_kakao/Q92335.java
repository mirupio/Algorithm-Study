package programmers.gilbut.ch13_kakao;

import java.util.*;

class Q92335 {
    public int solution(int n, int k) {
        String num = changeToK(n,k);
        // 0 기준으로 나누기
        String[] nums = num.split("0");
        int count = 0;
        for(String number : nums){
            if(number.equals("")){
                continue;
            }
            if(isPrimeNumber(number)){
                count++;
            }
        }

        return count;
    }

    // n -> k진수로 변환
    // k로 나눈 나머지 이어 붙이기
    static String changeToK(int N, int K){
        StringBuilder sb = new StringBuilder();
        while(N>0){
            sb.append(N%K);
            N /= K;
        }
        String reversed = sb.reverse().toString();
        return reversed;
    }
    /*
    437674
    145891..1
    48630..1
    16210..0
    5403..1
    1801..0
    600..1
    200..0
    66..2
    22..0
    7..1
    2..1
    0..2
    */

    // 소수 판별
    static boolean isPrimeNumber(String num){
        long number = Long.parseLong(num);
        if(number < 2){
            return false;
        }
        boolean isPrime = true;
        for(long i=2;i*i<=number;i++){
            if(number%i == 0){
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}