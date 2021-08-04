package algorithm10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ## 최대점수 구하기(냅색 알고리즘) ##
// * 풀 수 있는 문제가 중복이 가능하면 다이나믹 배열(dy)를 반복문에서 오름차순으로 처리
// * 반대로 중복이 안될 경우 다이나믹 배열(dy)를 반복문에서 내림차순으로 처리
// * 제한 시간 내 최대점수를 얻어야한다. -> 시간을 기준으로 최소 1~n 까지의 배열을 만들어서 배열을 사용하여 해결한다.

public class Algorithm_10_06 {

    static class Exam{
        int es;
        int et;
        public Exam(int es, int et){
            this.es = es;
            this.et = et;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Exam> examArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            examArr.add(new Exam(s, t));
        }
        int[] dy = new int[m+1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= examArr.get(i).et; j--) {
                int et = examArr.get(i).et;
                int es = examArr.get(i).es;
                dy[j] = Math.max(dy[j], dy[j-et]+es);
            }
        }
        System.out.println(dy[m]);
    }
}