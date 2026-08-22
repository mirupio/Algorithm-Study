package programmers.algorithm.simulation;

class Q250135 {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        int count = 0;

        // 시작 순간에 이미 겹쳐있으면 알람
        if (calSecond(start) == calMin(start)
                || calSecond(start) == calHour(start)) {
            count++;
        }

        for (int t = start; t < end; t++) {

            double curSecond = calSecond(t);
            double curMin = calMin(t);
            double curHour = calHour(t);

            double nextSecond = calSecond(t + 1);
            double nextMin = calMin(t + 1);
            double nextHour = calHour(t + 1);

            // 360 → 0 보정
            if (nextSecond < curSecond) {
                nextSecond += 360;
            }

            if (nextMin < curMin) {
                nextMin += 360;
            }

            if (nextHour < curHour) {
                nextHour += 360;
            }

            boolean meetMin =
                    curSecond < curMin &&
                            nextSecond >= nextMin;

            boolean meetHour =
                    curSecond < curHour &&
                            nextSecond >= nextHour;

            if (meetMin) count++;
            if (meetHour) count++;

            // 같은 1초 안에 둘 다 만난다고 같은 순간은 아님!
            // 세 바늘이 실제로 동시에 겹치는 경우만 하나 제거
            if (meetMin && meetHour && (t + 1) % 43200 == 0) {
                count--;
            }
        }

        return count;
    }

    static double calHour(int second){
        return second * (1 / 120.0) % 360;
    }

    static double calMin(int second){
        return second * (1 / 10.0) % 360;
    }

    static double calSecond(int second){
        return second * 6.0 % 360;
    }
}