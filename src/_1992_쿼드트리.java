import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1992_쿼드트리 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        char[][] pixels = new char[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            char[] row = st.nextToken().toCharArray();
            for (int x = 0; x < n; x++) {
                pixels[y][x] = row[x];
            }
        }

        System.out.println(zip(pixels, 0, 0, n));
    }

    static boolean isUniform(char[][] pixels, int yBegin, int xBegin, int size) {
        char pixel = pixels[yBegin][xBegin];

        for (int dy = 0; dy < size; dy++) {
            for (int dx = 0; dx < size; dx++) {
                if (pixel != pixels[yBegin + dy][xBegin + dx]) {
                    return false;
                }
            }
        }

        return true;
    }

    static String zip(char[][] pixels, int yBegin, int xBegin, int size) {
        if (isUniform(pixels, yBegin, xBegin, size)) {
            return Character.toString(pixels[yBegin][xBegin]);
        }

        StringBuilder sb = new StringBuilder();
        int new_size = size/2;
        sb.append("(");
        sb.append(zip(pixels, yBegin, xBegin, new_size));
        sb.append(zip(pixels, yBegin, xBegin+new_size, new_size));
        sb.append(zip(pixels, yBegin+new_size, xBegin, new_size));
        sb.append(zip(pixels, yBegin+new_size, xBegin+new_size, new_size));
        sb.append(")");

        return sb.toString();
    }
}
