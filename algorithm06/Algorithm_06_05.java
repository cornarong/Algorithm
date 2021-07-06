package algorithm06;

import java.util.Scanner;
import java.util.Stack;

// ## 중복 확인 ##
// 1번 Stack사용
// 2번 HashMap사용
// 3번 배열사용

public class Algorithm_06_05 {

    static void Solution(int n, int[] arr){

        // Stack의 contains이용
        String result = "U";
        Stack<Integer> stack = new Stack<>();
        for(int x : arr){
            if(stack.contains(x)) {
                result="D";
                break;
            }else{
                stack.push(x);
            }
        }
        System.out.println(result);


/*
        // 배열의 sort이용
        String result = "U";
        Arrays.sort(arr);
        for (int i = 0; i < n-1; i++) {
            if(arr[i] == arr[i+1]) {
                result = "D";
                break;
            }
        }
        System.out.println(result);*/

/*
        // HashMap이용
        String result = "U";
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : arr){
            map.put(x,map.getOrDefault(x,0)+1);
            if(map.get(x) > 1) result = "D";
        }
        System.out.println(result);
*/

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution(n, arr);
    }

}
