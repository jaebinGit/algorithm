package dataStructures.stack.backjoon_10799;

import java.util.Stack;

public class Backjoon_10799 {
    public static class Solution {
        /**
         * 문제 설명:
         * 여러 개의 쇠막대기를 레이저로 절단하려고 합니다.
         * - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓을 수 있습니다.
         * - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않습니다.
         * - 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 `( )` 으로 표현됩니다.
         * - 쇠막대기의 왼쪽 끝은 여는 괄호 `(`, 오른쪽 끝은 닫는 괄호 `)` 로 표현됩니다.
         *
         * 입력:
         * - String arrangement: 괄호로 이루어진 문자열.
         *
         * 출력:
         * - 잘려진 쇠막대기 조각의 총 개수를 나타내는 정수.
         *
         * 제한 조건:
         * - 입력 문자열의 길이는 1 이상 100,000 이하입니다.
         * - 문자열은 반드시 유효한 괄호 표현입니다.
         *
         * 예시 1:
         * String arrangement = "()(((()())(())()))(())";
         * System.out.println(solution(arrangement)); // 출력: 17
         *
         * 예시 2:
         * String arrangement = "(((()(()()))(())()))(()())";
         * System.out.println(solution(arrangement)); // 출력: 24
         */
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

        // 메인 메서드 예시 (테스트용)
        public static void main(String[] args) {
            Solution solution = new Solution();

            // 테스트 케이스 1
            String arrangement1 = "()(((()())(())()))(())";
            System.out.println(solution.solution(arrangement1)); // 예상 출력: 17

            // 테스트 케이스 2
            String arrangement2 = "(((()(()()))(())()))(()())";
            System.out.println(solution.solution(arrangement2)); // 예상 출력: 24
        }
    }
}
