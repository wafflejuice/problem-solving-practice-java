import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class _2805_나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(heights);

        for (int h = heights[n - 1]; h >= 0; h--) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (heights[n - 1 - i] > h) {
                    sum += heights[n - 1 - i] - h;
                } else {
                    break;
                }
            }
            if (sum >= m) {
                bw.write(Integer.toString(h));
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
