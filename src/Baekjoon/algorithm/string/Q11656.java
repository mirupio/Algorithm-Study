package Baekjoon.algorithm.string;

import java.io.*;
import java.util.*;

public class Q11656 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int l = S.length();

        String[] arr = new String[l];
        for(int i=0;i<l;i++){
            arr[i] = S.substring(i,l);
        }

        Arrays.sort(arr);

        for(int i=0;i<l;i++){
            System.out.println(arr[i]);
        }
    }

}
