import java.util.*;

public class Main {

    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        // Please write your code here.

        permutation(0,k,n);
    }

    private static void permutation(int now, int k, int n) {
        
        if(now == n) {
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= k; i++) {
            list.add(i);
            permutation(now+1,k,n);
            list.remove(list.size()-1);
        }
        
    }
}