package programmers.algorithm.heap;

import java.util.*;

class Q42628 {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        Map<Integer, Integer> countMap = new HashMap<>();

        for (String operation : operations) {
            char command = operation.charAt(0);
            int number = Integer.parseInt(operation.substring(2));

            if (command == 'I') {
                minHeap.offer(number);
                maxHeap.offer(number);

                countMap.put(
                        number,
                        countMap.getOrDefault(number, 0) + 1
                );
            } else if (number == 1) {
                clean(maxHeap, countMap);

                if (!maxHeap.isEmpty()) {
                    int max = maxHeap.poll();
                    countMap.put(max, countMap.get(max) - 1);
                }
            } else {
                clean(minHeap, countMap);

                if (!minHeap.isEmpty()) {
                    int min = minHeap.poll();
                    countMap.put(min, countMap.get(min) - 1);
                }
            }
        }

        clean(minHeap, countMap);
        clean(maxHeap, countMap);

        if (minHeap.isEmpty() || maxHeap.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{
                maxHeap.peek(),
                minHeap.peek()
        };
    }

    private void clean(
            PriorityQueue<Integer> pq,
            Map<Integer, Integer> countMap
    ) {
        while (!pq.isEmpty()
                && countMap.getOrDefault(pq.peek(), 0) == 0) {
            pq.poll();
        }
    }
}