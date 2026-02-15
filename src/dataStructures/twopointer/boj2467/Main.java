package dataStructures.twopointer.boj2467;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = N-1;
        int min = Integer.MAX_VALUE;
        int al = 0;
        int ar = N-1;

        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum > 0) {
                if(sum < min) {
                    al = left;
                    ar = right;
                    min = sum;
                }
                right--;
            }
            else if(sum < 0) {
                if(-sum < min) {
                    al = left;
                    ar = right;
                    min = -sum;
                }
                left++;
            }
            else {
                al = left;
                ar = right;
                break;
            }
        }

        System.out.println(arr[al] + " " + arr[ar]);
    }
}
