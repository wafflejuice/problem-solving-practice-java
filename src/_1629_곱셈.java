import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1629_곱셈 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, a % c);

        System.out.println(calc(a, b, c, memo));
    }

    static int calc(int a, int b, int c, Map<Integer, Integer> memo) {
        if (memo.containsKey(b)) {
            return memo.get(b);
        }

        int halfMul = calc(a, b/2, c, memo);
        memo.put(b/2, halfMul);

        long rtn = ((long) halfMul * halfMul) % c;
        if (b % 2 == 1) {
            rtn *= calc(a, 1, c, memo);
        }

        return (int) (rtn % c);
    }
}
