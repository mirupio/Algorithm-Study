package programmers.algorithm.greedy;

class Q42860 {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;

        for(int i=0;i<name.length();i++){

            // 위아래 이동
            // 아스키-'A' vs 26-(아스키-'A')
            answer += Math.min(name.charAt(i)-'A'
                    ,26-(name.charAt(i)-'A'));

            // 좌우
            // 0부터 N번 인덱스까지 이동
            // vs 0부터 오른쪽으로 가다가 A 만나면 다시 왼쪽으로 이동
            // vs 왼쪽으로 가다가 A 만나면 다시 오른쪽으로 이동

            // 연속된 A 찾기
            int next = i+1;
            while(next<name.length() && name.charAt(next) == 'A'){
                next++;
            }

            move = Math.min(move, Math.min(i*2+(name.length()-next),
                    (name.length()-next)*2+i));

        }

        return answer+move;
    }
}