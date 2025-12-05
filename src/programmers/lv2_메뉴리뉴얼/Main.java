package programmers.lv2_메뉴리뉴얼;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        class Solution {

            private static HashMap<String,Integer> map;

            public String[] solution(String[] orders, int[] course) {
                List<String> result = new ArrayList<>();

                for(int k : course) {
                    map = new HashMap<>();
                    for(String order : orders) {
                        char[] tmp = order.toCharArray();
                        Arrays.sort(tmp);
                        StringBuilder sb2 = new StringBuilder();
                        for(char c : tmp) {
                            sb2.append(c);
                        }
                        combination(0,sb2.toString(),k,new ArrayList<>());
                    }

                    int max = 2;
                    for(String key : map.keySet()) {
                        max = Math.max(map.get(key),max);
                    }

                    for(String key : map.keySet()) {
                        if(map.get(key) == max) result.add(key);
                    }

                }

                Collections.sort(result,(a,b) -> a.compareTo(b));
                String[] answer = new String[result.size()];
                for(int i = 0; i < answer.length; i++) {
                    answer[i] = result.get(i);
                }
                return answer;
            }

            private static void combination(int now, String order, int r, ArrayList<Character> list) {
                if(list.size() == r) {
                    StringBuilder sb = new StringBuilder();
                    for(char c : list) {
                        sb.append(c);
                    }
                    String s = sb.toString();
                    map.put(s,map.getOrDefault(s,0)+1);
                    return;
                }

                for(int i = now; i < order.length(); i++) {
                    list.add(order.charAt(i));
                    combination(i+1,order,r,list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
