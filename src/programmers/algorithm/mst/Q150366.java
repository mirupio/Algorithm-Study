package programmers.algorithm.mst;

import java.util.*;

class Q150366 {
    static int[] parent;
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();

        String[] table = new String[2500];
        Map<String,Integer> map = new HashMap<>();

        parent = new int[2500];
        for(int i=0;i<2500;i++){
            parent[i] = i;
        }

        for(int i=0;i<commands.length;i++){
            String command = commands[i];

            String[] tokens = command.split(" ");
            String action = tokens[0];

            if(action.equals("UPDATE")){
                if(tokens.length == 4){
                    int r = Integer.parseInt(tokens[1]);
                    int c = Integer.parseInt(tokens[2]);
                    String value = tokens[3];

                    int num = (r-1)*50+(c-1);

                    int root = find(num);

                    table[root] = value;
                }

                else{
                    String value1 = tokens[1];
                    String value2 = tokens[2];

                    for(int j=0;j<2500;j++){
                        if(value1.equals(table[j])){
                            table[j] = value2;
                        }
                    }
                }
            }

            else if(action.equals("MERGE")){
                int r1 = Integer.parseInt(tokens[1]);
                int c1 = Integer.parseInt(tokens[2]);
                int r2 = Integer.parseInt(tokens[3]);
                int c2 = Integer.parseInt(tokens[4]);

                int num1 = (r1-1)*50+(c1-1);
                int num2 = (r2-1)*50+(c2-1);

                int root1 = find(num1);
                int root2 = find(num2);

                if(root1 != root2){
                    String value;

                    if(table[root1] != null){
                        value = table[root1];
                    }
                    else{
                        value = table[root2];
                    }

                    parent[root2] = root1;
                    table[root1] = value;
                    table[root2] = null;
                }
            }

            else if(action.equals("UNMERGE")){
                int r = Integer.parseInt(tokens[1]);
                int c = Integer.parseInt(tokens[2]);

                int num = (r-1)*50+(c-1);

                int root = find(num);

                String value = table[root];

                List<Integer> group = new ArrayList<>();
                for(int j=0;j<2500;j++){
                    if(find(j) == root){
                        group.add(j);
                    }
                }
                for(int x: group){
                    parent[x] = x;
                    table[x] = null;
                }

                table[num] = value;
            }

            else{
                int r = Integer.parseInt(tokens[1]);
                int c = Integer.parseInt(tokens[2]);

                int num = (r-1)*50+(c-1);

                int root = find(num);

                if(table[root] == null){
                    answer.add("EMPTY");
                }
                else{
                    answer.add(table[root]);
                }
            }
        }

        return answer.toArray(new String[0]);
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x]=find(parent[x]);
    }
}