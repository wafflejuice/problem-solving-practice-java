import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11725_트리의_부모_찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new LinkedList<>());
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        int[] parents = new int[n + 1];

        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (visit[curr]) {
                continue;
            }
            visit[curr] = true;

            for (int adj : graph.get(curr)) {
                if (!visit[adj]) {
                    parents[adj] = curr;
                    q.add(adj);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }
}
