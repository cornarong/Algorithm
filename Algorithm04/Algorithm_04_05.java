package algorithm04;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

// ## K번째 큰 수 (TreeSet) ##
// TreeSet -> 자동 오름차 정렬, 중복 제거

// * TreeSet 지원하는 다양한 메서드
// remove() -> 특정 값 제거 ex) set.remove(값);
// size() -> 원소의 갯수
// first() -> 오름차순이면 최솟값, 내림차순이면 최댓값 즉 -> 제일 앞의 값.
// last() -> 오름차순이면 최댓값, 내림차순이면 최솟값 즉 -> 제일 뒤의 값.

public class Algorithm_04_05 {

    static void Solution(int n, int k, int[] arr){

        int result = -1;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder()); // Collections.reverseOrder() -> 내림차 정렬 사용

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) { // j+!
                for (int l = j+1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : set) {
            cnt++;
            if(cnt==k) result = x;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution(n, k, arr);


    }
}
