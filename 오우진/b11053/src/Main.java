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

        // 입력받은 배열 문자열을 토큰별로 나누고 이를 arr 배열에 추가
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // findLongest 메서드를 이용해 가장 긴 수열 찾음
        int counter = findLongest(arr, n);
        System.out.printf(String.valueOf(counter));
    }

    //dp를 이용한 가장 긴 수열 찾는 메서드
    public static int findLongest(int[] arr, int n) {
        int[] dp = new int[n];
        // 수열의 길이와 가장 긴 수열의 길이를 담을 변수
        int max_length, length;

        // 가장 긴 수열의 길이를 찾을 인덱스(ind)를 지정
        for (int ind = 0; ind < n; ind++) {
            max_length = 1;
            // 가장 긴 수열의 길이를 찾을 인덱스보다 더 전에 위치한 수 중 arr[ind]보다 더 작은 수를 찾고, 그것을 이용해 dp 업데이트
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

        // dp 배열에서 가장 큰 값 찾기
        return findMax(dp, n);
    }

    // 더 큰 값 찾는 메서드
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
