package CodeTree;
import java.io.*;
import java.util.*;
/**
 * 블럭쌓기 명령
 * 다시풀기
 */
public class sol6 {

    static int n,k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr= new int[n+1];

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int Ai = Integer.parseInt(st.nextToken());
            int Bi = Integer.parseInt(st.nextToken());

            for(int j = Ai;j<=Bi;j++){
                arr[j-1]++;
            }


        }
        Arrays.sort(arr);
        int median = arr[n / 2];
        System.out.println(median);
    }
}
