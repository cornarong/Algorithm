package programmers2;

// ## [해시] 전화번호 목록 ##
// https://programmers.co.kr/learn/courses/30/lessons/42577
import java.util.HashMap;

public class Solution42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String,Integer> hash = new HashMap<>();
        for(int i=0; i < phone_book.length; i++){
            hash.put(phone_book[i], 1);
        }
        for(int i=0; i < phone_book.length; i++){
            char[] arr = phone_book[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int j=0; j < arr.length-1; j++){
                sb.append(arr[j]);
                if(hash.get(sb.toString()) != null){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution42577 s = new Solution42577();
        // 예시 입출력 / return = false;
        String[] phone_book = {"119", "97674223", "1195524421"};
        s.solution(phone_book);

    }
}
