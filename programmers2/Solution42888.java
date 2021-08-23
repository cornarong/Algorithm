package programmers2;

import java.util.ArrayList;
import java.util.HashMap;

// ## [2019 KAKAO BLIND RECRUITMENT] 오픈채팅방 ##
// https://programmers.co.kr/learn/courses/30/lessons/42888
// https://cornarong.tistory.com/53 - 블로그 정리

public class Solution42888 {

    private class User{
        String userPattern;
        String userId;
        String userName;
        public User(String userPattern, String userId, String userName){
            this.userPattern = userPattern;
            this.userId = userId;
            this.userName = userName;
        }
    }
    public String[] solution(String[] record) {
        ArrayList<User> userList = new ArrayList<>();
        HashMap<String,String> idAndName = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] tempArr = record[i].split(" ");
            String pattern = tempArr[0];
            String id = tempArr[1];
            String name = "";
            if(pattern.equals("Leave")){
                name = idAndName.get(id);
            }else{
                name = tempArr[2];
            }
            idAndName.put(id,name); // key, value 최신값 갱신
            if(!pattern.equals("Change")) userList.add(new User(pattern, id, name));
        }

        // Change, Enter 처리
        for (int i = userList.size()-1; i >= 0; i--) {
            String name = idAndName.get(userList.get(i).userId);
            userList.get(i).userName = name;
        }

        String[] answer = new String[userList.size()];
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if(user.userPattern.equals("Enter")){
                answer[i] = user.userName+"님이 들어왔습니다.";
            }else if(user.userPattern.equals("Leave")){
                answer[i] = user.userName+"님이 나갔습니다.";
            }
        }
//        for(String x : answer) System.out.println(x);
        return answer;
    }
    public static void main(String[] args) {
        // 예시 입력 / 출력 result = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."}
        String[] record = {"Enter uid1234 Muzi","Change uid1234 chan","Leave uid1234"};
        Solution42888 s = new Solution42888();
        s.solution(record);


    }
}
