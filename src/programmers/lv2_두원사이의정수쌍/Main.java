package programmers.lv2_두원사이의정수쌍;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for(int i = 1; i <= r2; i++) {
            long maxY = (long)Math.floor(Math.sqrt((long)r2*r2 - (long)i*i));

            long minY = (long)Math.ceil(Math.sqrt((long)r1*r1 - (long)i*i));

            answer += maxY-minY+1;
        }
        return 4*answer;
    }
}