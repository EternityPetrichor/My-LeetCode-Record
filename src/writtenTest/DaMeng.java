package writtenTest;

import java.util.Scanner;

public class DaMeng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));

    }

    public static int solution(int n){
        if(n==0 || n==1){
            return 1;
        } else if (n == 2 || n == 3) {
            return 3;
        } else {
            return solution(n-1) + solution(n-3);
        }
    }
}
