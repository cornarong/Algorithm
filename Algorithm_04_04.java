import java.util.HashMap;
import java.util.Scanner;

// ## 매출액의 종류 (Hash, Sliding Window) ##
public class Algorithm_04_04 {

    static void Solution(int n, int k, int[] arr){

        int lt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        String result = map.size()+" ";
        for (int rt = k; rt < n; rt++) {
            map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
            map.put(arr[lt],map.getOrDefault(arr[lt],1)-1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            result += map.size()+" ";
            lt++;
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
