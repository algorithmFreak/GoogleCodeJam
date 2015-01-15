import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NewLotteryGame {

	public static void main(String[] args) {
		NewLotteryGame c = new NewLotteryGame();
		try {
			FileReader fr = new FileReader(
					new File(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\B-large-practice.in"));
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(
					new FileWriter(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Output.in"));
			long out;
			int T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {
				String[] arr = br.readLine().split("\\ ");
				int A = Integer.parseInt(arr[0]);
				int B = Integer.parseInt(arr[1]);
				int K = Integer.parseInt(arr[2]);
				out = c.solution(A, B, K);
				System.out.println("Case #" + t + ": " + out);
				pw.write("Case #" + t + ": " + out + "\n");
			}
			br.close();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long solution(long A, long B, long K) {
		long count = 0;
		if ((K >= A && K >= B) || (K >= A && K < B) || (K < A && K >= B)) {
			return A * B;
		} else if (K < A && K < B) {
			count = (long) (K * K) + (long) (K * (B - K))
					+ (long) ((A - K) * K);

			for (long a = K; a < A; a++) {
				for (long b = K; b < B; b++) {
					if ((a & b) < K) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
