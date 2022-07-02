import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _1010_다리_놓기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            BigInteger ans = new BigInteger("1");
            for (int ni = 0; ni < n; ni++) {
                ans = ans.multiply(BigInteger.valueOf(m -ni));
            }
            for (int ni = 0; ni < n; ni++) {
                ans = ans.divide(BigInteger.valueOf(ni + 1));
            }

            System.out.println(ans);
        }
    }
}
