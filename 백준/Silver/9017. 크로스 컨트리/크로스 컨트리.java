import java.io.*;
import java.util.*;

public class Main {
    static int t, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t > 0) {
            n = Integer.parseInt(br.readLine());
            int[] records = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            //  점수 기록 및 팀 수 카운트
            int lastTeamId = 0;
            for (int i = 1; i <= n; i++) {
                records[i] = Integer.parseInt(st.nextToken());
                lastTeamId = Math.max(lastTeamId, records[i]);
            }

            //  팀당 선수 수 카운트
            Team[] teams = new Team[lastTeamId];
            for (int i = 0; i < lastTeamId; i++) {
                teams[i] = new Team(i + 1);
            }
            for (int i = 1; i < n + 1; i++) {
                teams[records[i] - 1].playerCnt += 1;
            }

            //  제외할 팀 선정
            List<Integer> exceptTeams = new ArrayList<>();
            for (int i = 0; i < lastTeamId; i++) {
                if (teams[i].playerCnt < 6) {
                    exceptTeams.add(teams[i].num);
                }
            }

            for (int i = 0; i < lastTeamId; i++) {
                teams[i] = new Team(i + 1);
            }
            int exceptCnt = 0;
            for (int i = 1; i < n + 1; i++) {
                if (exceptTeams.contains(records[i])) {
                    exceptCnt += 1;
                    teams[records[i] - 1].score = Integer.MAX_VALUE;
                } else {
                    int playerScore = i - exceptCnt;
                    teams[records[i] - 1].playerCnt += 1;
                    if (teams[records[i] - 1].playerCnt == 5) {
                        teams[records[i] - 1].fifth = playerScore;
                    }
                    if (teams[records[i] - 1].playerCnt <= 4) {
                        teams[records[i] - 1].score += playerScore;
                    }

                }
            }
            Arrays.sort(teams);
            System.out.println(teams[0].num);
            t--;
        }
    }

    public static class Team implements Comparable<Team> {
        int num;
        int score;
        int fifth;
        int playerCnt;

        Team(int num) {
            this.num = num;
            this.score = 0;
            this.fifth = 0;
            this.playerCnt = 0;
        }

        @Override
        public int compareTo(Team team) {
            if (this.score == team.score) {
                return Integer.compare(this.fifth, team.fifth);
            } else {
                return Integer.compare(this.score, team.score);
            }
        }
    }
}
