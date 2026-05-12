package programmers.gilbut.ch3_Array;

import java.util.*;

class Q87377 {
	private static class Point{
		public final long x,y;

		private Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	private Point intersection(long A, long B, long C, long D, long E, long F) {
		double x = (double) (B*F - E*D) / (A*D - B*C);
		double y = (double) (E*C - A*F) / (A*D - B*C);

		if (x % 1 != 0 || y % 1 != 0) {
			return null;
		}

		return new Point((long)x, (long)y);
	}

	private Point getMinimumPoint(List<Point> points){
		long x_min = Long.MAX_VALUE;
		long y_min = Long.MAX_VALUE;

		for (Point p : points) {
			if (p.x < x_min) {
				x_min = p.x;
			}
			if (p.y < y_min) {
				y_min = p.y;
			}
		}

		return new Point(x_min, y_min);
	}

	private Point getMaximumPoint(List<Point> points){
		long x_max = Long.MIN_VALUE;
		long y_max = Long.MIN_VALUE;

		for (Point p : points) {
			if (p.x > x_max) {
				x_max = p.x;
			}
			if (p.y > y_max) {
				y_max = p.y;
			}
		}

		return new Point(x_max, y_max);
	}

	public String[] solution(int[][] line) {
		List<Point> list = new ArrayList<>();

		for(int i=0;i<line.length;i++){
			for(int j=i+1;j<line.length;j++){
				int A = line[i][0];
				int B = line[i][1];
				int E = line[i][2];

				int C = line[j][0];
				int D = line[j][1];
				int F = line[j][2];

				Point intersection = intersection(A, B, C, D, E, F);
				if (intersection != null) {
					list.add(intersection);
				}
			}
		}

		Point min = getMinimumPoint(list);
		Point max = getMaximumPoint(list);

		int height = (int)(max.y-min.y+1);
		int width = (int)(max.x-min.x+1);

		char[][] arr = new char[height][width];
		for (char[] row : arr) {
			Arrays.fill(row, '.');
		}

		for(Point p:list){
			int row = (int)(max.y - p.y);
			int col = (int)(p.x - min.x);

			arr[row][col] = '*';
		}

		String[] answer = new String[height];
		for(int i=0;i<height;i++){
			answer[i] = new String(arr[i]);
		}

		return answer;
	}
}
