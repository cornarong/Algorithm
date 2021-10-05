package programmers2;

// ## [연습문제] 피보나치 수 ##
// https://programmers.co.kr/learn/courses/30/lessons/12945

public class Solution12945 {

    static int[] memoi;

    public int DFS(int n){
        if(memoi[n] != 0) return memoi[n];
        if(n==0) return memoi[n] = 0;
        else if(n==1) return memoi[n] = 1;
        // * 중요 포인트 (문제의 요점)
        // n번째 피보나치의 수를 memoi배열에 담을 때 마다 % 1234567 연산된 값을 넣어준다.
        else return memoi[n] = (DFS(n-1) + DFS(n-2)) % 1234567; 
    }

    public int solution(int n) {
        int answer = 1;
        memoi = new int[n+1];
        if(n >= 2){
            DFS(n);
            answer = memoi[n];
        }
        return answer;
    }
}
