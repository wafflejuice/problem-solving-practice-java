import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6064_카잉_달력 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int answer = -1;
            int year = x;
            int[] cain = new int[2];

            while (year <= m * n) {
                toCain(year, m, n, cain);

                if (cain[0] == x && cain[1] == y) {
                    answer = year;
                    break;
                }

                year += m;
            }

            System.out.println(answer);
        }
    }

    static boolean toCain(int year, int m, int n, int[] cain) {
        int x = year % m;
        if (x == 0) {
            x = m;
        }

        int y = year % n;
        if (y == 0) {
            y = n;
        }

        cain[0] = x;
        cain[1] = y;

        return true;
    }
}
