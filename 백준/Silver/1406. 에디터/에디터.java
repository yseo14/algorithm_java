
import java.io.*;
import java.util.*;

public class Main {
    static String init;
    static int M;
    static LinkedList<Character> list;
    static int cursor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init = br.readLine();
        list = new LinkedList<>();
        for (int i = 0; i < init.length(); i++) {
            list.add(init.charAt(i));
        }
        ListIterator<Character> iter = list.listIterator(list.size()); //iter를 제일 뒤로 옮겨준다.(커서는 초기에 가장 우측에 위차하므로)
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            switch (c) {
                case 'L':
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char add = command.charAt(2);
                    iter.add(add);
                    break;

                default:
                    break;
            }
        }
        for (Character c : list) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }
}