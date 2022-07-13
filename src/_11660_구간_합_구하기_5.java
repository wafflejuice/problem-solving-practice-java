import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11660_구간_합_구하기_5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] acc = new int[n + 1][n + 1];

        for (int ri = 1; ri <= n; ri++) {
            st = new StringTokenizer(br.readLine());
            for (int ci = 1; ci <= n; ci++) {
                acc[ri][ci] = acc[ri - 1][ci] + acc[ri][ci - 1] - acc[ri - 1][ci - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int x1, y1, x2, y2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            System.out.println(acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1]);
        }
    }
}
