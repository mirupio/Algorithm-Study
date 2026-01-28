package Baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1181 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while (N-- > 0) {
            String st = br.readLine();
            set.add(st);
        }

        List<String> list = new ArrayList<>(set);
        list.sort((a, b) ->
                a.length()==b.length()?
                        a.compareTo(b): a.length()-b.length());

        for(String s : list) {
            System.out.println(s);
        }
    }
}
