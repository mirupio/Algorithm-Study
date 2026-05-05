package programmers.gilbut;

import java.util.*;

class Q87377 {
	public String[] solution(int[][] line) {
		List<int[]> list = new ArrayList<>();

		for(int i=0;i<line.length;i++){
			for(int j=i+1;j<line.length;j++){
				int A = line[i][0];
				int B = line[i][1];
				int E = line[i][2];

				int C = line[j][0];
				int D = line[j][1];
				int F = line[j][2];

				if(isAvailable(A,B,C,D)){

					long denominator = (long)A*D - (long)B*C;

					long numeratorX = (long)B*F - (long)E*D;
					long numeratorY = (long)E*C - (long)A*F;

					if(numeratorX % denominator != 0 || numeratorY % denominator != 0){
						continue;
					}

					long result_x = numeratorX / denominator;
					int x;
					if(result_x == (long)result_x){
						x = (int)result_x;
					}
					else{
						continue;
					}

					long result_y = numeratorY / denominator;
					int y;
					if(result_y == (long)result_y){
						y = (int)result_y;
					}
					else{
						continue;
					}

					list.add(new int[]{x,y});
				}
			}
		}

		long h_min = Long.MAX_VALUE;
		long h_max = Long.MIN_VALUE;
		long v_min = Long.MAX_VALUE;
		long v_max = Long.MIN_VALUE;
		for(int l=0;l<list.size();l++){
			h_min = Math.min(h_min,list.get(l)[0]);
			h_max = Math.max(h_max,list.get(l)[0]);
			v_min = Math.min(v_min,list.get(l)[1]);
			v_max = Math.max(v_max,list.get(l)[1]);
		}

		int height = (int)(v_max-v_min+1);
		int width = (int)(h_max-h_min+1);
		char[][] arr = new char[height][width];
		for(int h=0;h<height;h++){
			for(int v=0;v<width;v++){
				arr[h][v] = '.';
			}
		}

		for(int[] l:list){
			int x = l[0];
			int y = l[1];

			int row = (int)(v_max - y);
			int col = (int)(x - h_min);

			arr[row][col] = '*';
		}

		String[] answer = new String[height];
		for(int i=0;i<height;i++){
			answer[i] = new String(arr[i]);
		}

		return answer;
	}

	boolean isAvailable(int A, int B, int C, int D){
		if((long)A*D-(long)B*C == 0){
			return false;
		}
		else{
			return true;
		}
	}
}
