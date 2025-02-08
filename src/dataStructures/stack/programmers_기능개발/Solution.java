package dataStructures.stack.programmers_기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int day = 0;
            while(progresses[i] < 100){
                progresses[i] += speeds[i];
                day++;
            }
            queue.add(day);
        }
        int i = 0;
        while(!queue.isEmpty()){
            i++;
            int cnt = 0;
            int tmp = queue.remove();
            cnt++;
            while(!queue.isEmpty() && queue.peek() <= tmp){
                queue.remove();
                cnt++;
            }
            answerList.add(cnt);
        }
        int size = answerList.size();
        int[] answer = new int[size];
        for(int j = 0; j < size; j++){
            answer[j] = answerList.get(j);
        }

        return answer;
    }
}