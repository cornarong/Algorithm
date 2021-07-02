import java.util.HashMap;
import java.util.Scanner;

// ## 매출액의 종류 (Hash, Sliding Window) ##

// * Time Limit Exceeded 이슈 발생
// String은 *불변성을 가지기 때문에 "변하지 않는 문자열"을 자주 읽어들이는 경우 String을 사용해 주시면 좋은 성능을 기대할 수 있습니다.
// 그러나 문자열 추가,수정,삭제 등의 연산이 빈번하게 발생하는 알고리즘에 String 클래스를 사용하면
// 힙 메모리(Heap)에 많은 임시 가비지(Garbage)가 생성되어 힙메모리가 부족으로 어플리케이션 성능에 치명적인 영향을 끼치게 됩니다.

// 이를 해결하기 *가변성을 가지는 StringBuffer / StringBuilder 클래스를 사용한다.
// 따라서 기존 String result -> StringBuffer result = new StringBuffer(); 으로 소스 수정.

public class Algorithm_04_03 {

    static void Solution(int n, int k, int[] arr){

        int lt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
//        String result = map.size()+" ";
        StringBuffer result = new StringBuffer(map.size()+" ");
        for (int rt = k; rt < n; rt++) {
            map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
            map.put(arr[lt],map.getOrDefault(arr[lt],1)-1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
//            result += map.size()+" ";
            result.append(map.size()+" ");
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
