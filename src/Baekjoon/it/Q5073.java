package Baekjoon.it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5073 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			int max = Math.max(a, b);
			max = Math.max(max, c);
			int sum = a+b+c;
			if (max < sum - max) {
				if ((a == b) && (b == c)) {
					System.out.println("Equilateral");
				}

				else if((a==b) && (a!=c)){
					System.out.println("Isosceles");
				}
				else if((a==c) && (a!=b)){
					System.out.println("Isosceles");
				}
				else if((b==c) && (a!=b)){
					System.out.println("Isosceles");
				}

				else {
					System.out.println("Scalene");
				}
			}
			else{
				System.out.println("Invalid");
			}

		}
	}
}
