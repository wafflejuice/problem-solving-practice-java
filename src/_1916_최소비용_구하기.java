import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1916_최소비용_구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        List<Map<Integer, Integer>> graph = new ArrayList<>();
        graph.add(null);
        for (int i = 0; i < n; i++) {
            graph.add(new HashMap<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (graph.get(start).containsKey(end)) {
                if (dist < graph.get(start).get(end)) {
                    graph.get(start).put(end, dist);
                }
            } else {
                graph.get(start).put(end, dist);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(calcMinDist(n, graph, start, end));
    }

    static long calcMinDist(int n, List<Map<Integer, Integer>> graph, int start, int end) {

        int[] minDist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            minDist[i] = 100000000;
        }
        minDist[start] = 0;

        Queue<Integer> newUpdate = new LinkedList<>();
        newUpdate.add(start);

        while (!newUpdate.isEmpty()) {
            int curr = newUpdate.poll();
            for (int adj : graph.get(curr).keySet()) {
                int newDist = minDist[curr] + graph.get(curr).get(adj);
                if (newDist < minDist[adj]) {
                    minDist[adj] = newDist;
                    newUpdate.add(adj);
                }
            }
        }

        return minDist[end];
    }
}
