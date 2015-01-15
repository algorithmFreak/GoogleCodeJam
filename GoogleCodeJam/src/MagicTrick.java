import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MagicTrick {

	public static void main(String[] args) {
		MagicTrick m = new MagicTrick();
		try {
			FileReader fr = new FileReader(
					new File(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\A-small-attempt1.in"));
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(
					new FileWriter(
							"C:\\Users\\RAHUL\\workspace\\GoogleCodeJam\\src\\Output.in"));
			String out;
			int N = Integer.parseInt(br.readLine());
			for (int t = 1; t <= N; t++) {
				String[] xArray = null;
				String[] yArray = null;
				int x = Integer.parseInt(br.readLine());
				for (int i = 1; i <= 4; i++) {
					if (i == x) {
						xArray = br.readLine().split("\\ ");
					} else {
						br.readLine();
					}
				}
				int y = Integer.parseInt(br.readLine());

				for (int i = 1; i <= 4; i++) {
					if (i == y) {
						yArray = br.readLine().split("\\ ");
					} else {
						br.readLine();
					}
				}
				out = m.solution(xArray, yArray);
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

	public String solution(String[] xArray, String[] yArray) {
		int count = 0;
		String match = null;
		for (String x : xArray) {
			for (String y : yArray) {
				if (x.equals(y)) {
					count++;
					match = x;
					break;
				}
			}
		}
		if (count == 0) {
			return "Volunteer cheated!";
		} else if (count == 1) {
			return match;
		} else {
			return "Bad magician!";
		}
	}

}
