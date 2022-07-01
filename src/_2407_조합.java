import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2407_조합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[][] memo = new BigInteger[101][101];
        memo[0][0] = new BigInteger("1");
        for (int ri = 1; ri <= n; ri++) {
            memo[ri][0] = new BigInteger("1");
            memo[ri][ri] = new BigInteger("1");
            for (int ci = 1; ci < ri; ci++) {
                memo[ri][ci] = memo[ri - 1][ci - 1].add(memo[ri - 1][ci]);
            }
        }

        System.out.println(memo[n][m]);
    }
}
