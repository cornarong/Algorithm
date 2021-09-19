package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

// ## 로프 (수학, 그리디 알고리즘, 정렬, 물리학) ##
// https://www.acmicpc.net/problem/2217
// ** 문제의 규칙을 찾아내는 것이 제일 중요하다.
// n개의 로프중 k개를 사용하여 w를 구할 때 가장 큰 값을 구한다.
// n개의 로프중 n개 부터 1개 까지 사용하는 모든 경우의 수를 구해야 한다.
// 즉 n개의 로프 중 k개를 선택하여 들 수 있는 최대 무게는 해당 선택한 로프(k)중 가장 작은 값이다.
// (가장 작은 값 보다 크면 가장 작은 값의 로프는 끊어지기 때문이다.)
// 선택한 k(로프들)중 가장 작은 값 * 로프의 수(k)를 연산하면 k개의 로프를 사용하여 들 수 있는 최대 중량이 나온다.
// (문제 내용 중 "k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다."를 참고)
// 구해진 최대중량들을 비교하여 가장 큰 값을 담는다.

// tip : PriorityQueue를 사용하여 자동정렬, poll()을 이용한 사이즈 감소를 사용했다.

public class Main2217 {

    public static void main(String[] args) {

        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            pQ.add(sc.nextInt());
        }

        int result = Integer.MIN_VALUE;
        while(!pQ.isEmpty()){
            int len = pQ.size();
            int num = pQ.poll();
            result = Math.max(num * len, result);
        }

        System.out.println(result);
    }
}