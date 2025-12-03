package programmers.lv2_요격시스템;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        System.out.println(solution.solution(targets));
    }

    private static class Solution {
        public int solution(int[][] targets) {
            int answer = 0;

            Arrays.sort(targets,(a, b) -> a[1] - b[1]);
            int lastShot = -1;
            for(int[] target : targets) {
                int start = target[0];
                int end = target[1];

                if(start >= lastShot) {
                    answer++;
                    lastShot = end;
                }
            }

            return answer;
        }
    }
}
