package programmers;

// ## 로또의 최고 순위와 최저 순위 ##
// https://programmers.co.kr/learn/courses/30/lessons/77484?language=java
public class Solution77484 {

    static int[] lottos = {45, 4, 35, 20, 3, 9};
    static int[] win_nums ={20, 9, 3, 45, 4, 35};

    public int[] solution(int[] lottos, int[] win_nums) {
    int[] score = {6,6,5,4,3,2,1}; // 일치갯수를 인덱스로 넣으면 순위를 뱉도록
        int[] answer = new int[2];
        int zero = 0, sum = 0;
        for(int x : lottos){
            if(x == 0) zero++;
            else{
                for(int y : win_nums)if(x == y) sum++;
            }
        }
        answer[0] = score[sum+zero];
        answer[1] = score[sum];
        return answer;
    }

    public static void main(String[] args) {
        Solution77484 s = new Solution77484();
        s.solution(lottos, win_nums);
    }
}
