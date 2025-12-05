package programmers.lv2_호텔대실;

public class Main {
    public static void main(String[] args) {

        class Solution {
            public int solution(String[][] book_time) {
                int answer = 0;
                int MAX_TIME = 1440;
                int[] prefixSum = new int[1441];

                for(String[] time : book_time) {
                    int s = timeToInt(time[0]);
                    int e = timeToInt(time[1]);
                    e = Math.min(MAX_TIME,e+10);

                    prefixSum[s] += 1;
                    prefixSum[e] -= 1;
                }

                int sum = 0;

                for(int i = 0; i <= 1440; i++) {
                    sum += prefixSum[i];
                    answer = Math.max(sum,answer);
                }

                return answer;
            }

            private static int timeToInt(String s) {
                String[] tmp = s.split(":");
                return Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
            }
        }
    }
}
