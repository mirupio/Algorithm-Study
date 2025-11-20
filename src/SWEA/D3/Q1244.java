package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 틀린 답안 -> 반례가 있어서 이 규칙은 안됨
public class Q1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            System.out.println("#"+t+" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int[] arr = new int[s.length()];
            for(int i=0;i<arr.length;i++) {
                arr[i] = Integer.parseInt(s.substring(i,i+1));
            }
            int change = Integer.parseInt(st.nextToken());

            for(int i=0;i<arr.length;i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            System.out.println("change = " + change);

            int count = 0;
            while(count < change){
                for (int i = 0; i < arr.length; i++) {
                    int max=0;
                    int max_index=i;
                    for(int j=arr.length-1;j>=i;j--) {
                        if (arr[j] > max) {
                            max = arr[j];
                            max_index = j;
                            // System.out.println("max = " + max);
                            // System.out.println("max_index = " + max_index);
                        }
                    }
                    // 젤 큰게 그 자리 x
                    if(max != arr[i]){
                        // 교환
                        int temp = arr[i];
                        arr[i] = arr[max_index];
                        arr[max_index] = temp;
                        count++;
                        System.out.println("count = " + count);
                        for(int k = 0; k <arr.length; k++) {
                            System.out.print(arr[k]+" ");
                        }
                        System.out.println();
                    }
                }
            }

            /*for(int i=0;i<arr.length;i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();*/

        }
    }
}
