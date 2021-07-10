package algorithm07;

import java.util.LinkedList;
import java.util.Queue;

// ## 이진트리 레벨탐색(BFS) 연습 ##
class Node{
    int val; // 인자
    Node lt;
    Node rt;
    public Node(int val){
        this.val = val;
        this.lt = null;
        this.rt = null;
    }
}

public class Algorithm_07_07 {

    Node root;

    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int Level = 0; // 레벨
        while (!Q.isEmpty()){ // Q가 비어있지 않으면 계속 돌린다.
            int len = Q.size(); // 처음엔 1개
            System.out.printf("Level" + Level + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.printf(cur.val+" ");
                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }
            Level++;
            System.out.println();
        }

    }
    public static void main(String[] args) {

        Algorithm_07_07 T = new Algorithm_07_07();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        T.root.rt.rt = new Node(6);
        T.root.rt.lt = new Node(7);
        T.BFS(T.root);

    }
}
