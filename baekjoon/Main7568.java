package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

// ## 덩치 (구현, 브루트포스 알고리즘) ##
// https://www.acmicpc.net/problem/7568

public class Main7568 {

    class Person{
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) {

        Main7568 T = new Main7568();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> people = new ArrayList<>();

        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            people.add(T.new Person(a, b));
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if(i==j) continue;
                if(people.get(i).weight < people.get(j).weight && people.get(i).height < people.get(j).height){
                    cnt++;
                }
            }
            System.out.printf(cnt+" ");
        }
    }
}
