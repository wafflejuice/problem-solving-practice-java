import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1697_숨바꼭질 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> positions = new LinkedList<>();
        Queue<Integer> times = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();

        positions.add(n);
        times.add(0);

        while (!positions.isEmpty()) {
            int position = positions.remove();
            int time = times.remove();

            if (position == k) {
                System.out.println(time);
                break;
            }

            visit.add(position);

            if (!visit.contains(position - 1) && 0 <= position - 1 && position - 1 <= 100000) {
                positions.add(position - 1);
                times.add(time + 1);
            }
            if (!visit.contains(position + 1) && 0 <= position + 1 && position + 1 <= 100000) {
                positions.add(position + 1);
                times.add(time + 1);
            }
            if (!visit.contains(position * 2) && 0 <= position * 2 && position * 2 <= 100000) {
                positions.add(position * 2);
                times.add(time + 1);
            }
        }
    }
}
