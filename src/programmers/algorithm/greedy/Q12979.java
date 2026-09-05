package programmers.algorithm.greedy;

class Q12979 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int wdis = 2*w+1;

        int left = 1;
        int right = 0;
        int count = 0;
        for(int station: stations){
            right = station-w-1;

            int dis = right-left+1;
            if(dis>=1){
                if(dis%wdis == 0){
                    count += dis/wdis;
                }
                else{
                    count += dis/wdis+1;
                }
            }
            // System.out.println("station="+station+" left="+left+" right="+right+" dis="+dis+" count="+count);
            left = station+w+1;
        }

        right = n;
        int dis = right-left+1;
        if(dis>=1){
            if(dis%wdis == 0){
                count += dis/wdis;
            }
            else{
                count += dis/wdis+1;
            }
        }

        // System.out.println(" left="+left+" right="+right+" dis="+dis+" count="+count);
        return count;
    }
}