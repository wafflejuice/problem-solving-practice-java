import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2096_내려가기 {

    public static void main(String[]args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] maxPre = new int[3];
        int[] maxTmp = new int[3];
        int[] minPre = new int[3];
        int[] minTmp = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int val = Integer.parseInt(st.nextToken());
                maxTmp[j] = getPreMax(j, maxPre) + val;
                minTmp[j] = getPreMin(j, minPre) + val;
            }

            System.arraycopy(maxTmp, 0, maxPre, 0, 3);
            System.arraycopy(minTmp, 0, minPre, 0, 3);
        }

        System.out.println(Arrays.stream(maxPre).max().getAsInt() + " " + Arrays.stream(minPre).min().getAsInt());
    }

    static int getPreMax(int idx, int[] pre) {
        if (idx == 0) {
            return Math.max(pre[idx], pre[idx + 1]);
        }

        if (idx == 1) {
            return Math.max(Math.max(pre[idx - 1], pre[idx]), pre[idx + 1]);
        }

        return Math.max(pre[idx - 1], pre[idx]);
    }

    static int getPreMin(int idx, int[] pre) {
        if (idx == 0) {
            return Math.min(pre[idx], pre[idx + 1]);
        }

        if (idx == 1) {
            return Math.min(Math.min(pre[idx - 1], pre[idx]), pre[idx + 1]);
        }

        return Math.min(pre[idx - 1], pre[idx]);
    }
}
