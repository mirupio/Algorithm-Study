package programmers.gilbut.ch11_datastructure;

import java.util.*;

class Q42892 {
    class Node{
        int num;
        int x;
        int y;

        Node left;
        Node right;

        Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    // parent 밑에 child 넣기
    void insert(Node parent, Node child){
        // 왼쪽에 삽입
        if(child.x < parent.x){
            if(parent.left == null){
                parent.left = child;
            }
            else{
                insert(parent.left,child);
            }
        }
        // 오른쪽에 삽입
        else{
            if(parent.right == null){
                parent.right = child;
            }
            else{
                insert(parent.right,child);
            }
        }
    }

    List<Integer> preResult = new ArrayList<>();
    List<Integer> postResult = new ArrayList<>();

    // 전위 순회 : root -> left -> right
    void preorder(Node node){
        if(node == null){
            return;
        }

        preResult.add(node.num);
        preorder(node.left);
        preorder(node.right);
    }

    // 후위 순회 : left -> right -> root
    void postorder(Node node){
        if(node == null){
            return;
        }

        postorder(node.left);
        postorder(node.right);
        postResult.add(node.num);
    }

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] answer = new int[2][n];

        Node[] nodes = new Node[n];
        for(int i=0;i<n;i++){
            nodes[i] = new Node(i+1,
                    nodeinfo[i][0],
                    nodeinfo[i][1]);
        }

        // y기준 내림차순
        Arrays.sort(nodes,(a,b)->b.y-a.y);

        Node root = nodes[0];
        for(int i=1;i<n;i++){
            insert(root,nodes[i]);
        }

        preorder(root);
        postorder(root);

        for(int i=0;i<n;i++){
            answer[0][i] = preResult.get(i);
            answer[1][i] = postResult.get(i);
        }

        return answer;
    }
}