package algorithm06;

import java.util.Arrays;
import java.util.Scanner;

// ## 뮤직비디오(결정 알고리즘) ##
public class Algorithm_06_09 {

    static int count(int[] arr, int mid){
        int sum = 0, cnt = 1; // cnt=1 즉 DVD는 1개부터 시작한다.
        for(int x : arr){
            // x라는 용량을 누적할 경우 mid보다 큰지 비교.
            // 만약 크면 sum에 누적 하지 않고 x값을 초기값을 설정하고 cnt(DVD)를 1++ 후 다음 cnt(DVD)에 누적!
            // 만약 작거나 같으면 누적한다. -> 선 비교 후 누적.
            if(sum+x > mid) { // mid는 용량이다.
                cnt ++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }

    static void Solution(int n , int m, int[] arr){

        // 이분탐색 사용

        // left, right 구하는 방법.
        // 만약 입력값이 1 2 3 4 5 6 7 8 9 일 경우 -> 최소값은 9 ~ 최대값은 45(다 더한 값)이 된다.
        // 만약 하나당 한개의 DVD에 담을경우 최소 9는 되어야 마지막 값까지 포함 하여 전부 담긴다.
        // 만약 전부 한개의 DVD에 담을경우 최소 다 더한 값 = 45 는 되어야 한다.

        int lt = Arrays.stream(arr).max().getAsInt();   // 최소값
        int rt = Arrays.stream(arr).sum();  // 최대값
        int result = 0;
        while(lt <= rt){
            int mid = (lt+rt)/2; // *mid == DVD용량
            int cnt = count(arr, mid);
            if(count(arr, mid) <= m){
                // 용량이 더 크거나 같다. -> 만약에 cnt < m 라면 이말은 즉 용량이 더 크다 -> DVD를 2개로 만들 수 있찌만 3개로도 만들 수 있다(넉넉~히).
                // 그말은 즉 3개로 만들 수 있는 용량이니 우선 result에 담는다. -> 더 최고의 조건을 찾아 나선다.
                result = mid;
                rt = mid-1;
            }else if(cnt > m){ // 용량이 더 작다. -> 3개로 못 만든다. 불가능하다(용량부족) -> 더 최고의 조건을 찾아 나선다.
                lt = mid+1;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution(n, m, arr);
    }
}
