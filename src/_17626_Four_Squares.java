import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17626_Four_Squares {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        System.out.println(find_min_cnt(num));
    }

    static int find_min_cnt(int num) {
        int min_cnt = 4;
        int di, dj, dk;
        for (int i = (int) Math.sqrt(num); i > 0; i--) {
            di = num - i * i;
            if (di == 0) {
                min_cnt = 1;
            }
            for (int j = (int) Math.sqrt(di); j > 0; j--) {
                dj = di - j * j;
                if (dj == 0) {
                    min_cnt = Math.min(min_cnt, 2);
                }
                for (int k = (int) Math.sqrt(dj); k > 0; k--) {
                    dk = dj - k * k;
                    if (dk == 0) {
                        min_cnt = Math.min(min_cnt, 3);
                    }
                }
            }
        }

        return min_cnt;
    }
}
