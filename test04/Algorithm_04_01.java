package test04;

import java.util.HashMap;
import java.util.Scanner;

// ## 학급회장 (HashMap) ##
// * Point : getOrDefault(key, default값) -> 해당키의 값을 return, 만약 값이 없다면 default값을 넣어서 return.
public class Algorithm_04_01 {


    static void Solution(int n,char[] chArr){

    HashMap<Character,Integer> temp = new HashMap<Character,Integer>();


        // char배열의 값을 temp 해쉬맵에 key,value로 넣어준다.
        for (char x : chArr) {
            temp.put(x, temp.getOrDefault(x,0)+1);
        }

        // 해쉬맵 추가 옵션
        // temp.containsKey('A') -> 해당 키가 존재하는지 여부를 true,false로 확인가능.
        // temp.size() -> 키의 개수를 확인할 수 있다.
        // temp.remove('A') -> 해당 키를 삭제한다. -> 출력 시 삭제한 키 의 값을 return 해준다.

       // for문으로 temp 해쉬맵의 키를 하나씩 꺼내고 max값과 비교한다.
        int max = Integer.MIN_VALUE;
        char result = ' ';
        // 맵 객체를 탐색할 때는 keset()을 사용한다.
        for(char key : temp.keySet()){
            if(temp.get(key) > max){
                max = temp.get(key);
                result = key;
            }
        }

        System.out.println(result);






    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] chArr = str.toCharArray();
        Solution(n,chArr);

    }
}
