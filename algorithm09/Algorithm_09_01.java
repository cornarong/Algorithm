package algorithm09;

import java.util.ArrayList;
import java.util.Scanner;

// ## 씨름 선수 ##
public class Algorithm_09_01 {

    static class Person{
        int height;
        int weight;
        public Person(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }

    static int n;
    static ArrayList<Person> person = new ArrayList<>();
    static int result = 0;

    static void Solution(ArrayList<Person> person){

        for (int i = 0; i < n; i++) {
            boolean falg = false;
            for (int j = 0; j < n; j++) {
                if (person.get(i).height < person.get(j).height && person.get(i).weight < person.get(j).weight) {
                    falg = true;
                }
            }
            if(falg == false) result++;
        }
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            person.add(new Person(a, b));
        }
        Solution(person);
        System.out.println(result);
    }
}
