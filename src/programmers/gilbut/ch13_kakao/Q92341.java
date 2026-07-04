package programmers.gilbut.ch13_kakao;

import java.util.*;

class Q92341 {
    public int[] solution(int[] fees, String[] records) {
        // 차량번호, 시간대(분)
        Map<Integer, Integer> inTime = new HashMap<>();
        Map<Integer, Integer> totalTime = new HashMap<>(); // 누적 주차 시간
        for(String record:records){
            int carNum = Integer.parseInt(record.substring(6,10));
            int time = changeToMinute(record.substring(0,5));

            // 출차가 있다면 -> 출차 - 입차
            if(inTime.containsKey(carNum)){ // IN 존재 -> 현재는 OUT
                int meanTime = time - inTime.get(carNum);
                totalTime.put(carNum,totalTime.getOrDefault(carNum,0)+meanTime);
                inTime.remove(carNum); // IN 제거
            }
            else{
                inTime.put(carNum,time);
            }
        }

        // 출차가 없다면 23:59(1439분)-입차
        for(int car : inTime.keySet()){
            int meanTime = 1439 - inTime.get(car);
            totalTime.put(car,totalTime.getOrDefault(car,0)+meanTime);
        }

        // 주차 요금
        List<Integer> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);
        int[] answer = new int[cars.size()];

        for(int i=0;i<cars.size();i++){
            int totalFee = 0;
            // 누적 주차 시간 <= 기본 시간 -> 기본 요금
            if(totalTime.get(cars.get(i))<=fees[0]){
                totalFee = fees[1];
            }
            // 누적 주차 시간 > 기본 시간
            // -> 기본 요금 + (누적 주차 시간-기본 시간)/단위 시간*단위 요금
            else{
                totalFee = fees[1]
                        +(int)Math.ceil((double)(totalTime.get(cars.get(i))-fees[0])/fees[2])*fees[3];
            }

            answer[i] = totalFee;
        }

        return answer;
    }

    static int changeToMinute(String time){
        return Integer.parseInt(time.substring(0,2))*60
                + Integer.parseInt(time.substring(3,5));
    }
}