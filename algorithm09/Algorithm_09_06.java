package algorithm09;

import java.util.Scanner;

// ## 친구인가? (Disjoint-set : Union & Find) ##
public class Algorithm_09_06 {
    static int n; // 학생 수
    static int m; // 숫자쌍의 개수
    static int[] unf; // Union&Find배열

    static int Find(int v){
        if(v == unf[v]){ //
            return unf[v];
        }else {
            return unf[v] = Find(unf[v]); // 재귀함수를 호출하여 재귀끝에 return값을 기준으로 같은 집합이 되게 만들어주는 작업.
        }
    }
    static void Union(int a, int b){ // 전달받은 값이 같은 집합이 되게 만들어 주기 위한 함수.
        int fa = Find(a); // * Union함수에 들어온 매개변수는 바로 Find로 찾는다. -> unf배열의 완성을 위한 작업.
        int fb = Find(b); // * Union함수에 들어온 매개변수는 바로 Find로 찾는다. -> unf배열의 완성을 위한 작업.
        if(fa != fb) unf[fa] = unf[fb]; // return받은 값이 같지 않으면 같은 집합이 되게 만들어 주는 작업.
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        unf = new int[n+1];
        for (int i = 0; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a, b); // * Union함수로 unf배열을 완성을 만들어준다.
        }
        // 정답 확인.
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa==fb) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
