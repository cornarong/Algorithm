package algorithm08;

import java.util.*;

// ## 동전 교환(DFS) ##
public class Algorithm_08_04 {

    static int n; // 동전의 종류 갯수
    static Integer[] arr; // 동전의 종류 배열
    static int m; // 거스름 금액
    static int result = Integer.MAX_VALUE;

    static void DFS(int level, int sum){

        if(sum > m) return; // 거스름돈이 초과하면 return
        if(level >= result) return; // level(갯수)이 같거나 초과하면 return (level이 현재 구한 result보다 작은 걸 계속해서 구해야한다. 크거나 같으면 그냥 retun)
        if(sum == m){ // 금액의 합계(sum)과 거스름 금액이 같으면 참
            result = Integer.min(result,level); // 기존 구해놓은 result(level)과 현재level의 작은값을 대입
            return;
        }else{
            for (int i = 0; i < n; i++) {
                DFS(level+1,sum+arr[i]); // 다음 level과 동전의 종류 배열값을 가지고 호출
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 동전의 종류 갯수
        arr = new Integer[n]; // Collections.reverseOrder 사용 하기 위해선 기본타입이 아닌 객체타입으로 선언해줘야함.
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // n개의 동전의 종류
        }
        // 입력받은 동전들을 역순으로 정렬
        // 내림차순으로 큰 동전부터 처리해야 시간복잡도가 많이 줄어든다
        // ex) 오름차순 동전 1부터 시작 시 거스름돈이 15일 경우 level15 까지 진행된다.
        // 반면에 동전 5부터 시작할 경우 거스름돈이 15일 경우 level3 까지 진행되고 그 이상의 level은 조건에서 return한다.
        Arrays.sort(arr,Collections.reverseOrder());
        m = sc.nextInt(); // 거슬러 줄 금액
        DFS(0,0);
        System.out.println(result);

    }
}
