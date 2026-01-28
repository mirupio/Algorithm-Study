package Baekjoon.algorithm.string;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class Q2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = Set.of("c=","c-","dz=","d-","lj","nj","s=","z=");
        String str = br.readLine();

        int sum = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            String s2 = i<str.length()-1? str.substring(i, i + 2):"";
            // System.out.println("s2: "+s2);

            String s3 = i<str.length()-2? str.substring(i, i + 3):"";
            // System.out.println("s3: "+s3);
            if (set.contains(s2)) {
                // System.out.println("1: "+s2);
                sum++;
                i += 1;
            }
            else if(set.contains(s3)) {
                // System.out.println("2: "+s3);
                sum++;
                i += 2;
            }
            else{
                // System.out.println("3: "+str.charAt(i));
                sum++;
            }
        }

        System.out.print(sum);
    }
}
