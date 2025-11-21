package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1225 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            br.readLine();

            Queue<Integer> queue = new LinkedList<Integer>();
            String[] tokens = br.readLine().split(" ");
            for (int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(tokens[i]));
            }

            int minus = 1;
            while (true) {
                int x = queue.poll();
                x -= minus;

                if (x <= 0) {
                    queue.add(0);
                    break;
                }
                else{
                    queue.add(x);
                }

                minus++;
                if (minus > 5) {
                    minus = 1;
                }
            }

            System.out.print("#"+t+" ");
            for (int i = 0; i < 8; i++) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();

        }
    }

}
