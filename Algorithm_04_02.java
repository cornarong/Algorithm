import java.util.HashMap;
import java.util.Scanner;

// ## 아나그램 (HashMap) ##
public class Algorithm_04_02 {

    static void Solution(String s1, String s2){

        String result = "YES";

        HashMap<Character,Integer> map = new HashMap<>();
        // 새로 만든 HashMap에 s1을 key,value로 넣는다.
        for(char x : s1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        // s2를 s1의 값이 담긴 map과 비교하면서 같으면 -1으로 value를 하나 씩 빼준다.
        for(char x: s2.toCharArray()){
            // s2의 배열의 값이 map의 key에 존재하지 않거나(||) 해당 존재는 하되 key의 value가 0인지 확인한다.
            if(!map.containsKey(x) || map.get(x) == 0) {
                result = "NO";
                break; // 배열의 값이 음수이면 예외처리 발생. 아래 로직 -1로 배열의 값을 음수로 만들기 전에 break;로 빠져 나온다.
            }
            map.put(x, map.get(x)-1);
        }

        System.out.println(result);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        Solution(str1,str2);

    }
}
