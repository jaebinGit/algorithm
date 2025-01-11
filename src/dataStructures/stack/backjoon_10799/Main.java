package dataStructures.stack.backjoon_10799;

import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String arrangement = br.readLine();

        Solution solution = new Solution();
        System.out.println(solution.solution(arrangement));

    }
    public static class Solution {
        public int solution(String arrangement) {
            int answer = 0;

            Stack<Character> stack = new Stack<>();
            char lastChar = '0';
            for(int i = 0; i < arrangement.length(); i++){
                char currentChar = arrangement.charAt(i);
                if(currentChar == '('){
                    stack.push(currentChar);
                }
                else if(currentChar == ')'){
                    if(lastChar == '('){
                        stack.pop();
                        answer += stack.size();
                    }
                    else if(lastChar == ')'){
                        answer += 1;
                        stack.pop();
                    }
                }
                lastChar = currentChar;
            }

            return answer;
        }
    }
}