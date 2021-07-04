package algorithm05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ## 응급실 ##

public class Algorithm_05_08 {

    static class Person {
        int id;
        int priority;

        public Person(int num, int score) {
            this.id = num;
            this.priority = score;
        }
    }

    static void Solution(int n, int m, int[] patient){

        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            Q.offer(new Person(i,patient[i]));
        }

        while (!Q.isEmpty()){
            Person temp = Q.poll();
            for(Person x : Q){
                if(x.priority>temp.priority){
                    Q.offer(temp);
                    temp = null;
                    break;
                }
            }
            if(temp!=null){
                answer++;
                if(temp.id==m){
                    System.out.println(answer);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] patient = new int[n];
        for (int i = 0; i < n; i++) {
            patient[i] = sc.nextInt();
        }
        Solution(n, m, patient);
    }
}

