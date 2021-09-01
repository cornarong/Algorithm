package programmers2;

import java.util.ArrayList;
import java.util.HashMap;

// ## [2019 카카오 개발자 겨울 인턴십] 튜플 ##
// https://programmers.co.kr/learn/courses/30/lessons/64065
// https://cornarong.tistory.com/58 - 개인 블로그 정리

public class Solution64065 {

        public int[] solution(String s) {

            s = s.replace("{{","").replace("}}","");
            String[] arr = s.split("\\},\\{");

            ArrayList<String[]> list = new ArrayList<>();

            for(String x : arr) {
                String[] temp = x.split(",");
                list.add(temp);
            }

            int[] answer = new int[list.size()];

            HashMap<String,Integer> hash = new HashMap<>();

            for(int i=0; i<list.size(); i++){
                for(int j=0; j<list.size(); j++){
                    if(list.get(j).length == i+1){
                        for(int k=0; k<list.get(j).length; k++){
                            if(hash.get(list.get(j)[k]) == null){
                                hash.put(list.get(j)[k],1);
                                answer[i] = Integer.parseInt(list.get(j)[k]);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            return answer;
        }

    public static void main(String[] args) {
        Solution64065 T = new Solution64065();
        // 예시 입력 1번 / result = "{2, 1, 3, 4}";
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        // 예시 입력 5번 / result = "{111, 20}";
//        String s = "{{20,111},{111}}";
        T.solution(s);


    }

}
