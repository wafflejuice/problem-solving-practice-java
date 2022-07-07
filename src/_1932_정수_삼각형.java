import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1932_정수_삼각형 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] memo = new int[n][n];

        st = new StringTokenizer(br.readLine());
        memo[0][0] = Integer.parseInt(st.nextToken());

        for (int ri = 1; ri < n; ri++) {
            st = new StringTokenizer(br.readLine());
            for (int ci = 0; ci <= ri; ci++) {
                int prevMaxSum = memo[ri - 1][ci];
                if (0 < ci) {
                    prevMaxSum = Math.max(prevMaxSum, memo[ri - 1][ci - 1]);
                }

                memo[ri][ci] = prevMaxSum + Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Arrays.stream(memo[n-1]).max().getAsInt());
    }
}
