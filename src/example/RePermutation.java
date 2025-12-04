package example;

import java.util.ArrayList;
import java.util.List;

public class RePermutation {

    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = 5;
        int r = 3;
        permutation(n,r, new ArrayList<>());
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).length; j++) {
                System.out.print(list.get(i)[j] + " ");
            }
            System.out.println();
        }
    }

    private static void permutation(int n, int r, ArrayList<Integer> tmp) {
        if(tmp.size() == r) {
            int[] t = new int[r];
            for(int i = 0; i < r; i++) {
                t[i] = tmp.get(i);
            }
            list.add(t);
            return;
        }

        for(int i = 1; i <= n; i++) {
            tmp.add(i);
            permutation(n,r,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
