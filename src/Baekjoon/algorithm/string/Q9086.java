package Baekjoon.algorithm.string;

import java.io.*;

public class Q9086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String st = br.readLine();
            System.out.print(st.charAt(0));
            System.out.println(st.charAt(st.length()-1));
        }
    }
}
