package algorithm08;

import java.util.Scanner;

// ## 최대 점수 구하기 (DFS) ##
// 재귀함수 사용. 이진트리 레벨 순회.
public class Algorithm_08_03 {

    static int n; // 문제의 갯수
    static int m; // 제한시간
    static int result = 0; // 결과 값
    static int[] scoreArr; // 점수 배열
    static int[] timeArr; // 시간 배열

    static void DFS(int level, int timeSum, int scoreSum){

        if(timeSum > m) return; // 현재 level까지의 timeSum이 제한시간 m보다 크면 return;
        if(level == n){ // 마지막 level도착 후 조건 확인
            if(result < scoreSum){ // 현재 level까지 의 scoreSum이 결과 값 보다 크면 대입
                result = scoreSum;
                return;
            }
        }else{
            // 문제를 푼다. (O)
            DFS(level+1,timeSum+timeArr[level], scoreSum+scoreArr[level]);
            // 문제를 풀지 않는다. (X)
            DFS(level+1, timeSum, scoreSum);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n개의 문제
        m = sc.nextInt(); // 제한시간 m
        scoreArr = new int[n];
        timeArr = new int[n];
        for (int i = 0; i < n; i++) {
            scoreArr[i] = sc.nextInt(); // 점수 배열
            timeArr[i] = sc.nextInt(); // 시간 배열
        }
        // level:0 , timeSum:0, scoreSum:0을 넘긴다.
        // ex) level1 - index0 / level2 - index1
        DFS(0,0, 0);
        System.out.println(result);

    }
}
