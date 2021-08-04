package programmers;

import java.util.Arrays;

// ## 프로그래머스_체육복_그리디알고리즘 ##
class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] dy = new int[n+1];
        Arrays.fill(dy,1);
        dy[0] = 3;
        for(int x : lost) dy[x] = dy[x] - 1;
        for(int x : reserve) dy[x] = dy[x] + 1;
        for (int i = 0; i < n; i++) {
            if(dy[i] == 0 && dy[i-1] == 2){
                dy[i] = 1;
                dy[i-1] = 1;
            }else if(dy[i] == 0 && dy[i+1] == 2){
                dy[i] = 1;
                dy[i+1] = 1;
            }
        }
        for (int x : dy){
            if(x == 1 || x == 2) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        체육복 main = new 체육복();
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        System.out.println(main.solution(n, lost, reserve));

    }
}
