package programmers.lv2_광물캐기;

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int totalPicks = picks[0] + picks[1] + picks[2];

        int maxMinerals = Math.min(totalPicks*5,minerals.length);

        int gCnt = (maxMinerals+4) / 5;

        List<Group> group = new ArrayList<>();

        for(int i = 0; i < gCnt; i++) {
            group.add(new Group(0,0,0));
        }

        for(int i = 0; i < maxMinerals; i++) {
            if(minerals[i].equals("diamond")) {
                group.get(i/5).dCnt++;
            }
            else if(minerals[i].equals("iron")) {
                group.get(i/5).iCnt++;
            }
            else {
                group.get(i/5).sCnt++;
            }
        }

        Collections.sort(group);

        for(int i = 0; i < gCnt; i++) {
            Group now = group.get(i);
            if(picks[0] > 0) {
                answer += now.dCnt + now.iCnt + now.sCnt;
                picks[0]--;
            }
            else if(picks[1] > 0) {
                answer += now.dCnt*5 + now.iCnt + now.sCnt;
                picks[1]--;
            }
            else if(picks[2] > 0) {
                answer += now.dCnt*25 + now.iCnt*5 + now.sCnt;
                picks[2]--;
            }
        }

        return answer;
    }

    private static class Group implements Comparable<Group> {
        int dCnt;
        int iCnt;
        int sCnt;

        public Group(int dCnt, int iCnt, int sCnt) {
            this.dCnt = dCnt;
            this.iCnt = iCnt;
            this.sCnt = sCnt;
        }

        @Override
        public int compareTo(Group o) {
            return o.dCnt*25 + o.iCnt*5 + o.sCnt - this.dCnt*25 - this.iCnt*5 - this.sCnt;
        }
    }
}
