import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열의 개수(n)를 입력받음
        int n = Integer.parseInt(br.readLine());
        // 배열을 문자열로 입력받음
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        // 배열 선언
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int counter = findLongest(arr, n);
        System.out.printf(String.valueOf(counter));
    }

    public static int findLongest(int[] arr, int n) {
        int[] dp = new int[n];
        int max_length, length;

        for (int ind = 0; ind < n; ind++) {
            max_length = 1;
            for (int i = 0; i < ind; i++) {
                if (arr[ind] > arr[i]) {
                    length = dp[i] + 1;
                    if (length > max_length) {
                        max_length = length;
                    }
                }
            }
            dp[ind] = max_length;
        }

        return findMax(dp, n);
    }

    public static int findMax(int[] dp, int n) {
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }

        return maxLength;
    }
}
