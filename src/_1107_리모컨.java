import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1107_리모컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int start = 100;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        boolean[] avail = new boolean[10];
        Arrays.fill(avail, true);

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                avail[Integer.parseInt(st.nextToken())] = false;
            }
        }

        if (m == 10) {
            System.out.println(Math.abs(n - start));
            return;
        }

        int min_move = Math.abs(n - start);
        int low_boundary = find_low_boundary(n, avail);
        int high_boundary = find_high_boundary(n, avail);

        if (low_boundary >= 0) {
            min_move = Math.min(min_move, digit(low_boundary) + n - low_boundary);
        }
        if (high_boundary >= 0) {
            min_move = Math.min(min_move, digit(high_boundary) + high_boundary - n);
        }

        System.out.println(min_move);
    }

    static int digit(int num) {
        if (num == 0) {
            return 1;
        }

        int cnt = 0;
        while (num > 0) {
            num /= 10;
            cnt++;
        }

        return cnt;
    }

    static boolean all_available(int num, boolean[] avail) {
        if (num == 0) {
            return avail[0];
        }

        while (num > 0) {
            if (!avail[num % 10]) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    static int find_low_boundary(int num, boolean[] avail) {
        while (num >= 0) {
            if (all_available(num, avail)) {
                return num;
            }
            num--;
        }

        return -1;
    }

    static int find_high_boundary(int num, boolean[] avail) {
        boolean is_impossible = true;
        for (int i = 1; i < 10; i++) {
            if (avail[i]) {
                is_impossible = false;
                break;
            }
        }

        if (is_impossible) {
            return -1;
        }

        while (true) {
            if (all_available(num, avail)) {
                return num;
            }
            num++;
        }
    }
}
