package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1940 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            int N = Integer.parseInt(br.readLine());

            int distance = 0;
            int velocity = 0;
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());

                if(command==0) {
                    distance += velocity;
                }
                else if(command==1) {
                    int acc = Integer.parseInt(st.nextToken());
                    velocity += acc;
                    distance += velocity;
                }
                else if(command==2) {
                    int acc = Integer.parseInt(st.nextToken());
                    velocity -= acc;
                    if(velocity < 0){
                        velocity = 0;
                    }
                    distance += velocity;
                }
            }
            System.out.println("#"+t+" "+distance);
        }

    }
}
