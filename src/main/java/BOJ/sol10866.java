package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class sol10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int data = 0;
        Deque<Integer> d = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch(s){
                case "push_front":
                    data = Integer.parseInt(st.nextToken());
                    d.addFirst(data);
                    break;
                case "push_back":
                    data = Integer.parseInt(st.nextToken());
                    d.addLast(data);
                    break;
                case "pop_front":
                    if(d.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(d.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if(d.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(d.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(d.size()).append("\n");
                    break;
                case "empty":
                    if(d.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(d.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(d.peekFirst()).append("\n");
                    break;
                case "back":
                    if(d.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(d.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);

    }
}
