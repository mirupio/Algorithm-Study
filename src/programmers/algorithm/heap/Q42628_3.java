package programmers.algorithm.heap;

import java.util.*;

class Q42628_3 {

    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (String operation : operations) {
            char command = operation.charAt(0);
            int number = Integer.parseInt(operation.substring(2));

            if (command == 'I') {
                treeMap.put(
                        number,
                        treeMap.getOrDefault(number, 0) + 1
                );
            } else {
                if (treeMap.isEmpty()) {
                    continue;
                }

                int key;

                if (number == 1) {
                    key = treeMap.lastKey();
                } else {
                    key = treeMap.firstKey();
                }

                if (treeMap.get(key) == 1) {
                    treeMap.remove(key);
                } else {
                    treeMap.put(key, treeMap.get(key) - 1);
                }
            }
        }

        if (treeMap.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{
                treeMap.lastKey(),
                treeMap.firstKey()
        };
    }
}