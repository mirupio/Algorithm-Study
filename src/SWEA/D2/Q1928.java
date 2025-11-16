package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q1928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        char[] table = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        for (int i = 0; i < table.length; i++) {
            map.put(table[i], i);
        }

        for(int t=1;t<=T;t++) {
            System.out.print("#"+t+" ");
            String s = br.readLine();

            String buffer = "";
            for(int i=0;i<s.length();i++) {
                String binary = Integer.toBinaryString(map.get(s.charAt(i)));
                while(binary.length()<6){
                    binary = "0"+binary;
                }
                buffer += binary;
            }

            for(int i=0;i<buffer.length();i+=8) {
                int decimal = Integer.parseInt(buffer.substring(i,i+8), 2);

                char ch = (char)decimal;

                System.out.print(ch);
            }

            System.out.println();
        }
    }
}
