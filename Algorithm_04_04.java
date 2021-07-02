import java.util.HashMap;
import java.util.Scanner;

// ## 모든 아나그램 찾기 ##
// * Point : 객체1.equals(객체2) -> map의 Key 와 Value도 비교해줌. (문자열만이 아닌 객체 비교도 가능)

// S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
// 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
// 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
// S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
// S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

// 예시 입력 1
// bacaAacba
// abc

// 예시 출력 1
// 3

public class Algorithm_04_04 {

    static void Solution(String S, String T){

        // 비교를 위하여 T값을 map2에 전부 담아준다.
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (char x : T.toCharArray()) map2.put(x,map2.getOrDefault(x,0)+1);

        // Sliding Window 방식을 사용하기 위하여 T-1 길이 만큼 map에 담아준다.
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < T.length()-1; i++) map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);

        // rt가 증가함에 따라 lt가 따라오는 구조. Sliding Window 방식
        int lt = 0;
        int result = 0;
        for (int rt = T.length()-1; rt < S.length(); rt++) { // rt 증가
            // map에 rt의 값 추가 , 있을 경우 갯수 +1
            map.put(S.charAt(rt),map.getOrDefault(S.charAt(rt),0)+1);
            // map과 mpa2 비교 (아나그램 확인)
            if(map.equals(map2)) result++;
            // map에 lt의 무조건 있으니 -1
            map.put(S.charAt(lt),map.get(S.charAt(lt))-1);
            // map의 해당lt의 값이 0일 경우 삭제.
            if(map.get(S.charAt(lt)) == 0) map.remove(S.charAt(lt));
            // lt 증가
            lt++;
        }
        System.out.println(result);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        Solution(S, T);

    }
}
