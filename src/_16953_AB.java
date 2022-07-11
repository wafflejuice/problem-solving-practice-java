import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16953_AB {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(calc(a, b));
    }

    static int calc(int a, int b) {

        int boundary = 1000000000;
        int curr;
        int cnt;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> cnts = new LinkedList<>();
        queue.add(a);
        cnts.add(1);

        while (!queue.isEmpty()) {
            curr = queue.poll();
            cnt = cnts.poll();

            if (curr == b) {
                return cnt;
            }

            if (curr * 2 <= boundary) {
                queue.add(curr * 2);
                cnts.add(cnt + 1);
            }
            if (curr <= (boundary - 1) / 10) {
                queue.add(curr * 10 + 1);
                cnts.add(cnt + 1);
            }
        }

        return -1;
    }
}
