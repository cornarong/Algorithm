package algorithm08;

import java.util.Scanner;

// ## 바둑이 승차(DFS) ##
// 재귀함수 사용. 이진트리 레벨 순회.
public class Algorithm_08_02 {

    static int c; // 최대 허용 킬로그램
    static int n; // 바둑이 마릿수
    static int[] arr; // 바둑이들의 무게 배열
    static int result = 0; // 출력할 결과 값

    static void DFS(int level,int sum){

        // 현재 DFS함수 까지의 바둑이들의 누적 무게(sum)이 최대 허용(c)보다 크면 더 이상 아래로 뻗어 나갈 필요 없이 리턴.
        if(sum > c) return;
        // c보다 같거나 작은 sum을 가지고 마지막 레벨에 도착 후 조건 태운다.
        if(level == n){
            if(result < sum){ // 현재의 결과 값보다 크면 담는다.
                result = sum;
                return;
            }
        }else{
            DFS(level+1,sum+arr[level]);
            DFS(level+1,sum);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0,0);
        System.out.println(result);
    }
}
