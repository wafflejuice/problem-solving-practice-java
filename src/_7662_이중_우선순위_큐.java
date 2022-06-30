import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _7662_이중_우선순위_큐 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int ti = 0; ti < t; ti++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            TreeMap<Integer, Integer> queue = new TreeMap<>();

            for (int ki = 0; ki < k; ki++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    if (queue.containsKey(val)) {
                        queue.put(val, queue.get(val) + 1);
                    } else {
                        queue.put(val, 1);
                    }
                } else if (op.equals("D")) {
                    if (queue.isEmpty()) {
                        continue;
                    }

                    Map.Entry<Integer, Integer> entry;
                    if (val == 1) {
                        entry = queue.lastEntry();
                    } else {
                        entry = queue.firstEntry();
                    }

                    if (entry.getValue() == 1) {
                        queue.remove(entry.getKey());
                    } else {
                        queue.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
            }

            if (queue.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(queue.lastEntry().getKey() + " " + queue.firstEntry().getKey());
            }
        }
    }
}
