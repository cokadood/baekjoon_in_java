package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1로 만들기 (실버3)
public class P1463 {

    public static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        dp = new Integer[X + 1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(X));

    }

    static int recur(int X) {
        if (dp[X] == null) {
            // 6으로 나누어지는 경우
            if (X % 6 == 0) {
                dp[X] = Math.min(recur(X - 1), Math.min(recur(X / 3), recur((X / 2)))) + 1;
            }

            // 3으로만 나누어지는 경우
            else if (X % 3 == 0) {
                dp[X] = Math.min(recur(X / 3), recur(X - 1)) + 1;
            }

            // 2로만 나누어지는 경우
            else if (X % 2 == 0) {
                dp[X] = Math.min(recur(X / 2), recur(X - 1)) + 1;
            }

            // 2 혹은 3으로 나누어지지 않는 경우
            else {
                dp[X] = recur(X - 1) + 1;
            }
        }
        return dp[X];
    }
}
