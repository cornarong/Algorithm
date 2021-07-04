package algorithm05;

import java.util.Scanner;
import java.util.Stack;

// ## 크레인 인형뽑기(카카오) ##
public class Algorithm_05_03 {

    static void Solution(int n, int[][] board, int m, int[] moves){

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(int x : moves){
            for (int i = 0; i < n; i++) {
                if(board[i][x-1] != 0) {
                    if(!stack.isEmpty() && stack.peek() == board[i][x-1]) {
                        stack.pop();
                        cnt++;
                    }else {
                        stack.push(board[i][x-1]);
                    }
                    board[i][x-1] = 0;
                    break;
                }
            }
        }
        System.out.println(cnt*2);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        Solution(n, board, m, moves);








    }
}
