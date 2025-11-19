package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            String search = br.readLine();
            String str = br.readLine();

            int count=0;
            for (int i = 0; i < str.length() - (search.length() - 1); i++) {
                if(str.substring(i,i+search.length()).equals(search)) {
                    count++;
                }
            }
            System.out.println("#"+t+" " + count);
        }

    }
}
