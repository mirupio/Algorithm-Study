package programmers.algorithm.greedy;

class Q468372 {
    public int solution(int dist_limit, int split_limit) {
        long answer = 1;

        long leaf2 = 1;
        long used2 = 0;
        long split2 = 1;

        // 자식이 2개인 깊이의 개수
        while (true) {
            long leaf = leaf2;
            long used = used2;
            long split = split2;

            // 이후 자식이 3개인 깊이를 추가
            while (true) {
                answer = Math.max(answer, leaf);

                // 일부 확장: 남은 분배 노드를 모두 사용한 최종 리프 수 계산
                long remain = dist_limit - used;
                long add = Math.min(leaf, remain);

                // 다음 깊이를 자식 2개로 확장
                if (split * 2 <= split_limit) {
                    answer = Math.max(answer, leaf + add);
                }

                // 다음 깊이를 자식 3개로 확장
                if (split * 3 <= split_limit) {
                    answer = Math.max(answer, leaf + add * 2);
                }

                // 전체 확장: 현재 깊이의 모든 리프를 자식 3개인 분배 노드로 바꾸고 다음 깊이 탐색
                if (split * 3 > split_limit || used + leaf > dist_limit) {
                    break;
                }

                used += leaf;
                leaf *= 3;
                split *= 3;
            }

            // 자식 2개인 깊이를 하나 더 추가
            if (split2 * 2 > split_limit ||
                    used2 + leaf2 > dist_limit) {
                break;
            }

            used2 += leaf2;
            leaf2 *= 2;
            split2 *= 2;
        }

        return (int) answer;
    }
}