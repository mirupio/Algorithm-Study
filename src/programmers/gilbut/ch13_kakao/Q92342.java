package programmers.gilbut.ch13_kakao;

class Q92342 {
    static int N;
    static int[] Info;
    static int max;
    static int[] answer = new int[11];
    public int[] solution(int n, int[] info) {
        N = n;
        Info = info;
        max = Integer.MIN_VALUE;

        int[] lion = new int[11];
        dfs(0,0,lion);

        if(max == Integer.MIN_VALUE){
            return new int[]{-1};
        }
        return answer;
    }

    static void dfs(int index, int count, int[] lion){
        if(count > N){
            return;
        }
        if(index == 11){
            // 화살 남은거 다 0점에 몰아줌
            lion[10] += N-count;

            int apeachGrade = 0;
            int lionGrade = 0;
            for(int j=0;j<10;j++){
                if(Info[j] >= lion[j] && Info[j] != 0){
                    apeachGrade += 10-j;
                }
                else if(Info[j] < lion[j]){
                    lionGrade += 10-j;
                }
            }

            int diff = lionGrade-apeachGrade;
            if(diff>0){
                // 점수차 더 큰거
                if(diff>max){
                    max = diff;
                    answer = lion.clone();
                }

                // 점수차 같으면 낮은 점수가 더 많은 거
                else if(diff==max){
                    for(int i=10;i>=0;i--){
                        if(lion[i] > answer[i]){
                            answer = lion.clone();
                            break;
                        }
                        else if(lion[i] < answer[i]){
                            break;
                        }
                    }
                }
            }

            return;
        }

        // 라이언 승
        lion[index] = Info[index]+1;
        dfs(index+1,count+lion[index],lion);

        // 라이언 포기
        lion[index] = 0;
        dfs(index+1,count,lion);
    }
}