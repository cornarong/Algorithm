package algorithm08;

import java.util.Scanner;

// ## 합이 같은 부분 집합 (DFS:아마존 인터뷰) ##
// 재귀함수
public class Algorithm_08_01 {

    static int n; // 주어진 원소 갯수.
    static int total; // 주어진 원소의 전체 합.
    static int[] arr; // 주어진 원소를 담을 배열.
    static boolean flag = false; // 찾기전 flag값 false
    static String result = "NO"; // 출력 결과값 NO로 초기화.

    static void DFS(int level , int sum) {
        if(flag) return; // false 일때만 진행되도록. 한번만 정답이 나오면 YES니깐.
        if(sum > total/2) return; // total/2가 현재까지 구한 sum보다 크면 그 아래로 구할 필요 없다.
        if(level == n){
            if((total-sum) == sum){ // 나누기2 로 사용할 경우 반올림으로 예외 상황 발생할 수 있음.
                result = "YES";
                flag = true; // 한번 YES가 나오면 flag = true 그후로 타는 재귀함수는 전부 return된다.
            }
        }else{
            // 현재의 다음 레벨과 배열의 현재레벨 인덱스 값을 sum에 누적 후 전달.
            DFS(level+1,sum+arr[level]);
            // 현재의 다음 레벨과 기존에 누적된 sum을 전달
            DFS(level+1,sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // 배열에 n개의 원소를 대입.
            total += arr[i]; // 배열값을 total에 누적.
        }
        // 레벨과 sum의 인덱스는 1차이 -> 레벨은 1 2 3 4 5 6 / sum의 인덱스는 0 1 2 3 4 5
        DFS(0, 0);
        System.out.println(result);
    }
}
