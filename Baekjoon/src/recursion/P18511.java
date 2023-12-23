package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 큰 수 구성하기 (실버5)
public class P18511 {

    private static int[] num;
    private static int N;
    private static int K;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[K];
        for (int i = 0; i < K; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        DFS(0);
        System.out.println(answer);

    }

    public static void DFS(int now) {
        if (now > N) return;

        if (answer < now) answer = now;

        for (int i = K - 1; i > -1 ; i--) {
            DFS(now * 10 + num[i]);
        }
    }

}
