package algorithm06;

import java.util.Arrays;
import java.util.Scanner;


// ## 마구간 구하기 (결정 알고리즘) ##
public class Algorithm_06_10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // x1, x2, x3, x4 - 마구간 중복x 1마리씩 최대한 두말거리가 "최대"로 멀게
        // 1 2 4 8 9 - 가지고있는 마구간 좌표
        // 1 ~ 9를 2분 탐색으로 진행 -> mid값을 최대거리로 잡고 -> 리턴값 cnt를 구해서 ++면 말마리수랑 비교해서 크거나 같으면 통과.
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 이분검색 위한 정렬
        int result = 0; // 결과
        int lt = 1; // 거리 최소
        int rt = Arrays.stream(arr).max().getAsInt(); // 거리 최대

        while (lt <= rt){
            int mid = (lt+rt)/2;
            int cnt = 1; // 마구간에 들어간 말의 수
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    if(arr[j] - arr[i] >= mid){
                        cnt++;
                        i = j-1;
                        break;
                    }
                }
            }
            if(cnt < c) rt = mid-1;
            else if(cnt >= c) {
                result = mid;
                lt = mid+1;
            }
        }
        System.out.println(result);
    }
}
