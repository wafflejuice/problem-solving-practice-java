import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053_가장_긴_증가하는_부분_수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] monoIncreaseArr = new int[n];

        st = new StringTokenizer(br.readLine());
        int curr, idx;
        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            curr = Integer.parseInt(st.nextToken());
            idx = findIdx(monoIncreaseArr, curr, n);
            monoIncreaseArr[idx] = curr;
            maxIdx = Math.max(maxIdx, idx);
        }

        System.out.println(maxIdx + 1);
    }

    static int findIdx(int[] arr, int val, int hi) {
        for (int i = 0; i < hi; i++) {
            if (arr[i] == 0 || arr[i] >= val) {
                return i;
            }
        }

        return hi;
    }
}
