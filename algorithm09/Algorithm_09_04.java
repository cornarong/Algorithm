package algorithm09;

import java.util.*;

// ## 최대 수입 스케쥴(PriorityQueue 응용문제) ##
// https://cornarong.tistory.com/24
class Algorithm_09_04 {

    static class Company implements Comparable<Company>{
        public int pay;
        public int day;
        Company(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
        @Override
        public int compareTo(Company ob){
            return ob.day - this.day;
        }
    }

    static int n;
    static int max = Integer.MIN_VALUE; // D의 최댓값을 담을 변수
    static int result = 0;

    static void solution(ArrayList<Company> arr){
        // PriorityQueue의 default는 오름차순으로
        // Collections.reverseOrder()사용하여 내림차순으로 정렬하도록 한다.
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        // Comparable인터페이스의 compareTo를 사용하여
        // Company객체를 담고 있는 list를 인스턴스변수 D를 기준으로 내림차순 정렬한다.
        Collections.sort(arr);
        int j=0; // for문의 초기값 j를 외부 선언.
        for(int i=max; i>=1; i--){ // D의 가장 큰값을 담은 max변수부터 시작하여 1까지 반복한다.
            // 초기값을 외부에 선언하여 중간에 나갔다 다시들어와도 이어서 진행하도록 한다.
            for( ; j<n; j++){
                if(arr.get(j).day<i) { // D값이 다르면 break로 나간다.
                    break;
                }else{ // D값이 같으면 PriorityQueue에 담는다.
                    pQ.offer(arr.get(j).pay);
                }
            }
            // 내림차순으로 정렬된 PriorityQueue에서 값(가장 큰 값)을 꺼내 결과를 result에 누적한다.
            if(!pQ.isEmpty()) result += pQ.poll();
        }
    }

    public static void main(String[] args){
        Algorithm_09_04 T = new Algorithm_09_04();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        ArrayList<Company> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 입력받은 값을 객체화 하여 arr에 담는다.
            arr.add(new Company(a, b));
            if(b > max) max = b;
        }
        solution(arr);
        System.out.println(result);
    }
}