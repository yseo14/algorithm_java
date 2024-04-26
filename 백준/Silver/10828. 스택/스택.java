
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stk = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int data = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch(s){
                case "push":
                    data = Integer.parseInt(st.nextToken());
                    stk.push(data);
                    break;
                case "pop":
                    if(stk.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(stk.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stk.size()).append("\n");
                    break;
                case "empty":
                    if(stk.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "top":
                    if(stk.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(stk.peek()).append("\n");
                    break;

            }
        }
        System.out.println(sb);
        
    }
}