package algorithm07;

import java.util.LinkedList;
import java.util.Queue;

// ## Tree 말단노드까지의 가장 짧은 경로(DFS,BFS) 연습 ##
public class Algorithm_07_09 {

    Node root; // 전역변수로 root 선언

    static class Node{
        int val;
        Node lt, rt;
        public Node(int val){
            this.val = val;
            this.lt = null;
            this.rt = null;
        }
    }
    // ## DFS ##
    public int DFS(int level, Node root){ // * DFS는 if ~ else
        if(root.lt == null && root.rt == null){ // 말단노드 도착하면 return 해준다.
            return level;
        }else{
            // Math.min(왼쪽 말단노드의 리턴값 ,오른쪽 말단노드의 리턴값);
            // 아래와 같은 패턴은 무조건 자식노드가 2개씩 있어야 한다. 하나는 에러.
            return Math.min(DFS(level+1,root.lt),DFS(level+1,root.rt));
        }
    }
    // ## BFS ##
    public int BFS(int level, Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int check = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node temp = Q.poll();
                if(temp.lt == null && temp.rt == null) return level;
                if(temp.lt != null) Q.offer(temp.lt);
                if(temp.rt != null) Q.offer(temp.rt);
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        
        Algorithm_07_09 T = new Algorithm_07_09();
        T.root = new Node(1);
        T.root .lt = new Node(2);
        T.root .rt = new Node(3);
        T.root .lt.lt = new Node(4);
        T.root .lt.rt =  new Node(5);

        int DFS_result = T.DFS(0,T.root);
        int BFS_result = T.BFS(0,T.root);

        System.out.println("DFS_result = " + DFS_result);
        System.out.println("BFS_result = " + BFS_result);
        
    }
}
