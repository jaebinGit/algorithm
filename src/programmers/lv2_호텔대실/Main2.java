package programmers.lv2_호텔대실;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        class Solution {
            public int solution(String[][] book_time) {

                int[][] time = new int[book_time.length][2];
                int idx = 0;
                for(String[] t : book_time) {
                    time[idx][0] = timeToInt(t[0]);
                    time[idx][1] = timeToInt(t[1]);
                    idx++;
                }

                PriorityQueue<Integer> pq = new PriorityQueue<>();
                Arrays.sort(time,(a,b) -> {
                    if(a[0] != b[0]) return a[0]-b[0];
                    return a[1]-b[1];
                });

                for(int i = 0; i < time.length; i++) {
                    if(!pq.isEmpty()) {
                        if(time[i][0] >= pq.peek()) {
                            pq.poll();
                        }
                    }

                    pq.offer(time[i][1]+10);
                }

                return pq.size();
            }

            private static int timeToInt(String s) {
                String[] tmp = s.split(":");
                return Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
            }
        }
    }
}
