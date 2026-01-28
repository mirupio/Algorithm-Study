package Baekjoon.algorithm.string;

import java.io.*;

public class Q11654 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int ascii = (int) s.charAt(0);

        System.out.print(ascii);
    }
}
