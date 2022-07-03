import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9465_스티커 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] stickers = new int[2][n];
            int[][] memo = new int[2][n];

            for (int ri = 0; ri < 2; ri++) {
                st = new StringTokenizer(br.readLine());
                for (int ci = 0; ci < n; ci++) {
                    stickers[ri][ci] = Integer.parseInt(st.nextToken());
                }
            }

            memo[0][0] = stickers[0][0];
            memo[1][0] = stickers[1][0];

            if (n > 1) {
                memo[0][1] = stickers[1][0] + stickers[0][1];
                memo[1][1] = stickers[0][0] + stickers[1][1];

                for (int ci = 2; ci < n; ci++) {
                    memo[0][ci] = stickers[0][ci] + Math.max(memo[1][ci-1], memo[1][ci-2]);
                    memo[1][ci] = stickers[1][ci] + Math.max(memo[0][ci-1], memo[0][ci-2]);
                }
            }

            System.out.println(Math.max(memo[0][n - 1], memo[1][n - 1]));
        }
    }
}
