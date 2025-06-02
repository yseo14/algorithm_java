package BOJ;

import java.io.*;
import java.util.*;

public class sol20006 {
    static int p, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            Player newPlayer = new Player(level, nickname);

            boolean addedToRoom = false;
            for (Room room : rooms) {
                if (room.canEnter(level)) {
                    room.addPlayer(newPlayer);
                    addedToRoom = true;
                    break;
                }
            }

            if (!addedToRoom) {
                Room newRoom = new Room(level - 10, level + 10);
                newRoom.addPlayer(newPlayer);
                rooms.add(newRoom);
            }
        }

        for (Room room : rooms) {
            sb.append(room.isStarted ? "Started!" : "Waiting!").append("\n");
            room.players.sort(Comparator.comparing(p -> p.nickname));
            for (Player p : room.players) {
                sb.append(p.level).append(" ").append(p.nickname).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static class Room {
        boolean isStarted = false;
        int min, max;
        ArrayList<Player> players = new ArrayList<>();
        int capacity = 0;

        public Room(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public boolean canEnter(int level) {
            return !isStarted && level >= min && level <= max && capacity < m;
        }

        public void addPlayer(Player player) {
            players.add(player);
            capacity++;
            if (capacity == m) {
                isStarted = true;
            }
        }
    }

    public static class Player {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }
}
