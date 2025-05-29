import java.io.*;
import java.util.*;

public class Main {
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

            if (rooms.isEmpty()) {
                Room room = new Room(false, level - 10, level + 10);
                rooms.add(room);
                room.players.add(new Player(level, nickname));
                room.capacity++;
                if (room.capacity == m) {
                    room.isStarted = true;
                }
            } else {
                boolean createRoom = true;
                for (Room room : rooms) {
                    if (level >= room.min && level <= room.max && room.capacity < m) {
                        createRoom = false;
                        room.players.add(new Player(level, nickname));
                        room.capacity++;
                        if (room.capacity == m) {
                            room.isStarted = true;
                        }
                        break;
                    }
                }
                if (createRoom) {
                    Room room = new Room(false, level - 10, level + 10);
                    rooms.add(room);
                    room.players.add(new Player(level, nickname));
                    room.capacity++;
                    if (room.capacity == m) {
                        room.isStarted = true;
                    }
                }
            }
        }

        for (Room room : rooms) {
            if (room.isStarted) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }
            room.players.sort((p1, p2) -> p1.nickname.compareTo(p2.nickname));
            for (Player p : room.players) {
                sb.append(p.level).append(" ").append(p.nickname).append("\n");
            }
        }

        System.out.println(sb);
    }


    public static class Room {
        boolean isStarted;
        int min, max;
        ArrayList<Player> players;
        int capacity;

        public Room(boolean isStarted, int min, int max) {
            this.isStarted = isStarted;
            this.min = min;
            this.max = max;
            this.players = new ArrayList<>();
            this.capacity = 0;
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
