package programmers.algorithm.implementation;

class Q250137 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];

        int sum = health;
        int stop = 0;
        for(int[] attack: attacks){
            int attackTime = attack[0];
            int amount = attack[1];

            // 회복
            int success = attackTime-stop-1;
            sum += success*x;
            sum += success/t*y;

            if(sum > health){
                sum = health;
            }

            // System.out.print("회복: "+sum+" ");
            // 공격
            sum -= amount;

            // System.out.println("공격: "+sum);
            if(sum <= 0){
                return -1;
            }

            stop = attackTime;
        }

        return sum;
    }
}